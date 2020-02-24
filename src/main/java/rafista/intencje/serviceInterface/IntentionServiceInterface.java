package rafista.intencje.serviceInterface;

import org.springframework.stereotype.Service;
import rafista.intencje.model.Intention;
import rafista.intencje.modelView.Day;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface IntentionServiceInterface {

    List<Intention> findAll();
    Intention save(Intention intention);
    Intention edit(UUID id, Intention intention);
   Optional<Intention> findById(UUID id);
    void delete(UUID id);
    List<Day> intentionBetweenToDates(Timestamp first, Timestamp second);
}
