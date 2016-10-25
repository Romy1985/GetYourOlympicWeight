package getyourolyweight.datastorage;

/**
 * Created by r.ceuleers on 2-10-2016.
 */

import getyourolyweight.domain.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleDAO {
    public ScheduleDAO() {

    }

    //INSERT query for new snatch schedules
    public boolean insertSchedule(String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
        boolean result = false;

                 // First open the database connection.
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // Execute the insert statement using the SnatchDialogPanel information
                result = connection.executeSqlDmlStatement(
                        "INSERT INTO `schedulesnatch`(Email, BackSquat, SnatchGoalWeight, SnatchGoalDate) VALUES('" + email + "', '" + backSquat + "', '" + snatchGoalWeight + "', '" + snatchGoalDate + "');");

                // Finished with the connection, so close it.
                connection.closeConnection();
            }
            // else an error occurred leave 'member' to null.


        return result;
    }



     /**
     * The Progress is count by de value of the backsquat and value of the SnatchGoalWeight
     * The most recent schedule shows in the progress menu
     * @param email
     * @return progress
     */
    public Schedule findProgressSnatch(String email) {
        Schedule progress = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM schedulesnatch WHERE Email = '" + email + "' AND SnatchGoalDate = (SELECT max(SnatchGoalDate) FROM schedulesnatch WHERE Email = '" + email + "') ;");


            if (resultset != null) {
                try {
                    // The email for a schedule is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String scheduleIDFromDb = resultset.getString("ScheduleSnatchID");
                        String emailFromDb = resultset.getString("Email");
                        int backSquatFromDb = resultset.getInt("Backsquat");
                        int snatchGoalWeightFromDb = resultset.getInt("SnatchGoalWeight");
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

