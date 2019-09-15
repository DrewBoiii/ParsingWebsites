package task.drew.parsingwebsite.persistence.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import task.drew.parsingwebsite.constraint.anotation.ValidUrl;
import task.drew.parsingwebsite.util.Parser;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
@Entity
public class WebSite implements Comparable<WebSite> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ValidUrl
    @NotBlank
    private String targetUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "websites_pairs",
            joinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pair_id", referencedColumnName = "id"))
//    @MapKey(name = "value")
    private Map<String, Pair> uniqueContent;

    public void merge(Map<String, Pair> content){
        for (String word : content.keySet()) {
            Parser.addIfNotExists(uniqueContent, word);
        }
    }

    @Override
    public int compareTo(WebSite o) {
        return this.id.compareTo(o.id);
    }
}
