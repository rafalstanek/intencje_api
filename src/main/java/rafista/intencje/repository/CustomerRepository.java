package rafista.intencje.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rafista.intencje.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(long id);

    @Query(value = "SELECT * FROM CUSTOMER u where u.USERNAME = :username and u.PASSWORD = :password ",  nativeQuery = true)
    Optional<Customer> login(String username, String password);

   Optional<Customer> findByToken(String token);
}
