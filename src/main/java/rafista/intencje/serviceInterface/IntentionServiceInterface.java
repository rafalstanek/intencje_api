package rafista.intencje.serviceInterface;

import org.springframework.stereotype.Service;
import rafista.intencje.model.Intention;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface IntentionServiceInterface {

    List<Intention> findAll();
    Intention save(Intention intention);
    Optional<Intention> findById(UUID id);
    void delete(UUID id);

}
