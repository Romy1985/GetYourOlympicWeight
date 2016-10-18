package getyourolyweight.datastorage; /**
 * Created by r.ceuleers on 26-9-2016.
 */

import getyourolyweight.domain.Atlete;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtleteDAO {
    public AtleteDAO() {

    }

    public Atlete findAtlete(String email) {
        Atlete atlete = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM atlete WHERE Email = '" + email + "';");


            if (resultset != null) {
                try {
                    // The email for a atlete is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String emailFromDb = resultset.getString("Email");
                        String firstNameFromDb = resultset.getString("FirstName");
                        String lastNameFromDb = resultset.getString("LastName");
                        String scheduleIDFromDb = resultset.getString("ScheduleID");

                        atlete = new Atlete(
                                emailFromDb,
                                firstNameFromDb,
                                lastNameFromDb,
                                scheduleIDFromDb);

                        // atlete.setBackSquat(resultset.getString("Backsquat"));
                        // atlete.setFrontSquat(resultset.getString("Frontsquat"));
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    atlete = null;
                }
            }
            // else an error occurred leave 'member' to null.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

        }
        return atlete;

    }
}

