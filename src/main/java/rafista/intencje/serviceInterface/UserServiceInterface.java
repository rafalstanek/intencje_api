package rafista.intencje.serviceInterface;

import org.springframework.stereotype.Service;
import rafista.intencje.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserServiceInterface {

    User save(User user);

    List<User> findAll();

    Optional<User> findById(long id);

    void delete(long id);

   User login(String username, String password);

   Optional<User> findByToken(String token);

}
