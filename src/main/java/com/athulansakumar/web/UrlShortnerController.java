package com.athulansakumar.web;

import com.athulansakumar.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

@RestController
public class UrlShortnerController {

    private static final Logger logger = LoggerFactory.getLogger(UrlShortnerController.class);

    @Autowired
    private UrlService service;

    @Value("${defaultHomePage.path}")
    private String defaultHomePage;

    @Value("${defaultAppRoot.path}")
    private String defaultAppRoot;

    @RequestMapping(value = "/{url}", method = RequestMethod.GET)
    public void index(@PathVariable("url") String url,HttpServletResponse httpServletResponse) {
        try {
            String longUrl = service.findUrlByShortUrl(url);
            logger.debug("redirecting to --> "+longUrl);
            httpServletResponse.sendRedirect(longUrl);
        } catch (Exception e) {
            logger.error("Exception while redirect",e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void home(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect(defaultHomePage);
        } catch (Exception e) {
            logger.error("Exception while redirect",e);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createShortUrl(@RequestBody String url) {

        String shortUrl = "";
        try {
            url = URLDecoder.decode(url, "UTF-8");
            logger.debug("creating url for --> "+url);
            shortUrl = defaultAppRoot+service.createNewShortUrl(url);
        }catch (Exception e){
            logger.error("Error occurred while creating short url",e);
        }
        return shortUrl;
    }
}
