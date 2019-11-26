package task.drew.parsingwebsite.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import task.drew.parsingwebsite.persistence.model.WebSite;

import java.awt.print.Pageable;
import java.util.List;

public interface WebSiteService {

    void save(WebSite webSite);
    List<WebSite> getWebSites();
    Page<WebSite> getWebSitesBySpecification(Specification<WebSite> webSiteSpecification, Pageable pageable);

}
