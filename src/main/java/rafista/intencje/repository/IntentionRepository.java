package rafista.intencje.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rafista.intencje.model.Intention;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IntentionRepository extends CrudRepository<Intention, UUID> {
    Optional<Intention> findById(UUID id);

}
