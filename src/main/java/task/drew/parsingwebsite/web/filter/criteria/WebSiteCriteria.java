package task.drew.parsingwebsite.web.filter.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSiteCriteria {

    public static final String DEFAULT_SORTING_CRITERIA = "quantity";

    private String name;

    private String sort = DEFAULT_SORTING_CRITERIA;

}
