package getyourolyweight.businesslogic;

import getyourolyweight.datastorage.AtleteDAO;
import getyourolyweight.datastorage.ScheduleCleanJerkDAO;
import getyourolyweight.datastorage.ScheduleDAO;
import getyourolyweight.datastorage.SkillDAO;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
import getyourolyweight.domain.ScheduleCleanJerk;
import getyourolyweight.domain.Skill;


import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by r.ceuleers on 29-9-2016.
 */
public class WeightLiftManager {
    private Map<String, Atlete> atletes;
    private Map<String, Schedule> schedules;
    private Map<String, ScheduleCleanJerk> schedulesCleanJerk;
    private Map<String, Skill> skills;


    public WeightLiftManager() {
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
        }
        return progress;
    }

    //Manager to createAtlete in class AtleteDAO
    public void createAtlete(String email, String firstName, String lastName) {
        AtleteDAO atleteDAO = new AtleteDAO();
        atleteDAO.createAtlete(email, firstName, lastName);

    }

    //Manager to insertSchedule for snatch in class ScheduleDAO
    public void insertSchedule(String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        scheduleDAO.insertSchedule(email, backSquat, snatchGoalWeight, snatchGoalDate);
    }

    //Manager to insertSchedule for clean and jerk in class ScheduleDAO
    public void insertScheduleCleanJerk(String email, int frontSquat, int cleanJerkGoalWeight, String cleanJerkGoalDate) {
        ScheduleCleanJerkDAO scheduleCleanjerkDAO = new ScheduleCleanJerkDAO();
        scheduleCleanjerkDAO.insertScheduleCleanJerk(email, frontSquat, cleanJerkGoalWeight, cleanJerkGoalDate);
    }

}


