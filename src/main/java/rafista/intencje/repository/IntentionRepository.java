package rafista.intencje.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rafista.intencje.model.Intention;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IntentionRepository extends CrudRepository<Intention, UUID> {
    Optional<Intention> findById(UUID id);

    @Query(value = "SELECT * FROM INTENTION u WHERE u.DATE BETWEEN :first AND :second",  nativeQuery = true)
    List<Intention> findBetweenTwoDates(Timestamp first, Timestamp second);

}
