package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rafista.intencje.model.Intention;
import rafista.intencje.modelView.Day;
import rafista.intencje.service.IntentionService;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/intention")
public class IntentionController {
    @Autowired
    IntentionService intentionService;

    @PostMapping(produces = "application/json")
    public Intention add(@RequestBody Intention intention){
        return intentionService.save(intention);
    }

    @GetMapping(value="/between", produces = "application/json")
    public List<Day> getByTwoDates(@RequestParam("first") final Timestamp first, @RequestParam("second") final Timestamp second){
        return intentionService.intentionBetweenToDates(first, second);
    }

    @GetMapping(produces = "application/json")
    public List<Intention> getAll(){
        return intentionService.findAll();
    }

    @PutMapping(value="/{id}", produces = "application/json")
    public Intention edit(@PathVariable UUID id, @RequestBody Intention intention){
        return intentionService.edit(id, intention);
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public void delete(@PathVariable UUID id){
        intentionService.delete(id);
    }
}
