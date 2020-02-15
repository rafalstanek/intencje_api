package rafista.intencje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rafista.intencje.model.Intention;
import rafista.intencje.repository.IntentionRepository;
import rafista.intencje.serviceInterface.IntentionServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service(value = "intentionService")
public class IntentionService implements IntentionServiceInterface {
    @Autowired
    IntentionRepository intentionRepository;

    @Override
    public List<Intention> findAll() {
        List<Intention> list = new ArrayList<>();
        intentionRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Intention save(Intention intention) {
        return intentionRepository.save(intention);
    }

    @Override
    public Optional<Intention> findById(UUID id) {
        return intentionRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        intentionRepository.deleteById(id);
    }
}
