package task.drew.parsingwebsite.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String value;

    public Long quantity;

}
