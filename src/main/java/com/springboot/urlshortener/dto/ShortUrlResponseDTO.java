package com.springboot.urlshortener.dto;

import com.springboot.urlshortener.entity.ShortUrl;
import lombok.Data;

@Data
public class ShortUrlResponseDTO {
    private String shortcode;
    private String originalUrl;
    public ShortUrlResponseDTO(ShortUrl shortUrl) {
        this.shortcode = shortUrl.getShortcode();
        this.originalUrl = shortUrl.getOriginalUrl();
    }
}
