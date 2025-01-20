import dao.SeoDataDAO;
import entity.SeoData;
import entity.SeoWebsite;
import entity.Website;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataFetcher {
    public static void getSeoData(Website website, SeoWebsite seoWebsite) {
        try {
            String apiKey = "";
            String urlString = "https://api.seobility.net/en/resellerapi/seocheck?apikey=" + apiKey + "&url=" + website.getURL();

            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Response: " + response.toString());

                SeoDataDAO dao = new SeoDataDAO();
                dao.persist(new SeoData());

            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void getSeoData(Website website, SeoWebsite seoWebsite, long intervalInHours) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            getSeoData(website, seoWebsite);
        };

        scheduler.scheduleAtFixedRate(task, 0, intervalInHours, TimeUnit.HOURS);
    }
}


