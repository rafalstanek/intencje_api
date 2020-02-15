package rafista.intencje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rafista.intencje.model.Intention;
import rafista.intencje.repository.IntentionRepository;
import rafista.intencje.serviceInterface.IntentionServiceInterface;

import java.sql.Timestamp;
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
    public Intention edit(UUID id, Intention intention) {
        Optional<Intention> intentionFind = intentionRepository.findById(id);
        Intention intentionObj = null;
        if(intentionFind.isPresent()){
            intentionObj = intentionFind.get();
            if(intention.getDate()!=null)
                intentionObj.setDate(intention.getDate());

            if(intention.getText()!=null)
                intentionObj.setText(intention.getText());

            intentionObj.setUser(intention.getUser());
            intentionRepository.save(intentionObj);
        }
        return intentionObj;
    }

    @Override
    public Optional<Intention> findById(UUID id) {
        return intentionRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        boolean exist = intentionRepository.existsById(id);
        if(exist)
            intentionRepository.deleteById(id);
    }

    @Override
    public List<Intention> intentionBetweenToDates(Timestamp first, Timestamp second) {
        return intentionRepository.findBetweenTwoDates(first, second);
    }
}
