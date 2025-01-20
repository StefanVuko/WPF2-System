import dao.SeoDataDAO;
import dao.SeoWebsiteDAO;
import dao.WebsiteDAO;
import entity.SeoData;
import entity.SeoWebsite;
import entity.Website;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Website firstWebsite = new Website("https://www.anandtech.com/");
        Website secondWebsite = new Website("https://www.borisgloger.com/blog/hardware");
        WebsiteDAO websiteDAO = new WebsiteDAO();
        websiteDAO.persist(firstWebsite);
        websiteDAO.persist(secondWebsite);

        SeoWebsite seoWebsite = new SeoWebsite("https://www.seobility.net/");
        SeoWebsiteDAO seoWebsiteDAO = new SeoWebsiteDAO();
        seoWebsiteDAO.persist(seoWebsite);


        //Here would be the API requests
        SeoData seoData = new SeoData(95, 5f,
                5f, 4000, 200, 100, 100,
                firstWebsite, seoWebsite);
        SeoDataDAO seoDataDAO = new SeoDataDAO();
        seoDataDAO.persist(seoData);
    }
}
