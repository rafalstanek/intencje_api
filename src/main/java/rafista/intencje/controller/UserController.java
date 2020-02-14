package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rafista.intencje.model.User;
import rafista.intencje.service.UserService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}",produces = "application/json")
    public Optional<User> getUserDetail(@PathVariable UUID id){
        return userService.findById(id);
    }

}
