package task.drew.parsingwebsite.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Data
@Entity
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String targetUrl;

    public Map<String, String> uniqueContent;



}
