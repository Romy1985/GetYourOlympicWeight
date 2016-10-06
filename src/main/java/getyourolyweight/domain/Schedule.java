package getyourolyweight.domain;

/**
 * Created by r.ceuleers on 2-10-2016.
 */
public class Schedule {
    private final Atlete atlete;
    private final Skill skill;
  //  private final main.getyourolyweight.presentation.StartPanel.SkillDialogPanel.SkillHandler.SnatchDialogPanel snatchDialogPanel;

    public Schedule(Atlete atlete, Skill skill) {
        this.atlete = atlete;
        this.skill = skill;
      //  this.snatchDialogPanel = snatchDialogPanel;

    }

    public Atlete getAtlete() {
        return atlete;
    }

    public Skill getSkill() {
        return skill;
    }

//    public main.getyourolyweight.presentation.StartPanel.SkillDialogPanel.SkillHandler.SnatchDialogPanel getSnatchDialogPanel() {
  //      return snatchDialogPanel; }

}



