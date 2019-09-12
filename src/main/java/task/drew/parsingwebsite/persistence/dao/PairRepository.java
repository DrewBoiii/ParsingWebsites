package task.drew.parsingwebsite.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import task.drew.parsingwebsite.persistence.model.Pair;

public interface PairRepository extends JpaRepository<Pair, Long> {
}
