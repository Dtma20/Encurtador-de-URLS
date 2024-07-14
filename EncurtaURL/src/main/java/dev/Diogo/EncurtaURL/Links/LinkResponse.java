package dev.Diogo.EncurtaURL.Links;
import java.time.LocalDateTime;

public class LinkResponse {
    private Long id;
    private String longUrl;
    private String shortUrl;
    private LocalDateTime urlCreatedAt;

    public LinkResponse(Long id, String longUrl, String shortUrl, LocalDateTime urlCreatedAt) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.urlCreatedAt = urlCreatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getUrlCreatedAt() {
        return urlCreatedAt;
    }

    public void setUrlCreatedAt(LocalDateTime urlCreatedAt) {
        this.urlCreatedAt = urlCreatedAt;
    }
}
