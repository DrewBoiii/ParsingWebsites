package task.drew.parsingwebsite.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import task.drew.parsingwebsite.persistence.model.WebSite;

import java.util.List;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {



}
