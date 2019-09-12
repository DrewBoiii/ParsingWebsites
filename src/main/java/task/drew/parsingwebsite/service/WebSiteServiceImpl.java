package task.drew.parsingwebsite.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.drew.parsingwebsite.persistence.dao.WebSiteRepository;
import task.drew.parsingwebsite.persistence.model.WebSite;

import java.io.IOException;

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
        parse(webSite);

//        WebSite savedWebSite = webSiteRepository.save(webSite);
//        log.info("Saved website is " + savedWebSite.toString());
    }

    private void parse(WebSite webSite){
        try {
            Document document = Jsoup.connect(webSite.getTargetUrl()).get();
            log.info("Document title is " + document.title());
            Elements links = document.select("a");

            for (Element element : links) {
                log.info("link: " + element.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
