package task.drew.parsingwebsite.service;

import task.drew.parsingwebsite.persistence.model.WebSite;

import java.util.List;

public interface WebSiteService {

    void save(WebSite webSite);
    List<WebSite> getWebSites();

}
