package getyourolyweight.domain;

/**
 * Created by r.ceuleers on 2-10-2016.
 */
public class Skill {
    private Skill skill;
    private String skillID;
    private String exercise1, exercise2, exercise3, exercise4, exercise5, exercise6;

    public Skill(Skill skill, String skillID, String exercise1, String exercise2, String exercise3, String exercise4, String exercise5, String exercise6) {
        this.skill = skill;
        this.skillID = skillID;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
        this.exercise4 = exercise4;
        this.exercise5 = exercise5;
        this.exercise6 = exercise6;


    }

    public Skill getSkill() {return skill;}
    public void setSkill(Skill skill) {this.skill = skill;
    }

    public String getSkillID() {
        return skillID;
    }
    public void setSkillID(String skillID) {
        this.skillID = skillID;
    }

    public String getExercise1() {
        return exercise1;
    }
    public void setExercise1(String exercise1) {this.exercise1 = exercise1;
    }

    public String getExercise2() {
        return exercise2;
    }
    public void setExercise2(String exercise2) {this.exercise2 = exercise2;
    }

    public String getExercise3() {
        return exercise3;
    }
    public void setExercise3(String exercise3) {this.exercise3 = exercise3;
    }

    public String getExercise4() {
        return exercise4;
    }
    public void setExercise4(String exercise4) {this.exercise4 = exercise4;
    }

    public String getExercise5() {
        return exercise5;
    }
    public void setExercise5(String exercise5) {this.exercise5 = exercise5;
    }

    public String getExercise6() {
        return exercise6;
    }
    public void setExercise6(String exercise6) {this.exercise6 = exercise6;
    }



}
