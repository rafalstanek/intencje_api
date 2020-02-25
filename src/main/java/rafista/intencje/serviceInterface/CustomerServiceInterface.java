package rafista.intencje.serviceInterface;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import rafista.intencje.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerServiceInterface {

    Customer save(Customer user);

   Customer edit(UUID id, String newPassword, String oldPassword);

    List<Customer> findAll();

    Optional<Customer> findById(UUID id);

    void delete(UUID id);

   Customer login(String username, String password);

   Optional<User> findByToken(String token);

}
