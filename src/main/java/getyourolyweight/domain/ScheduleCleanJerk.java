package getyourolyweight.domain;

/**
 * Created by r.ceuleers on 25-10-2016.
 */
public class ScheduleCleanJerk {
    private String scheduleID;
    private String email;
    private int frontSquat;
    private int cleanJerkGoalWeight;
    private String cleanJerkGoalDate;

    public ScheduleCleanJerk(String scheduleID, String email, int frontSquat, int cleanJerkGoalWeight, String cleanJerkGoalDate) {
        this.scheduleID = scheduleID;
        this.email = email;
        this.frontSquat = frontSquat;
        this.cleanJerkGoalWeight = cleanJerkGoalWeight;
        this.cleanJerkGoalDate = cleanJerkGoalDate;
    }

    public String getScheduleID() {return scheduleID; }
    public void setScheduleID(String scheduleID) { this.scheduleID = scheduleID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getFrontSquat() {return frontSquat; }
    public void setFrontSquat(int frontSquat) { this.frontSquat = frontSquat; }

    public int getCleanJerkGoalWeight() {return cleanJerkGoalWeight; }
    public void setCleanJerkGoalWeight(int cleanJerkGoalWeight) { this.cleanJerkGoalWeight = cleanJerkGoalWeight; }

    public String getCleanJerkGoalDate() {return cleanJerkGoalDate; }
    public void setCleanjerkGoalDate(String cleanJerkGoalDate) { this.cleanJerkGoalDate = cleanJerkGoalDate; }

}

