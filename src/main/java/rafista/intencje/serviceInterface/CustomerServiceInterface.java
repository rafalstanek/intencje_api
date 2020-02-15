package rafista.intencje.serviceInterface;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import rafista.intencje.model.Customer;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerServiceInterface {

    Customer save(Customer user);

    List<Customer> findAll();

    Optional<Customer> findById(long id);

    void delete(long id);

   Customer login(String username, String password);

   Optional<User> findByToken(String token);

}
