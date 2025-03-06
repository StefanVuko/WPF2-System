package entity.Seobility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class SeoResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;
    private String analysedurl;
    private String thumbnailurl;

    @OneToOne(cascade = CascadeType.ALL)
    private QuickFacts quickfacts;

    @OneToOne(cascade = CascadeType.ALL)
    private GroupResults groupresults;

    @OneToMany(mappedBy = "seoResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hint> hints;

    @OneToMany(mappedBy = "seoResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Keyword> keywords;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAnalysedurl() {
        return analysedurl;
    }

    public void setAnalysedurl(String analysedurl) {
        this.analysedurl = analysedurl;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    public QuickFacts getQuickfacts() {
        return quickfacts;
    }

    public void setQuickfacts(QuickFacts quickfacts) {
        this.quickfacts = quickfacts;
    }

    public GroupResults getGroupresults() {
        return groupresults;
    }

    public void setGroupresults(GroupResults groupresults) {
        this.groupresults = groupresults;
    }

    public List<Hint> getHints() {
        return hints;
    }

    public void setHints(List<Hint> hints) {
        this.hints = hints;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }
}
