package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafista.intencje.model.Customer;
import rafista.intencje.service.CustomerService;

@RestController
public class TokenController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/token", produces = "application/json")
    public ResponseEntity getToken(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        Customer user = customerService.login(username, password);
        if (user != null) {
            return new ResponseEntity(user, new HttpHeaders(), HttpStatus.CREATED);
        }
        return new ResponseEntity("error", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}