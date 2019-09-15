package task.drew.parsingwebsite.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.drew.parsingwebsite.persistence.dao.WebSiteRepository;
import task.drew.parsingwebsite.persistence.model.Pair;
import task.drew.parsingwebsite.persistence.model.WebSite;
import task.drew.parsingwebsite.util.HtmlTag;
import task.drew.parsingwebsite.util.Parser;

import java.util.*;

@Slf4j
@Service
public class WebSiteServiceImpl implements WebSiteService {

    private final WebSiteRepository webSiteRepository;

    @Autowired
    public WebSiteServiceImpl(WebSiteRepository webSiteRepository) {
        this.webSiteRepository = webSiteRepository;
    }

    @Override
    public void save(WebSite webSite) {
        webSite.setUniqueContent(new TreeMap<>());

        parse(webSite);

        log.info("WebSite to save: " + webSite.toString());

        WebSite savedWebSite = webSiteRepository.save(webSite);

        log.info("Saved website is " + savedWebSite.toString());
    }

    private void parse(WebSite webSite){
        Map<String, Pair> uniqueContent;

        for (HtmlTag tag : HtmlTag.values()) {
            uniqueContent = Parser.parseTag(webSite.getTargetUrl(), tag.getName());
            webSite.merge(uniqueContent);
        }
    }
}
