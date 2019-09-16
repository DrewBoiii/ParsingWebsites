package task.drew.parsingwebsite.persistence.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Pair implements Comparable<Pair> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    private Long quantity;

    public Pair(String value, Long quantity){
        this.value = value;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Pair o) {
        return this.value.compareTo(o.value);
    }
}
