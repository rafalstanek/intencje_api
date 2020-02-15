package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rafista.intencje.model.Intention;
import rafista.intencje.service.IntentionService;

@RestController
@RequestMapping("/api/intention")
public class IntentionController {
    @Autowired
    IntentionService intentionService;

    @PostMapping(produces = "application/json")
    public Intention add(@RequestBody Intention intention){
        return intentionService.save(intention);
    }
}
