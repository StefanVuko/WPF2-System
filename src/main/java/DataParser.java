import com.fasterxml.jackson.databind.ObjectMapper;
import dao.SeobilityDAO;
import entity.Seobility.Hint;
import entity.Seobility.Keyword;
import entity.Seobility.SeoResult;

import java.io.File;
import java.io.IOException;

public class DataParser {
    public static void loadAndSaveSeoResult(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("results/" + path); // Adjust path if needed
            SeoResult seoResult = objectMapper.readValue(file, SeoResult.class);

            for (Hint hint : seoResult.getHints()) {
                hint.setSeoResult(seoResult);
            }

            for (Keyword keyword : seoResult.getKeywords()) {
                keyword.setSeoResult(seoResult);
            }

            SeobilityDAO dao = new SeobilityDAO();
            dao.persist(seoResult);
            System.out.println("SEO Result saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
