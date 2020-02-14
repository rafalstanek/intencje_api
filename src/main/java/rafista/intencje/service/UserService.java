package rafista.intencje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rafista.intencje.model.User;
import rafista.intencje.repository.UserRepository;
import rafista.intencje.serviceInterface.UserServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service(value = "userService")
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.login(username,password);
        if(user!=null){
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userRepository.save(user);
            return user;
        }

        return null;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<User> user = userRepository.findByToken(token);
        if(user!=null){
          return user;
        }
        return null;
    }
}
