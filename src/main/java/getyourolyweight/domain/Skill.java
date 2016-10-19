package getyourolyweight.domain;

/**
 * Created by r.ceuleers on 2-10-2016.
 */
public class Skill {
    private Skill skill;
    private String skillID;
    private String exercise;

    public Skill(Skill skill, String skillID, String exercise) {
        this.skill = skill;
        this.skillID = skillID;
        this.exercise = exercise;


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

    public String getExercise() {
        return exercise;
    }
    public void setExercise(String exercise) {this.exercise = exercise;
    }



}
