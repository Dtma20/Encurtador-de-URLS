package dev.Diogo.EncurtaURL.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {
    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }
    @PostMapping("/encurtar")
    public ResponseEntity<LinkResponse> gerarUrlEncurtada(@RequestBody Map<String, String> resquest) {
        String urlOriginal = resquest.get("urlOriginal");
        Link link = linkService.encurtarUrl(urlOriginal);
        String gerarUrlDeRedirecionamento = "http://localhost:8081/r/" + link.getShortUrl();
        LinkResponse linkResponse = new LinkResponse(link.getId(), link.getLongUrl(), gerarUrlDeRedirecionamento, link.getUrlCreatedAt());
        return ResponseEntity.status(HttpStatus.CREATED).body(linkResponse);
    }

    @GetMapping("/r/{shortUrl}")
    public void redirecionarUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        Link link = linkService.obterUrlOriginal(shortUrl);
        if(link != null) {
            response.sendRedirect(link.getLongUrl());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
