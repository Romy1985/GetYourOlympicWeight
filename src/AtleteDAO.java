/**
 * Created by r.ceuleers on 26-9-2016.
 */

import java.util.ArrayList;
import java.util.List;

public class AtleteDAO {
    public AtleteDAO() {

    }
}
/*
    public Atlete findAtlete (String email) {
        Atlete atlete = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM atlete WHERE Email = " + email + ";");

            if (resultset != null) {
                try {
                    // The membershipnumber for a member is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        int membershipNumberFromDb = resultset.getInt("MembershipNumber");
                        String firstNameFromDb = resultset.getString("FirstName");
                        String lastNameFromDb = resultset.getString("LastName");

                        member = new Member(
                                membershipNumberFromDb,
                                firstNameFromDb,
                                lastNameFromDb);

                        member.setStreet(resultset.getString("Street"));
                        member.setHouseNumber(resultset.getString("HouseNumber"));
                        member.setCity(resultset.getString("City"));
                        member.setFine(resultset.getDouble("Fine"));
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    member = null;
                }
            }
            // else an error occurred leave 'member' to null.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

}
*/