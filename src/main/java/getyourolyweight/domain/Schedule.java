package getyourolyweight.domain;

import sun.util.calendar.LocalGregorianCalendar;

/**
 * Created by r.ceuleers on 2-10-2016.
 */
public class Schedule {
    private String scheduleID;
    private String email;
    private int backSquat;
    private int snatchGoalWeight;
    private String snatchGoalDate;

    public Schedule(String scheduleID, String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
        this.scheduleID = scheduleID;
        this.email = email;
        this.backSquat = backSquat;
        this.snatchGoalWeight = snatchGoalWeight;
        this.snatchGoalDate = snatchGoalDate;
    }

    public String getScheduleID() {return scheduleID; }
    public void setScheduleID(String scheduleID) { this.scheduleID = scheduleID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getBackSquat() {return backSquat; }
    public void setBackSquat(int backSquat) { this.backSquat = backSquat; }

    public int getSnatchGoalWeight() {return snatchGoalWeight; }
    public void setSnatchGoalWeight(int snatchGoalWeight) { this.snatchGoalWeight = snatchGoalWeight; }

    public String getSnatchGoalDate() {return snatchGoalDate; }
    public void setSnatchGoalDate(String snatchGoalDate) { this.snatchGoalDate = snatchGoalDate; }

}



