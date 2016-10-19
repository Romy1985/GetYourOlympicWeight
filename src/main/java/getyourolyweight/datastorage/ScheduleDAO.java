package getyourolyweight.datastorage;

/**
 * Created by r.ceuleers on 2-10-2016.
 */

import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleDAO {
    public ScheduleDAO() {

    }


    public boolean insertSchedule(String scheduleID, String email, int backSquat, int snatchGoalWeight, String snatchGoalDate, Schedule insertSchedule) {
        boolean result = false;

        if (insertSchedule != null) {
            // First open the database connection.
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // Execute the insert statement using the SnatchDialogPanel information
                result = connection.executeSqlDmlStatement(
                        "INSERT INTO `schedulesnatch` VALUES('" + "" + "', '" + email + "', '" + backSquat + "', '" + snatchGoalWeight + "', '" + snatchGoalDate + "');");

                // Finished with the connection, so close it.
                connection.closeConnection();
            }
            // else an error occurred leave 'member' to null.
        }

        return result;
    }

    public Schedule makeSchedule(String email) {
        Schedule schedule = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM schedulesnatch WHERE Email = '" + email + "';");


            if (resultset != null) {
                try {
                    // The email for a schedule is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String scheduleIDFromDb = resultset.getString("Schedule nr");
                        String emailFromDb = resultset.getString("Email");
                        int backSquatFromDb = resultset.getInt("Backsquat");
                        int snatchGoalWeightFromDb = resultset.getInt("SnatchGialWeight");
                        String snatchGoalDateFromDb = resultset.getString("SnatchGoalDate");

                        schedule = new Schedule(
                                scheduleIDFromDb,
                                emailFromDb,
                                backSquatFromDb,
                                snatchGoalWeightFromDb,
                                snatchGoalDateFromDb);

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    schedule = null;
                }
            }
            // else an error occurred leave 'member' to null.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

        }
        return schedule;

    }

    /**
     * The Progress is count by de value of the backsquat and value of the SnatchGoalWeight
     * The most recent schedule shows in the progress menu
     * @param email
     * @return progress
     */
    public Schedule findProgress(String email) {
        Schedule progress = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT BackSquat, SnatchGoalWeight FROM schedulesnatch WHERE Email = '" + email + "' AND SnatchGoalDate = (SELECT min(SnatchGoalDate) FROM schedulesnatch WHERE Email = '" + email + "') ;");


            if (resultset != null) {
                try {
                    // The email for a schedule is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String scheduleIDFromDb = resultset.getString("Schedule nr");
                        String emailFromDb = resultset.getString("Email");
                        int backSquatFromDb = resultset.getInt("Backsquat");
                        int snatchGoalWeightFromDb = resultset.getInt("SnatchGialWeight");
                        String snatchGoalDateFromDb = resultset.getString("SnatchGoalDate");

                        progress = new Schedule(
                                scheduleIDFromDb,
                                emailFromDb,
                                backSquatFromDb,
                                snatchGoalWeightFromDb,
                                snatchGoalDateFromDb);

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    progress = null;
                }
            }
            // else an error occurred leave 'progress' to null.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

        }
        return progress;

    }


}

