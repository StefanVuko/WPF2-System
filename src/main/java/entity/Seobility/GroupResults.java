package entity.Seobility;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreMeta meta;

    @OneToOne(cascade = CascadeType.ALL)
    private ScorePageQuality pagequality;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreStructure structure;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreLinks links;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreServer server;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreExtern extern;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScoreMeta getMeta() {
        return meta;
    }

    public void setMeta(ScoreMeta meta) {
        this.meta = meta;
    }

    public ScorePageQuality getPagequality() {
        return pagequality;
    }

    public void setPagequality(ScorePageQuality pagequality) {
        this.pagequality = pagequality;
    }

    public ScoreStructure getStructure() {
        return structure;
    }

    public void setStructure(ScoreStructure structure) {
        this.structure = structure;
    }

    public ScoreLinks getLinks() {
        return links;
    }

    public void setLinks(ScoreLinks links) {
        this.links = links;
    }

    public ScoreServer getServer() {
        return server;
    }

    public void setServer(ScoreServer server) {
        this.server = server;
    }

    public ScoreExtern getExtern() {
        return extern;
    }

    public void setExtern(ScoreExtern extern) {
        this.extern = extern;
    }
}