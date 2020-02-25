package rafista.intencje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rafista.intencje.model.Intention;
import rafista.intencje.modelView.Day;
import rafista.intencje.repository.IntentionRepository;
import rafista.intencje.serviceInterface.IntentionServiceInterface;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.*;

@Service(value = "intentionService")
public class IntentionService implements IntentionServiceInterface {
    @Autowired
    IntentionRepository intentionRepository;

    @Override
    public List<Intention> findAll() {
        List<Intention> list = new ArrayList<>();
        intentionRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Intention save(Intention intention) {
        return intentionRepository.save(intention);
    }

    @Override
    public Intention edit(UUID id, Intention intention) {
        Optional<Intention> intentionFind = intentionRepository.findById(id);
        Intention intentionObj = null;
        if (intentionFind.isPresent()) {
            intentionObj = intentionFind.get();
            if (intention.getDate() != null)
                intentionObj.setDate(intention.getDate());

            if (intention.getText() != null)
                intentionObj.setText(intention.getText());

            intentionObj.setUser(intention.getUser());
            intentionRepository.save(intentionObj);
        }
        return intentionObj;
    }

    @Override
    public Optional<Intention> findById(UUID id) {
        return intentionRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        boolean exist = intentionRepository.existsById(id);
        if (exist)
            intentionRepository.deleteById(id);
    }

    @Override
    public List<Day> intentionBetweenToDates(Timestamp first, Timestamp second) {
        List<Intention> intentionList = intentionRepository.findBetweenTwoDates(first, second);
        List<Day> dayList = new ArrayList<>();
        LocalDateTime date = null;
        for (Intention intentionObj : intentionList) {
            date = intentionObj.getDate().toLocalDateTime();
            Optional<String> dateCurrent = dayList.stream().map(Day::getDate).filter(date.format(DateTimeFormatter.ISO_DATE)::equals).findFirst();
            int index=0;
            if (dateCurrent.isPresent()) {
                for (Day days: dayList) {
                    if(days.getDate().equals(dateCurrent.get())){
                        index = dayList.indexOf(days);
                        break;
                    }
                }
                dayList.get(index).addIntention(intentionObj);
            }else
            {
                Day day = new Day(dayOfWeek(date.getDayOfWeek().getValue()), date.format(DateTimeFormatter.ISO_DATE));
                day.addIntention(intentionObj);
                dayList.add(day);
            }

        }

        if (dayList.size() > 0) {
           dayList.sort(new Comparator<Day>() {
               @Override
               public int compare(Day o1, Day o2) {
                   return o1.getDate().compareTo(o2.getDate());
               }
           });
        }

        return dayList;
    }

    private String dayOfWeek(int day) {
        String dayName = "";
        switch (day) {
            case 1:
                dayName = "poniedziałek";
                break;
            case 2:
                dayName = "wtorek";
                break;
            case 3:
                dayName = "środa";
                break;
            case 4:
                dayName = "czwartek";
                break;
            case 5:
                dayName = "piątek";
                break;
            case 6:
                dayName = "sobota";
                break;
            case 7:
                dayName = "niedziela";
                break;
            default:
                dayName = "-";
                break;
        }
        return dayName;
    }
}
