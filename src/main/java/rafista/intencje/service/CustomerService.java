package rafista.intencje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rafista.intencje.model.Customer;
import rafista.intencje.repository.CustomerRepository;
import rafista.intencje.serviceInterface.CustomerServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service(value = "customerService")
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer user) {
        if (customerRepository.findByUsername(user.getUsername()) == null)
            return customerRepository.save(user);
        else
            return null;
    }

    @Override
    public Customer edit(UUID id, String newPassword, String oldPassword) {
       Optional<Customer> customer = customerRepository.findById(id);
       if(customer.isPresent()){
           BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
           if (bcrypt.matches(oldPassword, customer.get().getPassword())) {
               Customer customerObj = customer.get();
               customerObj.setPassword(newPassword);
               customerRepository.save(customerObj);
               return customerObj;
           }
       }
       return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer login(String username, String password) {
        if (username != null && password != null) {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            Optional<Customer> user = customerRepository.login(username);
            if (user.isPresent()) {
                if (bcrypt.matches(password, user.get().getPassword())) {
                    String token = UUID.randomUUID().toString();
                    Customer userObj = user.get();
                    userObj.setToken(token);
                    customerRepository.save(userObj);
                    return userObj;
                }
            }
        }
        return null;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<Customer> customer = customerRepository.findByToken(token);
        if (customer.isPresent()) {
            Customer customer1 = customer.get();
            User user = new User(customer1.getUsername(), customer1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return Optional.empty();
    }

}
