package entity.Seobility;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private int priority;

    @ManyToOne
    @JoinColumn(name = "seo_result_id", nullable = false)
    private SeoResult seoResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public SeoResult getSeoResult() {
        return seoResult;
    }

    public void setSeoResult(SeoResult seoResult) {
        this.seoResult = seoResult;
    }
}
