package com.athulansakumar.entity;

import org.bson.types.ObjectId;

public class UrlEntry {

    private String id;
    private String longUrl;
    private String shortUrl;

    public UrlEntry() {
    }

    public UrlEntry(String longUrl) {
        this.longUrl = longUrl;
        this.id = new ObjectId().toHexString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "UrlEntry{" +
                "id='" + id + '\'' +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
