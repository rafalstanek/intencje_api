package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rafista.intencje.model.Customer;
import rafista.intencje.service.CustomerService;

@RestController
public class TokenController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/token")
    public Customer getToken(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        Customer user = customerService.login(username, password);
        if (user != null) {
            return user;
        }
        return null;
    }
}