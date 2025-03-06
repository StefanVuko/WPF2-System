import comparer.SeobilityComparer;
import dao.SeoWebsiteDAO;
import dao.SeobilityDAO;
import dao.WebsiteDAO;
import entity.SeoWebsite;
import entity.Seobility.SeoResult;
import entity.Website;

public class Main {
    public static void main(String[] args) {

        /*SeoWebsite seoWebsite = new SeoWebsite("https://www.seobility.net/", "seobility");
        SeoWebsiteDAO seoWebsiteDAO = new SeoWebsiteDAO();
        seoWebsiteDAO.persist(seoWebsite);

        Website firstWebsite = new Website("https://www.anandtech.com/", "anandtech");
        Website secondWebsite = new Website("https://www.borisgloger.com/blog/hardware", "borisgloger");
        WebsiteDAO websiteDAO = new WebsiteDAO();
        websiteDAO.persist(firstWebsite);
        websiteDAO.persist(secondWebsite);*/

        //DataFetcher.getSeoData(firstWebsite, seoWebsite);
        //DataFetcher.getSeoData(secondWebsite, seoWebsite);


        //DataParser.loadAndSaveSeoResult("anandtech-seobility-4444.json");
        SeobilityDAO dao = new SeobilityDAO();
        SeoResult result1 = dao.findById(1L);
        SeoResult result2 = dao.findById(2L);

        SeobilityComparer.compareSeoResults(result1, result2);

    }
}
