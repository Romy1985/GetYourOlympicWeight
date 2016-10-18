package getyourolyweight.businesslogic;

import getyourolyweight.datastorage.AtleteDAO;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
import getyourolyweight.datastorage.ScheduleDAO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by r.ceuleers on 29-9-2016.
 */
public class WeightLiftManager {
    private final Map<String, Atlete> atletes;
    private final Map<String, Schedule> schedules;


    public WeightLiftManager() {
        atletes = new HashMap<>();
        schedules = new HashMap<>();
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



}


