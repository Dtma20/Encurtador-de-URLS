package dev.Diogo.EncurtaURL.Links;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String longUrl;
    private String shortUrl;
    private LocalDateTime urlCreatedAt;
    public Link(long id,String longUrl, String shortUrl, LocalDateTime urlCreatedAt) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.urlCreatedAt = urlCreatedAt;
    }

    public Link() {

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
