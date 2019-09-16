package task.drew.parsingwebsite.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import task.drew.parsingwebsite.constraint.anotation.ValidUrl;
import task.drew.parsingwebsite.util.Parser;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
@Entity
@ToString
@EqualsAndHashCode
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
    // TODO: 16.09.2019 find out how to deal with persisting maps more detailed
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
