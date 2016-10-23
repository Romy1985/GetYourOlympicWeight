package getyourolyweight.datastorage;

import getyourolyweight.domain.Skill;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by r.ceuleers on 2-10-2016.
 */
public class SkillDAO {
    public SkillDAO() {

    }

    //Query for snatch exercises
    public Skill findExerciseSnatch(String skillSnatch) {
        Skill skill = null;
        JOptionPane.showMessageDialog(null, "hoi");

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT exercise.ExerciseName FROM skill INNER JOIN exercise ON skill.SkillID = exercise.SkillID WHERE skill.SkillName = '" + skillSnatch + "' ;");
            JOptionPane.showMessageDialog(null, resultset);


            if (resultset != null) {
                try {
                    // The skillSnatch for the exercises is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String exerciseIDFromDb = resultset.getString("ExerciseID");
                        String exerciseNameFromDb = resultset.getString("ExerciseName");
                        String skillIDFromDb = resultset.getString("SkillID");
                        String skillNameFromDb = resultset.getString("SkillName");

                        //Dit werkt niet???
                          skill = new Skill(skillIDFromDb,
                                  exerciseIDFromDb,
                                exerciseNameFromDb,
                                skillNameFromDb);

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    skill = null;
                }
            }
            // else an error occurred leave 'skill' to null.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

        }
        return skill;

    }


    //Query for clean&jerk exercises
    public Skill findExerciseCleanJerk(String skillCleanJerk) {
        Skill skill = null;

        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT exercise.ExerciseName FROM skill INNER JOIN exercise ON skill.SkillID = exercise.SkillID WHERE skill.SkillName = '" + skillCleanJerk + "' ;");


            if (resultset != null) {
                try {
                    // The skillSnatch for the exercises is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if (resultset.next()) {
                        String exerciseIDFromDb = resultset.getString("ExerciseID");
                        String exerciseNameFromDb = resultset.getString("ExerciseName");
                        String skillIDFromDb = resultset.getString("SkillID");
                        String skillNameFromDb = resultset.getString("SkillName");

                        //Dit werkt niet???
                        /*  skill = new Skill(
                                exerciseIDFromDb,
                                exerciseNameFromDb,
                                skillIDFromDb,
                                skillNameFromDb); */

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    skill = null;
                }
            }
            // else an error occurred leave 'skill' to null.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

        }
        return skill;

    }
}
