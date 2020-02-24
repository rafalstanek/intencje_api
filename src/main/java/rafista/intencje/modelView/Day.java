package rafista.intencje.modelView;

import rafista.intencje.model.Intention;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day {

    private String dayName;
    private String date;
    private List<Intention> intentionList = new ArrayList<>();

    public Day(String dayName, String date) {
        this.dayName = dayName;
        this.date = date;
    }

    public Day(String date)
    {
        this.date = date;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Intention> getIntentionList() {
        return intentionList;
    }

    public void setIntentionList(List<Intention> intentionList) {
        this.intentionList = intentionList;
    }

    public void addIntention(Intention intention){
        this.intentionList.add(intention);
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayName='" + dayName + '\'' +
                ", date='" + date + '\'' +
                ", intentionList=" + intentionList +
                '}';
    }
}
