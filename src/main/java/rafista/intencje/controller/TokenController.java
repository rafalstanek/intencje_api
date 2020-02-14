package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rafista.intencje.service.UserService;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @PostMapping("/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        String token= userService.login(username,password).getToken();
        if(StringUtils.isEmpty(token)){
            return "no token found";
        }
        return token;
    }
}