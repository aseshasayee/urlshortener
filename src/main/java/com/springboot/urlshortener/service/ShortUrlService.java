package com.springboot.urlshortener.service;

import com.springboot.urlshortener.entity.ShortUrl;
import com.springboot.urlshortener.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public ShortUrl createShortUrl(ShortUrl shortUrl) {
        String shortcode = generateShortcode();
        shortUrl.setShortcode(shortcode);
        return shortUrlRepository.save(shortUrl);
    }

    public ShortUrl getShortUrlByShortcode(String shortcode) {
        return shortUrlRepository.findByShortcode(shortcode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
    }

    public void incrementAccessCount(String shortcode) {
        ShortUrl shortUrl = getShortUrlByShortcode(shortcode);
        shortUrl.setAccessCount(shortUrl.getAccessCount() + 1);
        shortUrlRepository.save(shortUrl);
    }

    public void deleteShortUrl(String shortcode) {
        ShortUrl shortUrl = getShortUrlByShortcode(shortcode);
        shortUrlRepository.delete(shortUrl);
    }

    private String generateShortcode() {
        return java.util.UUID.randomUUID().toString().substring(0, 5);
    }

    public boolean validateLongUrl(String longUrl) {
        try {
            new java.net.URL(longUrl);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
