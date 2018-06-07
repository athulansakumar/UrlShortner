package com.athulansakumar.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlShortnerController {

    private static final Logger logger = LoggerFactory.getLogger(UrlShortnerController.class);

    @RequestMapping(value = "/{url}", method = RequestMethod.GET)
    public void index(@PathVariable("url") String url,HttpServletResponse httpServletResponse) {
        logger.debug("redirecting to --> "+url);
        try {
            httpServletResponse.sendRedirect("http://google.com");
        } catch (IOException e) {
            logger.error("Exception while redirect",e);
        }
    }

    /*@RequestMapping(value = "/create}", method = RequestMethod.POST)
    public String createShortUrl(@RequestBody String url) {
        logger.debug("creating url for --> "+url);
        String shortUrl = "new ShortUrl";
        return shortUrl;
    }*/
}
