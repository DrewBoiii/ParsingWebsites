package task.drew.parsingwebsite.web.filter.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import task.drew.parsingwebsite.persistence.model.WebSite;
import task.drew.parsingwebsite.web.filter.criteria.WebSiteCriteria;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSiteSpecification implements Specification<WebSite> {

    private WebSiteCriteria webSiteCriteria;

    @Override
    public Predicate toPredicate(Root<WebSite> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(webSiteCriteria.getName() != null && !webSiteCriteria.getName().isEmpty()){
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("targetUrl")),
                            webSiteCriteria.getName().toUpperCase()
                    )
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
