package entity;

import jakarta.persistence.*;

@Entity
public class SeoData {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int score;
    @Column
    private float loadTime;
    @Column
    private float fileSize;
    @Column
    private int words;
    @Column
    private int mediaFiles;
    @Column
    private int internalLinks;
    @Column
    private int externalLinks;
    @ManyToOne @JoinColumn
    private Website website;

    @ManyToOne @JoinColumn
    private SeoWebsite seoWebsite;

    public SeoData() {

    }

    public SeoData(int score, float loadTime, float fileSize, int words, int mediaFiles, int internalLinks, int externalLinks, Website website, SeoWebsite seoWebsite) {
        this.score = score;
        this.loadTime = loadTime;
        this.fileSize = fileSize;
        this.words = words;
        this.mediaFiles = mediaFiles;
        this.internalLinks = internalLinks;
        this.externalLinks = externalLinks;
        this.website = website;
        this.seoWebsite = seoWebsite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(float loadTime) {
        this.loadTime = loadTime;
    }

    public float getFileSize() {
        return fileSize;
    }

    public void setFileSize(float fileSize) {
        this.fileSize = fileSize;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(int mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public int getInternalLinks() {
        return internalLinks;
    }

    public void setInternalLinks(int internalLinks) {
        this.internalLinks = internalLinks;
    }

    public int getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(int externalLinks) {
        this.externalLinks = externalLinks;
    }
}
