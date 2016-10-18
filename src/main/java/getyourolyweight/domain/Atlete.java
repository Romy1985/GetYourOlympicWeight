package getyourolyweight.domain;


/**
 * Created by r.ceuleers on 26-9-2016.
 */
public class Atlete {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String scheduleID;


    public Atlete(String email, String firstName, String lastName, String scheduleID) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scheduleID = scheduleID;

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

    public String getScheduleID() {return scheduleID; }
    public void setScheduleID(String scheduleID) {this.scheduleID = scheduleID; }

    }



