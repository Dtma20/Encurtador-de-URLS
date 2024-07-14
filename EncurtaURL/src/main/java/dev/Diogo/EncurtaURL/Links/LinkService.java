package dev.Diogo.EncurtaURL.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    public String gerarUrlAleatoria() {
        return RandomStringUtils.randomAlphanumeric(5,10);
    }
    public Link encurtarUrl(String url) {
        Link link = new Link();
        link.setLongUrl(url);
        link.setShortUrl(gerarUrlAleatoria());
        link.setUrlCreatedAt(LocalDateTime.now());
        return linkRepository.save(link);
    }
    public Link obterUrlOriginal(String shortUrl) {
        try {
            return linkRepository.findByShortUrl(shortUrl);
        } catch (Exception e) {
            throw new RuntimeException("URL não encontrada");
        }
    }
}
