package rafista.intencje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rafista.intencje.model.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(long id);

    @Query(value = "SELECT * FROM USER u where u.LOGIN = :username and u.PASSWORD = :password ",  nativeQuery = true)
    User login(String username,String password);

    @Query(value = "SELECT * FROM USER u where u.TOKEN = :token",  nativeQuery = true)
    Optional<User> findByToken(String token);
}
