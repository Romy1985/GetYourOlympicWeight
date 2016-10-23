package getyourolyweight.domain;

/**
 * Created by r.ceuleers on 2-10-2016.
 */
public class Skill {
    private Skill skill;
    private String skillID;
    private String exerciseS1, exerciseS2, exerciseS3, exerciseC1, exerciseC2, exerciseC3;

    public Skill(Skill skill, String skillID, String exerciseS1, String exerciseS2, String exerciseS3, String exerciseC1, String exerciseC2, String exerciseC3) {
        this.skill = skill;
        this.skillID = skillID;
        this.exerciseS1 = exerciseS1;
        this.exerciseS2 = exerciseS2;
        this.exerciseS3 = exerciseS3;
        this.exerciseC1 = exerciseC1;
        this.exerciseC2 = exerciseC2;
        this.exerciseC3 = exerciseC3;


    }

    public Skill(String skillIDFromDb, String exerciseIDFromDb, String exerciseNameFromDb, String skillNameFromDb) {
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

    public String getExerciseS1() {
        return exerciseS1;
    }
    public void setExerciseS1(String exerciseS1) {this.exerciseS1 = exerciseS1;
    }

    public String getExerciseS2() {
        return exerciseS2;
    }
    public void setExerciseS2(String exerciseS2) {this.exerciseS2 = exerciseS2;
    }

    public String getExerciseS3() {
        return exerciseS3;
    }
    public void setExerciseS3(String exerciseS3) {this.exerciseS3 = exerciseS3;
    }

    public String getExerciseC1() {
        return exerciseC1;
    }
    public void setExerciseC1(String exerciseC1) {this.exerciseC1 = exerciseC1;
    }

    public String getExerciseC2() {
        return exerciseC2;
    }
    public void setExerciseC2(String exerciseC2) {this.exerciseC2 = exerciseC2;
    }

    public String getExerciseC3() {
        return exerciseC3;
    }
    public void setExerciseC3(String exerciseC3) {this.exerciseC3 = exerciseC3;
    }



}
