package com.athulansakumar.service;

import com.athulansakumar.entity.UrlEntry;
import com.athulansakumar.repository.UrlRepository;
import com.athulansakumar.web.UrlShortnerController;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private static final Logger logger = LoggerFactory.getLogger(UrlShortnerController.class);

    @Autowired
    private UrlRepository repository;

    public String findUrlByShortUrl(String shortUrl){
        try {
            UrlEntry url = repository.findByShortUrl(shortUrl);
            if(null!=url){
                return url.getLongUrl();
            }
        }catch (Exception e){
            logger.error("Exception in findUrlByShortUrl",e);
        }
        return null;
    }

    public String createNewShortUrl(String longUrl){
        UrlEntry url = new UrlEntry(longUrl);
        try {
            String shortUrl = generateShortUrl(url.getId());
            url.setShortUrl(shortUrl);
            repository.save(url);
        }catch (Exception e){
            logger.error("Exception in createNewShortUrl",e);
        }
        return url.getShortUrl();
    }

    private String generateShortUrl(String id) {
        return new ObjectId(id).toHexString();
    }
}
