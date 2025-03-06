import entity.SeoWebsite;
import entity.Website;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataFetcher {
    private static final String DIRECTORY_PATH = "results/";

    private static void saveSeoData(String data, Website website, SeoWebsite seoWebsite) {
        final String websiteName = website.getName();
        final String seoWebsiteName = seoWebsite.getName();
        final Random rdm = new Random();
        final int number = rdm.nextInt(10000);
        final String path = websiteName + "-" + seoWebsiteName + "-" + number + ".json";

        Path directory = Paths.get(DIRECTORY_PATH);
        Path filePath = directory.resolve(path);

        try {
            Files.write(filePath, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Saved response to " + path);
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }
    public static void getSeoData(Website website, SeoWebsite seoWebsite) {
        final String websiteURL = website.getURL();
        final String seoWebsiteURL = seoWebsite.getURL();
        final String apiKey = "";

        try {
            URL url = new URL(seoWebsiteURL + "/seocheck?apikey=" + apiKey + "&url=" + websiteURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String jsonResponse = new String(connection.getInputStream().readAllBytes());
                saveSeoData(jsonResponse, website, seoWebsite);
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


