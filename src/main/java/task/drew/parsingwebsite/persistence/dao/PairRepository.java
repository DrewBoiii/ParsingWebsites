package task.drew.parsingwebsite.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import task.drew.parsingwebsite.persistence.model.Pair;
import task.drew.parsingwebsite.persistence.model.WebSite;
import task.drew.parsingwebsite.web.filter.criteria.WebSiteCriteria;

import java.util.List;

public interface PairRepository extends JpaRepository<Pair, Long>, JpaSpecificationExecutor<Pair> {



}
