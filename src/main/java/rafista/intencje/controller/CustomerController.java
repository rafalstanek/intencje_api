package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rafista.intencje.model.Customer;
import rafista.intencje.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{id}",produces = "application/json")
    public Optional<Customer> getUserDetail(@PathVariable UUID id){
        return customerService.findById(id);
    }

    @GetMapping(produces = "application/json")
    public List<Customer> getUserDetail(){
        return customerService.findAll();
    }

    @PutMapping(value ="/{id}", produces = "application/json")
    public Customer editUser(@PathVariable UUID id, @RequestParam(name = "newPassword", required = true) String newPassword ,@RequestParam(name = "oldPassword", required = true) String oldPassword){
        return customerService.edit(id, newPassword, oldPassword);
    }

   @PostMapping(produces = "application/json")
    public Customer addUser(@RequestBody Customer user){
        Customer customer = customerService.save(user);
        if (customer!=null)
            return customer;
        else
            return new Customer((UUID) null);
    }

}
