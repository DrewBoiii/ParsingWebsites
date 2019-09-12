package task.drew.parsingwebsite.persistence.model;

import lombok.Data;
import task.drew.parsingwebsite.constraint.anotation.ValidUrl;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
@Entity
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ValidUrl
    @NotBlank
    public String targetUrl;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "websites_pairs",
            joinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pair_id", referencedColumnName = "id"))
    public Map<String, Pair> uniqueContent;

}
