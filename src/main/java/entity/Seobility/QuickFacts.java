package entity.Seobility;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuickFacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loadtime;
    private String filesize;
    private int words;
    private int mediafiles;
    private int internallinks;
    private int externallinks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoadtime() {
        return loadtime;
    }

    public void setLoadtime(String loadtime) {
        this.loadtime = loadtime;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getMediafiles() {
        return mediafiles;
    }

    public void setMediafiles(int mediafiles) {
        this.mediafiles = mediafiles;
    }

    public int getInternallinks() {
        return internallinks;
    }

    public void setInternallinks(int internallinks) {
        this.internallinks = internallinks;
    }

    public int getExternallinks() {
        return externallinks;
    }

    public void setExternallinks(int externallinks) {
        this.externallinks = externallinks;
    }
}