package task.drew.parsingwebsite.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String targetUrl;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "websites_pairs",
            joinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pair_id", referencedColumnName = "id"))
    public Map<String, Pair> uniqueContent;

}
