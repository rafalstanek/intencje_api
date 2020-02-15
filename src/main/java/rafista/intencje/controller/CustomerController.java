package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rafista.intencje.model.Customer;
import rafista.intencje.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{id}",produces = "application/json")
    public Optional<Customer> getUserDetail(@PathVariable long id){
        return customerService.findById(id);
    }

    @GetMapping(produces = "application/json")
    public List<Customer> getUserDetail(){
        return customerService.findAll();
    }

   @PostMapping(produces = "application/json")
    public Customer addUser(@RequestBody Customer user){
        return customerService.save(user);
    }

}
