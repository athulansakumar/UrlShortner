package com.athulansakumar.web;

import com.athulansakumar.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlShortnerController {

    private static final Logger logger = LoggerFactory.getLogger(UrlShortnerController.class);

    @Autowired
    private UrlService service;

    @RequestMapping(value = "/{url}", method = RequestMethod.GET)
    public void index(@PathVariable("url") String url,HttpServletResponse httpServletResponse) {
        try {
            String longUrl = service.findUrlByShortUrl(url);
            logger.debug("redirecting to --> "+longUrl);
            httpServletResponse.sendRedirect(longUrl);
        } catch (IOException e) {
            logger.error("Exception while redirect",e);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createShortUrl(@RequestBody String url) {
        logger.debug("creating url for --> "+url);
        String shortUrl = service.createNewShortUrl(url);
        return shortUrl;
    }
}
