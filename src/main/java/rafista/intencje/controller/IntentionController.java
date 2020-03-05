package rafista.intencje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafista.intencje.model.Intention;
import rafista.intencje.modelView.Day;
import rafista.intencje.service.IntentionService;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/intention")
public class IntentionController {
    @Autowired
    IntentionService intentionService;

    @PostMapping(produces = "application/json")
    public Intention add(@RequestBody Intention intention) {
        return intentionService.save(intention);
    }

    @GetMapping(value = "/between", produces = "application/json")
    public List<Day> getByTwoDates(@RequestParam("first") final Timestamp first, @RequestParam("second") final Timestamp second) {
        return intentionService.intentionBetweenToDates(first, second);
    }

    @GetMapping(produces = "application/json")
    public List<Intention> getAll() {
        return intentionService.findAll();
    }

    @GetMapping(value = "/week", produces = "application/json")
    public List<Day> getNextWeek() {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        start = Timestamp.valueOf(start.toLocalDateTime().format(DateTimeFormatter.ISO_DATE) + " 00:00:00");
        Timestamp end = Timestamp.valueOf(start.toLocalDateTime().plusDays(7).format(DateTimeFormatter.ISO_DATE)+" 00:00:00");
        return intentionService.intentionBetweenToDates(start, end);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Intention edit(@PathVariable UUID id, @RequestBody Intention intention) {
        return intentionService.edit(id, intention);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<Intention> getOne(@PathVariable UUID id) {
        return intentionService.findById(id);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(
                intentionService.delete(id), HttpStatus.OK);
    }
}
