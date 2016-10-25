package getyourolyweight.datastorage;

/**
 * Created by r.ceuleers on 25-10-2016.
 */


import getyourolyweight.domain.ScheduleCleanJerk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleCleanJerkDAO {
    public ScheduleCleanJerkDAO() {}


    //INSERT query for new clean and jerk schedules
    public boolean insertScheduleCleanJerk(String email, int frontSquat, int cleanJerkGoalWeight, String cleanJerkGoalDate) {
        boolean result = false;

        // First open the database connection.
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // Execute the insert statement using the SnatchDialogPanel information
            result = connection.executeSqlDmlStatement(
                    "INSERT INTO `schedulecleanjerk`(Email, FrontSquat, CleanJerkGoalWeight, CleanJerkGoalDate) VALUES('" + email + "', '" + frontSquat + "', '" + cleanJerkGoalWeight + "', '" + cleanJerkGoalDate + "');");

            // Finished with the connection, so close it.
            connection.closeConnection();
        }
        // else an error occurred leave 'member' to null.


        return result;
    }

    /**
     * The Progress is count by de value of the frontsquat and value of the cleanjerkGoalWeight
     * The most recent schedule shows in the progress menu
     * @param email
     * @return progress
     */
    public ScheduleCleanJerk findProgressCleanJerk(String email) {
        ScheduleCleanJerk progress = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM schedulecleanjerk WHERE Email = '" + email + "' AND CleanJerkGoalDate = (SELECT max(CleanJerkGoalDate) FROM schedulecleanjerk WHERE Email = '" + email + "') ;");


            if (resultset != null) {
                try {
                    // The email for a schedule is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String scheduleIDFromDb = resultset.getString("ScheduleCJID");
                        String emailFromDb = resultset.getString("Email");
                        int frontSquatFromDb = resultset.getInt("Frontsquat");
                        int cleanJerkGoalWeightFromDb = resultset.getInt("CleanJerkGoalWeight");
                        String cleanJerkGoalDateFromDb = resultset.getString("CleanJerkGoalDate");

                        progress = new ScheduleCleanJerk(
                                scheduleIDFromDb,
                                emailFromDb,
                                frontSquatFromDb,
                                cleanJerkGoalWeightFromDb,
                                cleanJerkGoalDateFromDb);

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
