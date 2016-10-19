package getyourolyweight.businesslogic;

import getyourolyweight.datastorage.AtleteDAO;
import getyourolyweight.datastorage.ScheduleDAO;
import getyourolyweight.datastorage.SkillDAO;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
import getyourolyweight.domain.Skill;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by r.ceuleers on 29-9-2016.
 */
public class WeightLiftManager {
    private final Map<String, Atlete> atletes;
    private final Map<String, Schedule> schedules;
    private final Map<String, Skill> skills;


    public WeightLiftManager() {
        atletes = new HashMap<>();
        schedules = new HashMap<>();
        skills = new HashMap<>();
    }

    public Atlete findAtlete(String email) {
        Atlete atlete = atletes.get(email);

        if (atlete == null ) {
            AtleteDAO atleteDAO = new AtleteDAO();
            atlete = atleteDAO.findAtlete(email);
            atletes.put(email, atlete);
            }
             return atlete;
    }

    public Atlete createAtlete(String email, String firstName, String lastName) {
        Atlete atlete = atletes.get(email);

        if (atlete == null ) {
            AtleteDAO atleteDAO = new AtleteDAO();
            atlete = atleteDAO.createAtlete(email, firstName, lastName);
           // atletes.put(email, firstName, lastName); Dit werkt niet??
        }
        return atlete;
    }

    public Schedule insertSchedule(String scheduleID, String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
        Schedule schedule = schedules.get(email);

        if (schedule == null) {
            ScheduleDAO scheduleDAO = new ScheduleDAO();
            //schedule = scheduleDAO.insertSchedule(scheduleID, email, backSquat, snatchGoalWeight, snatchGoalDate);
            schedules.put(email, schedule);
        }
        return schedule;
    }

    public Schedule makeSchedule(String email, int backSquat, int snatchGoalWeight) {
        Schedule schedule = schedules.get(email);

        if (schedule == null) {
            ScheduleDAO scheduleDAO = new ScheduleDAO();
           // schedule = scheduleDAO.makeSchedule(email, backSquat, snatchGoalWeight);
            schedules.put(email, schedule);
        }
        return schedule;
    }

    public Skill findExerciseSnatch(String skillSnatch) {
        Skill skill = skills.get(skillSnatch);

        if (skill == null ) {
            SkillDAO skillDAO = new SkillDAO();
            skill = skillDAO.findExerciseSnatch(skillSnatch);
            skills.put(skillSnatch, skill);
        }
        return skill;
    }





}


