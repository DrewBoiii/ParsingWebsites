package task.drew.parsingwebsite.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.drew.parsingwebsite.persistence.dao.WebSiteRepository;
import task.drew.parsingwebsite.persistence.model.WebSite;

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
        WebSite savedWebSite = webSiteRepository.save(webSite);
        log.info("Saved website is " + savedWebSite.toString());
    }
}
