package task.drew.parsingwebsite.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Pair implements Comparable<Pair> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    private Long quantity;

    public Pair(){}

    public Pair(String value, Long quantity){
        this.value = value;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Pair o) {
        return this.value.compareTo(o.value);
    }
}
