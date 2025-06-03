package com.springboot.urlshortener.controller;

import com.springboot.urlshortener.dto.ShortUrlRequestDTO;
import com.springboot.urlshortener.dto.ShortUrlResponseDTO;
import com.springboot.urlshortener.entity.ShortUrl;
import com.springboot.urlshortener.service.ShortUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping("/shorten")
    public ShortUrlResponseDTO createShortUrl(@RequestBody ShortUrlRequestDTO request) {
        String longUrl = request.getUrl();

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(longUrl);
        ShortUrl savedShortUrl = shortUrlService.createShortUrl(shortUrl);
        return new ShortUrlResponseDTO(savedShortUrl);
    }

    @GetMapping("/{shortcode}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortcode) {
        ShortUrl shortUrl = shortUrlService.getShortUrlByShortcode(shortcode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(shortUrl.getOriginalUrl()))
                .build();
    }


}
