package entity.Seobility;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private int score;

    @ManyToOne
    @JoinColumn(name = "seo_result_id", nullable = false)
    private SeoResult seoResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public SeoResult getSeoResult() {
        return seoResult;
    }

    public void setSeoResult(SeoResult seoResult) {
        this.seoResult = seoResult;
    }
}
