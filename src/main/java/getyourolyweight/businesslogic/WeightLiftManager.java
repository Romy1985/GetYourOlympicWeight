package getyourolyweight.businesslogic;

import getyourolyweight.datastorage.AtleteDAO;
import getyourolyweight.datastorage.ScheduleDAO;
import getyourolyweight.datastorage.SkillDAO;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
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
    private Map<String, Skill> skills;


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

    public void createAtlete(String email, String firstName, String lastName) {
      //  Atlete atlete = atletes.get(email);

        AtleteDAO atleteDAO = new AtleteDAO();
        atleteDAO.createAtlete(email, firstName, lastName);

    }

    public void insertSchedule(String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
      //  Schedule schedule = schedules.get(email);

        ScheduleDAO scheduleDAO = new ScheduleDAO();
        scheduleDAO.insertSchedule(email, backSquat, snatchGoalWeight, snatchGoalDate);
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


