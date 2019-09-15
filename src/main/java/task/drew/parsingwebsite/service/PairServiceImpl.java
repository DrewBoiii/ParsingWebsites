package task.drew.parsingwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.drew.parsingwebsite.persistence.dao.PairRepository;
import task.drew.parsingwebsite.persistence.model.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PairServiceImpl implements PairService {

    private PairRepository pairRepository;

    @Autowired
    public PairServiceImpl(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    @Override
    public List<Pair> getPairs() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(pairRepository.findAll().iterator(), Spliterator.NONNULL), false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
