package getyourolyweight.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.ceuleers on 26-9-2016.
 */
public class Atlete {
    private String firstName ;
    private String lastName ;
    private String email ;

    private final List<Schedule> schedules;

    public Atlete(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

        schedules = new ArrayList<>();
    }


    public String getFirtName() {
        return firstName;
    }
    public void setFirtNameName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setSchedules(Schedule[] schedules) {
        removeAllSchedules();

        for (Schedule theSchedule : schedules) {
            addSchedule(theSchedule);
        }
    }

    public void addSchedule(Schedule newSchedule) {
        schedules.add(newSchedule);
    }

    public void removeAllSchedules() {
        schedules.clear();
    }

    public boolean remove() {
        // Result is always true. If we later on use a database from which
        // the member needs to be removed as well, we can return a more
        // meaningfull value.
        boolean result = true;

        return result;
    }


}
