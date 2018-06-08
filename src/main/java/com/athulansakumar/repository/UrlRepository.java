package com.athulansakumar.repository;

import com.athulansakumar.entity.UrlEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntry,String> {

    UrlEntry findByShortUrl(String shortUrl);
}
