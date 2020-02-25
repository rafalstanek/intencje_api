package rafista.intencje.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rafista.intencje.model.Customer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Optional<Customer> findById(UUID id);

    @Query(value = "SELECT * FROM CUSTOMER u where u.USERNAME = :username",  nativeQuery = true)
    Optional<Customer> login(String username);

   Optional<Customer> findByToken(String token);

    @Query(value = "SELECT * FROM CUSTOMER u where u.USERNAME = :username",  nativeQuery = true)
    Customer findByUsername(String username);
}
