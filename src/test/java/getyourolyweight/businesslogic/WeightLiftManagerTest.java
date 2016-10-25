package getyourolyweight.businesslogic;

import getyourolyweight.datastorage.AtleteDAO;
import getyourolyweight.datastorage.ScheduleCleanJerkDAO;
import getyourolyweight.datastorage.ScheduleDAO;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
import getyourolyweight.domain.ScheduleCleanJerk;
import getyourolyweight.domain.Skill;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by r.ceuleers on 16-10-2016.
 */
public class WeightLiftManagerTest {
    private Map<String, Atlete> atletes;
    private Map<String, Schedule> schedules;
    private Map<String, ScheduleCleanJerk> schedulesCleanJerk;
    private Map<String, Skill> skills;


    public WeightLiftManagerTest() {
        atletes = new HashMap<>();
        schedules = new HashMap<>();
        skills = new HashMap<>();
        schedulesCleanJerk = new HashMap<>();
    }

    //Manager to findAtlete in class AtleteDAO
    public Atlete findAtlete(String email) {
        Atlete atlete = atletes.get(email);

        if (atlete == null ) {
            AtleteDAO atleteDAO = new AtleteDAO();
            atlete = atleteDAO.findAtlete(email);
            atletes.put(email, atlete);
            System.out.println(atlete);
        }
        return atlete;

    }

    //Manager to doFindProgressSnatch in class ScheduleDAO
    public Schedule findProgressSnatch(String email) {
        Schedule progress = schedules.get(email);

        if (progress == null) {
            ScheduleDAO scheduleDAO = new ScheduleDAO();
            progress = scheduleDAO.findProgressSnatch(email);
            schedules.put(email, progress);
            System.out.println(progress);
        }
        return progress;
    }
    //Manager to doFindProgressCleanJerk in class ScheduleCleanJerkDAO
    public ScheduleCleanJerk findProgressCleanJerk(String email) {
        ScheduleCleanJerk progress = schedulesCleanJerk.get(email);

        if (progress == null) {
            ScheduleCleanJerkDAO scheduleCleanJerkDAO = new ScheduleCleanJerkDAO();
            progress = scheduleCleanJerkDAO.findProgressCleanJerk(email);
            schedulesCleanJerk.put(email, progress);
            System.out.println(progress);
        }
        return progress;
    }

    //Manager to createAtlete in class AtleteDAO
    public void createAtlete(String email, String firstName, String lastName) {
        AtleteDAO atleteDAO = new AtleteDAO();
        atleteDAO.createAtlete(email, firstName, lastName);
        System.out.println(atleteDAO);

    }

    //Manager to insertSchedule for snatch in class ScheduleDAO
    public void insertSchedule(String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        scheduleDAO.insertSchedule(email, backSquat, snatchGoalWeight, snatchGoalDate);
        System.out.println(scheduleDAO);
    }

    //Manager to insertSchedule for clean and jerk in class ScheduleDAO
    public void insertScheduleCleanJerk(String email, int frontSquat, int cleanJerkGoalWeight, String cleanJerkGoalDate) {
        ScheduleCleanJerkDAO scheduleCleanjerkDAO = new ScheduleCleanJerkDAO();
        scheduleCleanjerkDAO.insertScheduleCleanJerk(email, frontSquat, cleanJerkGoalWeight, cleanJerkGoalDate);
        System.out.println(scheduleCleanjerkDAO);
    }


}