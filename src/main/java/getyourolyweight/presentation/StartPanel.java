package getyourolyweight.presentation; /**
 * Created by r.ceuleers on 25-9-2016.
 */

import com.sun.deploy.panel.AdvancedNetworkSettingsDialog;
import com.sun.javaws.progress.Progress;
import getyourolyweight.businesslogic.WeightLiftManager;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;
import getyourolyweight.domain.ScheduleCleanJerk;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * Startpanel contains all the panels and dialogs of the GUI
 * Startpanel with 3 buttons. Every buttons opens a new Dialog
 * Athlete button opens the Atlete dialog for search athletes en create athletes
 * Progress button open the Progress dialog for opening the schedules that the athlete still have to do
 * Start new goal button contains 2 buttons for 2 menu's
 * Menu 1 for the skill snatch
 * Menu 2 for the skill clean & jerk
 * Menu snatch contains a form. The values of the form are saved into the schedulesnatch db and show a schedule in a new panel
 * Menu clean & jerk contains a form. The values of the form are saved into the schedulecleanjerk db ans show a schedule in a new panel
 */

public class StartPanel extends JPanel {
    //Start menu with 3 Buttun-options
    private JLabel welcomeAtlete = new JLabel("Welcome");
    private JButton startNewGoalButton = new JButton("Start new goal");
    private JButton progressButton = new JButton("Progress");
    private JButton atleteButton = new JButton("Athlete");

    public StartPanel() {
        setLayout(null);
        setSize(900, 750);

        welcomeAtlete.setHorizontalTextPosition(JLabel.CENTER);
        welcomeAtlete.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeAtlete.setForeground(Color.WHITE);
        startNewGoalButton.setFont(new Font("Arial", Font.BOLD, 14));
        progressButton.setFont(new Font("Arial", Font.BOLD, 14));
        atleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        //Handlers for each button
        startNewGoalButton.addActionListener(new NewFrameHandler());
        progressButton.addActionListener(new NewFrameHandler());
        atleteButton.addActionListener(new NewFrameHandler());

        //Layout with 3 equal buttons
        welcomeAtlete.setBounds(420, 10, 100, 70);
        startNewGoalButton.setBounds(615, 200, 150, 150);
        progressButton.setBounds(360, 200, 150, 150);
        atleteButton.setBounds(105, 200, 150, 150);

        //add JButtons and JLabel to panel
        add(welcomeAtlete);
        add(atleteButton);
        add(startNewGoalButton);
        add(progressButton);

    }

    //Handlers StartPanel
    class NewFrameHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startNewGoalButton) {
                //Open new main.getyourolyweight.domain.Skill Dialog
                Dialog skillDialog = new SkillDialog();
                skillDialog.setVisible(true);
            } else if (e.getSource() == progressButton) {
                //Open new Progress Dialog
                Dialog progressDialog = new ProgressDialog();
                progressDialog.setVisible(true);
            } else if (e.getSource() == atleteButton) {
                //Open new main.getyourolyweight.domain.Atlete Dialog
                Dialog atleteDialog = new AtleteDialog();
                atleteDialog.setVisible(true);
            }

        }
    }

    /**
     * In the Skill Dialog you choose the skill Snatch or Clean and Jerk
     * When you choose the snatchbutton the SnatchDialog opens
     * When you choose the cleanJerkButton the CleanJerkDialog opens
     */
    public class SkillDialog extends JDialog {
        private JPanel panelSkill = new JPanel();
        private JLabel img = new JLabel();

        public SkillDialog() {
            //choose your skill dialog
            JDialog skillDialog = new JDialog();
            skillDialog.setTitle("Skill menu");
            skillDialog.setSize(900, 750);
            skillDialog.setLocationRelativeTo(null);
            skillDialog.setContentPane(new SkillDialogPanel());
            skillDialog.setModal(true);

            //background image
            ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/warmupsnatch.jpg");
            img = new JLabel(icon1);
            img.setBounds(0, 0, 900, 750);
            img.setVisible(true);

            panelSkill.setBounds(0, 0, 900, 750);
            panelSkill.add(img);
            panelSkill.setVisible(true);
            panelSkill.repaint();

            skillDialog.add(panelSkill);
            skillDialog.setVisible(true);
            skillDialog.repaint();

        }
    }

    public class SkillDialogPanel extends JPanel {
        // choose your skill panel
        private JPanel panelSkill = new JPanel();
        private JLabel skillLabel;
        private JButton snatchButton, cleanJerkButton, homeButton, backButton;

        public SkillDialogPanel() {
            //Skill panel with 2 JButtons
            setLayout(null);
            skillLabel = new JLabel("Choose your skill");
            skillLabel.setForeground(Color.WHITE);

            snatchButton = new JButton("Snatch");
            snatchButton.addActionListener(new SkillHandler());
            cleanJerkButton = new JButton("Clean & Jerk");
            cleanJerkButton.addActionListener(new SkillHandler());
            homeButton = new JButton("Home");
            homeButton.setBackground(Color.GRAY);
            homeButton.addActionListener(new HomeHandler());
            backButton = new JButton("<<");
            backButton.setBackground(Color.GRAY);
            backButton.addActionListener(new BackHandler());

            //layout 2 equal buttons
            skillLabel.setBounds(400, 10, 100, 70);
            snatchButton.setBounds(150, 175, 200, 200);
            cleanJerkButton.setBounds(550, 175, 200, 200);

            //layout back en home buttons
            backButton.setBounds(50, 650, 75, 30);
            homeButton.setBounds(130, 650, 75, 30);

            add(skillLabel);
            add(snatchButton);
            add(cleanJerkButton);
            add(homeButton);
            add(backButton);


        }

        //HANDLERS of SkillDialog

        //backHandler for closing the SkillDialog to previous panel -- Werkt niet!!
        class BackHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }


        //homeHandler for closing the SkillDialog StartPanel -- uitzoeken hoe
        class HomeHandler implements ActionListener {
            public void actionPerformed(ActionEvent e) {

            }
        }

        //Skill Handler for opening the Snatch menu or Clean & Jerk menu
        class SkillHandler implements
                ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (
                        e.getSource() == snatchButton
                        ) {
                    //Open snatch menu Dialog
                    Dialog snatchDialog = new SnatchDialog();
                    snatchDialog.setVisible(true);
                } else if (
                        e.getSource() == cleanJerkButton
                        ) {
                    //Open clean en jerk menu Dialog
                    Dialog cleanJerkDialog = new CleanJerkDialog();
                    cleanJerkDialog.setVisible(true);
                }
            }


            /**
             * --------------------------SKILL SNATCH-----------------------------------
             * Snatch input form
             * Athlete information from database
             * Extra information: Goal weigt, Goal date and 1RM backsquat
             * With the Save button, this information does an INSERT query to the Schedule table
             * Then the save button changes in a Schedule button
             * With the Schedule button, the snatch schedule is getting started
             */

            public class SnatchDialog extends JDialog {
                private JPanel panelSnatch = new JPanel();
                private JLabel img = new JLabel();

                //Open snatch dialog
                public SnatchDialog() {
                    JDialog snatchForm = new JDialog();
                    snatchForm.setTitle("Snatch");
                    snatchForm.setSize(900, 750);
                    snatchForm.setLocationRelativeTo(null);
                    snatchForm.setContentPane(new SnatchDialogPanel(new WeightLiftManager()));
                    snatchForm.setModal(true);

                    //background image
                    ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/warmupsnatch3.jpg");
                    img = new JLabel(icon1);
                    img.setBounds(0, 0, 900, 700);
                    img.setVisible(true);

                    panelSnatch.setBounds(0, 0, 900, 750);
                    panelSnatch.add(img);
                    panelSnatch.setVisible(true);
                    panelSnatch.repaint();

                    snatchForm.add(panelSnatch);
                    snatchForm.setVisible(true);
                    snatchForm.repaint();
                }
            }

            public class SnatchDialogPanel extends JPanel {
                //Open snatch panel
                private JLabel emailLabel, firstNameLabel, lastNameLabel, backSquatLabel, snatchGoalLabel, snatchDateLabel;
                private JButton emailSearchButton, saveButton, snatchScheduleButton;
                private JTextField emailInput, firstNameInput, lastNameInput, backSquatInput, snatchGoalInput, snatchDateInput;
                private WeightLiftManager manager;
                private Atlete currentAtlete;

                public SnatchDialogPanel(WeightLiftManager weightLiftManager) {
                    setLayout(null);
                    emailLabel = new JLabel("Emailaddress: ");
                    emailLabel.setForeground(Color.WHITE);
                    firstNameLabel = new JLabel("Firstname: ");
                    firstNameLabel.setForeground(Color.WHITE);
                    lastNameLabel = new JLabel("Lastname: ");
                    lastNameLabel.setForeground(Color.WHITE);
                    backSquatLabel = new JLabel("Backsquat (1RM): ");
                    backSquatLabel.setForeground(Color.WHITE);
                    snatchGoalLabel = new JLabel("Snatch goal weight: ");
                    snatchGoalLabel.setForeground(Color.WHITE);
                    snatchDateLabel = new JLabel("Snatch goal date (yyyy-mm-dd): ");
                    snatchDateLabel.setForeground(Color.WHITE);
                    emailInput = new JTextField(30);
                    firstNameInput = new JTextField(30);
                    lastNameInput = new JTextField(30);
                    backSquatInput = new JTextField(10);
                    snatchGoalInput = new JTextField(10);
                    snatchDateInput = new JTextField(10);
                    emailSearchButton = new JButton("Search");
                    emailSearchButton.addActionListener(new EmailSearchHandler());
                    snatchScheduleButton = new JButton("Schedule");
                    snatchScheduleButton.addActionListener(new ScheduleHandler());
                    snatchScheduleButton.setVisible(false);
                    saveButton = new JButton("Save");
                    saveButton.addActionListener(new SaveHandler());
                    manager = weightLiftManager;
                    currentAtlete = null;


                    emailLabel.setBounds(50, 50, 300, 70);
                    emailInput.setBounds(250, 50, 300, 70);
                    emailSearchButton.setBounds(600, 50, 100, 70);
                    firstNameLabel.setBounds(50, 120, 300, 70);
                    firstNameInput.setBounds(250, 120, 300, 70);
                    lastNameLabel.setBounds(50, 190, 300, 70);
                    lastNameInput.setBounds(250, 190, 300, 70);
                    backSquatLabel.setBounds(50, 260, 300, 70);
                    backSquatInput.setBounds(250, 260, 300, 70);
                    snatchGoalLabel.setBounds(50, 330, 300, 70);
                    snatchGoalInput.setBounds(250, 330, 300, 70);
                    snatchDateLabel.setBounds(50, 400, 300, 70);
                    snatchDateInput.setBounds(250, 400, 300, 70);
                    snatchScheduleButton.setBounds(600, 400, 100, 70);
                    saveButton.setBounds(600, 400, 100, 70);

                    add(emailLabel);
                    add(emailInput);
                    add(emailSearchButton);
                    add(firstNameLabel);
                    add(firstNameInput);
                    add(lastNameLabel);
                    add(lastNameInput);
                    add(backSquatLabel);
                    add(backSquatInput);
                    add(snatchGoalLabel);
                    add(snatchGoalInput);
                    add(snatchDateLabel);
                    add(snatchDateInput);
                    add(snatchScheduleButton);
                    add(saveButton);
                }

                //-------------HANDLERS SNATCHDIALOGPANEL------------------------------
                //Emailsearch Handler for SELECT query in the athlete table
                class EmailSearchHandler implements ActionListener {
                    /**
                     * find Athlete in database by emailaddress
                     *
                     * @return Athlete firstname and lastname
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == emailSearchButton) {
                            String email = emailInput.getText();
                            doFindAtlete(email);

                        }
                    }
                }

                private void doFindAtlete(String email) {
                    currentAtlete = manager.findAtlete(email);
                    firstNameInput.setText(currentAtlete.getFirtName());
                    lastNameInput.setText(currentAtlete.getLastName());
                    String atleteInfo = "Atleet niet gevonden";
                }

                //Save Hanlder for INSERT query to the Schedule table
                class SaveHandler implements ActionListener {
                    /**
                     * Save the information to the database
                     * INSERT values into schedulesnatch
                     * After using the Save button turns into the Schedule button
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == saveButton) {
                            String email = emailInput.getText();

                            String backSquat = backSquatInput.getText();
                            try {
                                int backSquatRM = Integer.parseInt(backSquat);
                                String snatchGoalWeight = snatchGoalInput.getText();
                                try {
                                    int snatchGoalWeightRM = Integer.parseInt(snatchGoalWeight);

                                    String snatchGoalDate = snatchDateInput.getText();
                                    doInsertSchedule(email, backSquatRM, snatchGoalWeightRM, snatchGoalDate);
                                } catch (NumberFormatException nfe) {
                                    if (snatchGoalWeight.equals(""))
                                        snatchGoalWeight = "Snatch goal weight is required";
                                    JOptionPane.showMessageDialog(SnatchDialogPanel.this,
                                            "No valid entry: " + snatchGoalWeight,
                                            "Error message",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException nfe) {
                                if (backSquat.equals(""))
                                    backSquat = "Backsquat is required";
                                JOptionPane.showMessageDialog(SnatchDialogPanel.this,
                                        "No valid entry: " + backSquat,
                                        "Error message",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }

                private void doInsertSchedule(String email, int backSquat, int snatchGoalWeight, String snatchGoalDate) {
                    manager.insertSchedule(email, backSquat, snatchGoalWeight, snatchGoalDate);
                    saveButton.setVisible(false);
                    snatchScheduleButton.setVisible(true);


                }

                //Schedule Handler for making the schedule
                // The values of the JTextfields SnatchGoalWeight and backSquat from SnatchDialogPanel
                // are needed for the math for the schedule
                class ScheduleHandler implements ActionListener {
                    /**
                     * Open schedule menu
                     * Get the exercises from table exercise with a SELECT query form the skill and exercise table
                     * where the skillName is Snatch
                     *
                     * @return exercises for the skill Snatch --- werkt niet
                     * Count the values of backsquat and goalweight
                     * Make a count and fill the textfields of the schedule per week
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == snatchScheduleButton) {
                            //Open schedule Dialog
                            Dialog scheduleDialog = new ScheduleDialog();
                            scheduleDialog.setVisible(true);
                            //Get exercises -- werkt niet
                            //String skillSnatch = skillInput.getText();
                            //doFindExerciseSnatch(skillSnatch);

                        }
                    }
                }

                //public void doFindExerciseSnatch(String skillSnatch) {
                //    currentSkill = manager.findExerciseSnatch(skillSnatch);
                //}

                public class ScheduleDialog extends JDialog {
                    private JPanel panelSnatchSchedule = new JPanel();
                    private JLabel img = new JLabel();

                    //Make schedule Dialog
                    public ScheduleDialog() {
                        JDialog scheduleDialog = new JDialog();
                        scheduleDialog.setTitle("Snatch Schedule");
                        scheduleDialog.setSize(900, 750);
                        scheduleDialog.setLocationRelativeTo(null);
                        scheduleDialog.setContentPane(new ScheduleDialogPanel());
                        scheduleDialog.setModal(true);

                        //background image
                        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/snatchwarmup5.jpg");
                        img = new JLabel(icon1);
                        img.setBounds(0, 0, 900, 700);
                        img.setVisible(true);

                        panelSnatchSchedule.setBounds(0, 0, 900, 750);
                        panelSnatchSchedule.add(img);
                        panelSnatchSchedule.setVisible(true);
                        panelSnatchSchedule.repaint();

                        scheduleDialog.add(panelSnatchSchedule);
                        scheduleDialog.setVisible(true);
                        scheduleDialog.repaint();

                    }
                }

                public class ScheduleDialogPanel extends JPanel {
                    //Make schedule panel
                    private JLabel week1, week2, week3, week4, skillLabel,
                            exerciseWeek1Label, roundsWeek1Label, repsWeek1Label, weightWeek1Label,
                            exerciseWeek2Label, roundsWeek2Label, repsWeek2Label, weightWeek2Label,
                            exerciseWeek3Label, roundsWeek3Label, repsWeek3Label, weightWeek3Label,
                            exerciseWeek4Label, roundsWeek4Label, repsWeek4Label, weightWeek4Label;
                    private JTextField skillInput,
                            exercise1Week1Input, exercise2Week1Input, exercise3Week1Input,
                            exercise1Week2Input, exercise2Week2Input, exercise3Week2Input,
                            exercise1Week3Input, exercise2Week3Input, exercise3Week3Input,
                            exercise1Week4Input, exercise2Week4Input, exercise3Week4Input,
                            rounds1Week1Input, rounds2Week1Input, rounds3Week1Input,
                            rounds1Week2Input, rounds2Week2Input, rounds3Week2Input,
                            rounds1Week3Input, rounds2Week3Input, rounds3Week3Input,
                            rounds1Week4Input, rounds2Week4Input, rounds3Week4Input,
                            reps1Week1Input, reps2Week1Input, reps3Week1Input,
                            reps1Week2Input, reps2Week2Input, reps3Week2Input,
                            reps1Week3Input, reps2Week3Input, reps3Week3Input,
                            reps1Week4Input, reps2Week4Input, reps3Week4Input,
                            weight1Week1Input, weight2Week1Input, weight3Week1Input,
                            weight1Week2Input, weight2Week2Input, weight3Week2Input,
                            weight1Week3Input, weight2Week3Input, weight3Week3Input,
                            weight1Week4Input, weight2Week4Input, weight3Week4Input;
                    private int reps, reps4, rounds, week1Count, week2Count, week3Count, week4Count;

                    public ScheduleDialogPanel() {
                        //fixed values for the reps, reps4 and rounds
                        reps = 5;
                        reps4 = 1;
                        rounds = 5;

                        //fixed percentages for the counts per week
                        week1Count = 75;
                        week2Count = 85;
                        week3Count = 95;
                        week4Count = 100;

                        setLayout(null);

                        skillLabel = new JLabel("Schedule: ");
                        skillLabel.setFont(new Font("", Font.BOLD, 18));
                        skillInput = new JTextField(20);
                        skillInput.setBackground(null);
                        skillInput.setBorder(null);
                        skillInput.setText("Snatch");
                        week1 = new JLabel("Week 1");
                        week1.setForeground(Color.PINK);
                        week2 = new JLabel("Week 2");
                        week2.setForeground(Color.PINK);
                        week3 = new JLabel("Week 3");
                        week3.setForeground(Color.PINK);
                        week4 = new JLabel("Week 4");
                        week4.setForeground(Color.PINK);

                        //labels & textfields week 1
                        exerciseWeek1Label = new JLabel("Exercise");
                        exerciseWeek1Label.setForeground(Color.WHITE);
                        exercise1Week1Input = new JTextField(20);
                        exercise2Week1Input = new JTextField(20);
                        exercise3Week1Input = new JTextField(20);
                        roundsWeek1Label = new JLabel("Rounds");
                        roundsWeek1Label.setForeground(Color.WHITE);
                        rounds1Week1Input = new JTextField(20);
                        rounds2Week1Input = new JTextField(20);
                        rounds3Week1Input = new JTextField(20);
                        repsWeek1Label = new JLabel("Reps");
                        repsWeek1Label.setForeground(Color.WHITE);
                        reps1Week1Input = new JTextField(20);
                        reps2Week1Input = new JTextField(20);
                        reps3Week1Input = new JTextField(20);
                        weightWeek1Label = new JLabel("Weight");
                        weightWeek1Label.setForeground(Color.WHITE);
                        weight1Week1Input = new JTextField(20);
                        weight2Week1Input = new JTextField(20);
                        weight3Week1Input = new JTextField(20);

                        //labels & textfields week 2
                        exerciseWeek2Label = new JLabel("Exercise");
                        exerciseWeek2Label.setForeground(Color.WHITE);
                        exercise1Week2Input = new JTextField(20);
                        exercise2Week2Input = new JTextField(20);
                        exercise3Week2Input = new JTextField(20);
                        roundsWeek2Label = new JLabel("Rounds");
                        roundsWeek2Label.setForeground(Color.WHITE);
                        rounds1Week2Input = new JTextField(20);
                        rounds2Week2Input = new JTextField(20);
                        rounds3Week2Input = new JTextField(20);
                        repsWeek2Label = new JLabel("Reps");
                        repsWeek2Label.setForeground(Color.WHITE);
                        reps1Week2Input = new JTextField(20);
                        reps2Week2Input = new JTextField(20);
                        reps3Week2Input = new JTextField(20);
                        weightWeek2Label = new JLabel("Weight");
                        weightWeek2Label.setForeground(Color.WHITE);
                        weight1Week2Input = new JTextField(20);
                        weight2Week2Input = new JTextField(20);
                        weight3Week2Input = new JTextField(20);

                        //labels & textfields week 3
                        exerciseWeek3Label = new JLabel("Exercise");
                        exerciseWeek3Label.setForeground(Color.WHITE);
                        exercise1Week3Input = new JTextField(20);
                        exercise2Week3Input = new JTextField(20);
                        exercise3Week3Input = new JTextField(20);
                        roundsWeek3Label = new JLabel("Rounds");
                        roundsWeek3Label.setForeground(Color.WHITE);
                        rounds1Week3Input = new JTextField(20);
                        rounds2Week3Input = new JTextField(20);
                        rounds3Week3Input = new JTextField(20);
                        repsWeek3Label = new JLabel("Reps");
                        repsWeek3Label.setForeground(Color.WHITE);
                        reps1Week3Input = new JTextField(20);
                        reps2Week3Input = new JTextField(20);
                        reps3Week3Input = new JTextField(20);
                        weightWeek3Label = new JLabel("Weight");
                        weightWeek3Label.setForeground(Color.WHITE);
                        weight1Week3Input = new JTextField(20);
                        weight2Week3Input = new JTextField(20);
                        weight3Week3Input = new JTextField(20);

                        //labels & textfields week 4
                        exerciseWeek4Label = new JLabel("Exercise");
                        exerciseWeek4Label.setForeground(Color.WHITE);
                        exercise1Week4Input = new JTextField(20);
                        exercise2Week4Input = new JTextField(20);
                        exercise3Week4Input = new JTextField(20);
                        roundsWeek4Label = new JLabel("Rounds");
                        roundsWeek4Label.setForeground(Color.WHITE);
                        rounds1Week4Input = new JTextField(20);
                        rounds2Week4Input = new JTextField(20);
                        rounds3Week4Input = new JTextField(20);
                        repsWeek4Label = new JLabel("Reps");
                        repsWeek4Label.setForeground(Color.WHITE);
                        reps1Week4Input = new JTextField(20);
                        reps2Week4Input = new JTextField(20);
                        reps3Week4Input = new JTextField(20);
                        weightWeek4Label = new JLabel("Weight");
                        weightWeek4Label.setForeground(Color.WHITE);
                        weight1Week4Input = new JTextField(20);
                        weight2Week4Input = new JTextField(20);
                        weight3Week4Input = new JTextField(20);

                        //layout skill label + textfield
                        skillLabel.setBounds(25, 10, 100, 20);
                        skillInput.setBounds(125, 10, 100, 20);

                        //layout schedule week 1
                        week1.setBounds(25, 30, 100, 30);
                        exerciseWeek1Label.setBounds(25, 60, 100, 30);
                        exercise1Week1Input.setBounds(25, 90, 100, 30);
                        exercise2Week1Input.setBounds(25, 120, 100, 30);
                        exercise3Week1Input.setBounds(25, 150, 100, 30);
                        roundsWeek1Label.setBounds(125, 60, 100, 30);
                        rounds1Week1Input.setBounds(125, 90, 100, 30);
                        rounds2Week1Input.setBounds(125, 120, 100, 30);
                        rounds3Week1Input.setBounds(125, 150, 100, 30);
                        repsWeek1Label.setBounds(225, 60, 100, 30);
                        reps1Week1Input.setBounds(225, 90, 100, 30);
                        reps2Week1Input.setBounds(225, 120, 100, 30);
                        reps3Week1Input.setBounds(225, 150, 100, 30);
                        weightWeek1Label.setBounds(325, 60, 100, 30);
                        weight1Week1Input.setBounds(325, 90, 100, 30);
                        weight2Week1Input.setBounds(325, 120, 100, 30);
                        weight3Week1Input.setBounds(325, 150, 100, 30);

                        //layout schedule week 2
                        week2.setBounds(475, 30, 100, 30);
                        exerciseWeek2Label.setBounds(475, 60, 100, 30);
                        exercise1Week2Input.setBounds(475, 90, 100, 30);
                        exercise2Week2Input.setBounds(475, 120, 100, 30);
                        exercise3Week2Input.setBounds(475, 150, 100, 30);
                        roundsWeek2Label.setBounds(575, 60, 100, 30);
                        rounds1Week2Input.setBounds(575, 90, 100, 30);
                        rounds2Week2Input.setBounds(575, 120, 100, 30);
                        rounds3Week2Input.setBounds(575, 150, 100, 30);
                        repsWeek2Label.setBounds(675, 60, 100, 30);
                        reps1Week2Input.setBounds(675, 90, 100, 30);
                        reps2Week2Input.setBounds(675, 120, 100, 30);
                        reps3Week2Input.setBounds(675, 150, 100, 30);
                        weightWeek2Label.setBounds(775, 60, 100, 30);
                        weight1Week2Input.setBounds(775, 90, 100, 30);
                        weight2Week2Input.setBounds(775, 120, 100, 30);
                        weight3Week2Input.setBounds(775, 150, 100, 30);

                        //layout schedule week 3
                        week3.setBounds(25, 405, 100, 30);
                        exerciseWeek3Label.setBounds(25, 435, 100, 30);
                        exercise1Week3Input.setBounds(25, 465, 100, 30);
                        exercise2Week3Input.setBounds(25, 495, 100, 30);
                        exercise3Week3Input.setBounds(25, 525, 100, 30);
                        roundsWeek3Label.setBounds(125, 435, 100, 30);
                        rounds1Week3Input.setBounds(125, 465, 100, 30);
                        rounds2Week3Input.setBounds(125, 495, 100, 30);
                        rounds3Week3Input.setBounds(125, 525, 100, 30);
                        repsWeek3Label.setBounds(225, 435, 100, 30);
                        reps1Week3Input.setBounds(225, 465, 100, 30);
                        reps2Week3Input.setBounds(225, 495, 100, 30);
                        reps3Week3Input.setBounds(225, 525, 100, 30);
                        weightWeek3Label.setBounds(325, 435, 100, 30);
                        weight1Week3Input.setBounds(325, 465, 100, 30);
                        weight2Week3Input.setBounds(325, 495, 100, 30);
                        weight3Week3Input.setBounds(325, 525, 100, 30);

                        //layout schedule week 4
                        week4.setBounds(475, 405, 100, 30);
                        exerciseWeek4Label.setBounds(475, 435, 100, 30);
                        exercise1Week4Input.setBounds(475, 465, 100, 30);
                        exercise2Week4Input.setBounds(475, 495, 100, 30);
                        exercise3Week4Input.setBounds(475, 525, 100, 30);
                        roundsWeek4Label.setBounds(575, 435, 100, 30);
                        rounds1Week4Input.setBounds(575, 465, 100, 30);
                        rounds2Week4Input.setBounds(575, 495, 100, 30);
                        rounds3Week4Input.setBounds(575, 525, 100, 30);
                        repsWeek4Label.setBounds(675, 435, 100, 30);
                        reps1Week4Input.setBounds(675, 465, 100, 30);
                        reps2Week4Input.setBounds(675, 495, 100, 30);
                        reps3Week4Input.setBounds(675, 525, 100, 30);
                        weightWeek4Label.setBounds(775, 435, 100, 30);
                        weight1Week4Input.setBounds(775, 465, 100, 30);
                        weight2Week4Input.setBounds(775, 495, 100, 30);
                        weight3Week4Input.setBounds(775, 525, 100, 30);

                        //Fill schedule textfields
                        //Step 1:
                        //The reps and rounds are fixed values
                        reps1Week1Input.setText("" + reps);
                        rounds1Week1Input.setText("" + rounds);
                        reps2Week1Input.setText("" + reps);
                        rounds2Week1Input.setText("" + rounds);
                        reps3Week1Input.setText("" + reps);
                        rounds3Week1Input.setText("" + rounds);
                        reps1Week2Input.setText("" + reps);
                        rounds1Week2Input.setText("" + rounds);
                        reps2Week2Input.setText("" + reps);
                        rounds2Week2Input.setText("" + rounds);
                        reps3Week2Input.setText("" + reps);
                        rounds3Week2Input.setText("" + rounds);
                        reps1Week3Input.setText("" + reps);
                        rounds1Week3Input.setText("" + rounds);
                        reps2Week3Input.setText("" + reps);
                        rounds2Week3Input.setText("" + rounds);
                        reps3Week3Input.setText("" + reps);
                        rounds3Week3Input.setText("" + rounds);
                        reps1Week4Input.setText("" + reps4);
                        rounds1Week4Input.setText("" + rounds);
                        reps2Week4Input.setText("" + reps4);
                        rounds2Week4Input.setText("" + rounds);
                        reps3Week4Input.setText("" + reps4);
                        rounds3Week4Input.setText("" + rounds);

                        //Step 2:
                        //Get the exercises
                        //Exercises are selected by textfield skillInput,
                        // after choosing the snatch button in the skill menu, the skillInput is "Snatch schedule"
                        // The query now knows witch exercises are for the snatch schedule
                        //werkt niet, dus hard geprogrammerd!
                        /*

                        exercise1Week1Input.setText(currentSkill.getExerciseS1());
                        exercise2Week1Input.setText(currentSkill.getExerciseS2());
                        exercise3Week1Input.setText(currentSkill.getExerciseS3());
                        exercise1Week2Input.setText(currentSkill.getExerciseS1());
                        exercise2Week2Input.setText(currentSkill.getExerciseS2());
                        exercise3Week2Input.setText(currentSkill.getExerciseS3());
                        exercise1Week3Input.setText(currentSkill.getExerciseS1());
                        exercise2Week3Input.setText(currentSkill.getExerciseS2());
                        exercise3Week3Input.setText(currentSkill.getExerciseS3());
                        exercise1Week4Input.setText(currentSkill.getExerciseS1());
                        exercise2Week4Input.setText(currentSkill.getExerciseS2());
                        exercise3Week4Input.setText(currentSkill.getExerciseS3());

                        }

                         */
                        exercise1Week1Input.setText("Snatchpull");
                        exercise2Week1Input.setText("Snatch");
                        exercise3Week1Input.setText("Backsquat");
                        exercise1Week2Input.setText("Snatchpull");
                        exercise2Week2Input.setText("Snatch");
                        exercise3Week2Input.setText("Backsquat");
                        exercise1Week3Input.setText("Snatchpull");
                        exercise2Week3Input.setText("Snatch");
                        exercise3Week3Input.setText("Backsquat");
                        exercise1Week4Input.setText("Snatchpull");
                        exercise2Week4Input.setText("Snatch");
                        exercise3Week4Input.setText("Backsquat");


                        //Step 3:
                        //Counts for weight of the exercises

                        //Count for weight 1 and 2 (snatchpulls and snatch)
                        String exercise12 = snatchGoalInput.getText();
                        int exercise12Weight = Integer.parseInt(exercise12);

                        int resultWeek1Weigt12 = week1Count * exercise12Weight / 100;
                        int resultWeek2Weight12 = week2Count * exercise12Weight / 100;
                        int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                        int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                        weight1Week1Input.setText("" + resultWeek1Weigt12);
                        weight2Week1Input.setText("" + resultWeek1Weigt12);
                        weight1Week2Input.setText("" + resultWeek2Weight12);
                        weight2Week2Input.setText("" + resultWeek2Weight12);
                        weight1Week3Input.setText("" + resultWeek3Weight12);
                        weight2Week3Input.setText("" + resultWeek3Weight12);
                        weight1Week4Input.setText("" + resultWeek4Weight12);
                        weight2Week4Input.setText("" + resultWeek4Weight12);

                        //Count for weight 3 (backsquat)
                        String backsquat = backSquatInput.getText();
                        int backsquatRM = Integer.parseInt(backsquat);

                        int resultWeek1 = week1Count * backsquatRM / 100;
                        int resultWeek2 = week2Count * backsquatRM / 100;
                        int resultWeek3 = week3Count * backsquatRM / 100;
                        int resultWeek4 = week4Count * backsquatRM / 100;

                        weight3Week1Input.setText("" + resultWeek1);
                        weight3Week2Input.setText("" + resultWeek2);
                        weight3Week3Input.setText("" + resultWeek3);
                        weight3Week4Input.setText("" + resultWeek4);


                        //add labels & textfield to panel
                        add(skillLabel);
                        add(skillInput);
                        add(week1);
                        add(week2);
                        add(week3);
                        add(week4);
                        add(exerciseWeek1Label);
                        add(exerciseWeek2Label);
                        add(exerciseWeek3Label);
                        add(exerciseWeek4Label);
                        add(exercise1Week1Input);
                        add(exercise2Week1Input);
                        add(exercise3Week1Input);
                        add(exercise1Week2Input);
                        add(exercise2Week2Input);
                        add(exercise3Week2Input);
                        add(exercise1Week3Input);
                        add(exercise2Week3Input);
                        add(exercise3Week3Input);
                        add(exercise1Week4Input);
                        add(exercise2Week4Input);
                        add(exercise2Week4Input);
                        add(exercise3Week4Input);
                        add(roundsWeek1Label);
                        add(rounds1Week1Input);
                        add(rounds2Week1Input);
                        add(rounds3Week1Input);
                        add(roundsWeek2Label);
                        add(rounds1Week2Input);
                        add(rounds2Week2Input);
                        add(rounds3Week2Input);
                        add(roundsWeek3Label);
                        add(rounds1Week3Input);
                        add(rounds2Week3Input);
                        add(rounds3Week3Input);
                        add(roundsWeek4Label);
                        add(rounds1Week4Input);
                        add(rounds2Week4Input);
                        add(rounds3Week4Input);
                        add(repsWeek1Label);
                        add(reps1Week1Input);
                        add(reps2Week1Input);
                        add(reps3Week1Input);
                        add(repsWeek2Label);
                        add(reps1Week2Input);
                        add(reps2Week2Input);
                        add(reps3Week2Input);
                        add(repsWeek3Label);
                        add(reps1Week3Input);
                        add(reps2Week3Input);
                        add(reps3Week3Input);
                        add(repsWeek4Label);
                        add(reps1Week4Input);
                        add(reps2Week4Input);
                        add(reps3Week4Input);
                        add(weightWeek1Label);
                        add(weight1Week1Input);
                        add(weight2Week1Input);
                        add(weight3Week1Input);
                        add(weightWeek2Label);
                        add(weight1Week2Input);
                        add(weight2Week2Input);
                        add(weight3Week2Input);
                        add(weightWeek3Label);
                        add(weight1Week3Input);
                        add(weight2Week3Input);
                        add(weight3Week3Input);
                        add(weightWeek4Label);
                        add(weight1Week4Input);
                        add(weight2Week4Input);
                        add(weight3Week4Input);

                    }
                }
            }

            /**
             * --------------------------SKILL CLEAN AND JERK-----------------------------------
             * Clean and jerk input form
             * Athlete information from database
             * Extra information: Goal weigt, Goal date and 1RM frontsquat
             * With the Save button, this information does an INSERT query to the Schedule table
             * Then the save button changes in a Schedule button
             * With the Schedule button, the snatch schedule is getting started
             */

            public class CleanJerkDialog extends JDialog {
                private JPanel panelCleanJerk = new JPanel();
                private JLabel img = new JLabel();

                //Open snatch dialog
                public CleanJerkDialog() {
                    JDialog cleanJerkForm = new JDialog();
                    cleanJerkForm.setTitle("Clean and Jerk");
                    cleanJerkForm.setSize(900, 750);
                    cleanJerkForm.setLocationRelativeTo(null);
                    cleanJerkForm.setContentPane(new CleanJerkDialogPanel(new WeightLiftManager()));
                    cleanJerkForm.setModal(true);

                    //background image
                    ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/frontsquatwarmup3.jpg");
                    img = new JLabel(icon1);
                    img.setBounds(0, 0, 900, 700);
                    img.setVisible(true);

                    panelCleanJerk.setBounds(0, 0, 900, 750);
                    panelCleanJerk.add(img);
                    panelCleanJerk.setVisible(true);
                    panelCleanJerk.repaint();

                    cleanJerkForm.add(panelCleanJerk);
                    cleanJerkForm.setVisible(true);
                    cleanJerkForm.repaint();
                }
            }

            public class CleanJerkDialogPanel extends JPanel {
                //Open snatch panel
                private JLabel emailLabel, firstNameLabel, lastNameLabel, frontSquatLabel, cleanJerkGoalLabel, cleanJerkDateLabel;
                private JButton emailSearchButton, saveButton, cleanJerkScheduleButton;
                private JTextField emailInput, firstNameInput, lastNameInput, frontSquatInput, cleanJerkGoalInput, cleanJerkDateInput;
                private WeightLiftManager manager;
                private Atlete currentAtlete;

                public CleanJerkDialogPanel(WeightLiftManager weightLiftManager) {
                    setLayout(null);
                    emailLabel = new JLabel("Emailaddress: ");
                    emailLabel.setForeground(Color.WHITE);
                    firstNameLabel = new JLabel("Firstname: ");
                    firstNameLabel.setForeground(Color.WHITE);
                    lastNameLabel = new JLabel("Lastname: ");
                    lastNameLabel.setForeground(Color.WHITE);
                    frontSquatLabel = new JLabel("Frontsquat (1RM): ");
                    frontSquatLabel.setForeground(Color.WHITE);
                    cleanJerkGoalLabel = new JLabel("Clean & Jerk goal weight: ");
                    cleanJerkGoalLabel.setForeground(Color.WHITE);
                    cleanJerkDateLabel = new JLabel("Clean & Jerk goal date (yyyy-mm-dd): ");
                    cleanJerkDateLabel.setForeground(Color.WHITE);
                    emailInput = new JTextField(30);
                    firstNameInput = new JTextField(30);
                    lastNameInput = new JTextField(30);
                    frontSquatInput = new JTextField(10);
                    cleanJerkGoalInput = new JTextField(10);
                    cleanJerkDateInput = new JTextField(10);
                    emailSearchButton = new JButton("Search");
                    emailSearchButton.addActionListener(new EmailSearchHandler());
                    cleanJerkScheduleButton = new JButton("Schedule");
                    cleanJerkScheduleButton.addActionListener(new ScheduleHandler());
                    cleanJerkScheduleButton.setVisible(false);
                    saveButton = new JButton("Save");
                    saveButton.addActionListener(new SaveHandler());
                    manager = weightLiftManager;
                    currentAtlete = null;


                    emailLabel.setBounds(50, 50, 300, 70);
                    emailInput.setBounds(270, 50, 300, 70);
                    emailSearchButton.setBounds(600, 50, 100, 70);
                    firstNameLabel.setBounds(50, 120, 300, 70);
                    firstNameInput.setBounds(270, 120, 300, 70);
                    lastNameLabel.setBounds(50, 190, 300, 70);
                    lastNameInput.setBounds(270, 190, 300, 70);
                    frontSquatLabel.setBounds(50, 260, 300, 70);
                    frontSquatInput.setBounds(270, 260, 300, 70);
                    cleanJerkGoalLabel.setBounds(50, 330, 300, 70);
                    cleanJerkGoalInput.setBounds(270, 330, 300, 70);
                    cleanJerkDateLabel.setBounds(50, 400, 300, 70);
                    cleanJerkDateInput.setBounds(270, 400, 300, 70);
                    cleanJerkScheduleButton.setBounds(600, 400, 100, 70);
                    saveButton.setBounds(600, 400, 100, 70);

                    add(emailLabel);
                    add(emailInput);
                    add(emailSearchButton);
                    add(firstNameLabel);
                    add(firstNameInput);
                    add(lastNameLabel);
                    add(lastNameInput);
                    add(frontSquatLabel);
                    add(frontSquatInput);
                    add(cleanJerkGoalLabel);
                    add(cleanJerkGoalInput);
                    add(cleanJerkDateLabel);
                    add(cleanJerkDateInput);
                    add(cleanJerkScheduleButton);
                    add(saveButton);
                }

                //-------------HANDLERS CLEANJERKDIALOGPANEL------------------------------
                //Emailsearch Handler for SELECT query in the athlete table
                class EmailSearchHandler implements ActionListener {
                    /**
                     * find Athlete in database by emailaddress
                     *
                     * @return Athlete firstname and lastname
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == emailSearchButton) {
                            String email = emailInput.getText();
                            doFindAtlete(email);

                        }
                    }
                }

                private void doFindAtlete(String email) {
                    currentAtlete = manager.findAtlete(email);
                    firstNameInput.setText(currentAtlete.getFirtName());
                    lastNameInput.setText(currentAtlete.getLastName());
                    String atleteInfo = "Atleet niet gevonden";
                }

                //Save Hanlder for INSERT query to the Schedule table
                class SaveHandler implements ActionListener {
                    /**
                     * Save the information to the database
                     * INSERT values into schedulecleanjerk
                     * After using the Save button turns into the Schedule button
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == saveButton) {
                            String email = emailInput.getText();

                            String frontSquat = frontSquatInput.getText();
                            try {
                                int frontSquatRM = Integer.parseInt(frontSquat);
                                String cleanJerkGoalWeight = cleanJerkGoalInput.getText();
                                try {
                                    int cleanJerkGoalWeightRM = Integer.parseInt(cleanJerkGoalWeight);

                                    String cleanJerkGoalDate = cleanJerkDateInput.getText();
                                    doInsertScheduleCleanJerk(email, frontSquatRM, cleanJerkGoalWeightRM, cleanJerkGoalDate);
                                } catch (NumberFormatException nfe) {
                                    if (cleanJerkGoalWeight.equals(""))
                                        cleanJerkGoalWeight = "Clean & Jerk goal weight is required";
                                    JOptionPane.showMessageDialog(CleanJerkDialogPanel.this,
                                            "No valid entry: " + cleanJerkGoalWeight,
                                            "Error message",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException nfe) {
                                if (frontSquat.equals(""))
                                    frontSquat = "Frontsquat is required";
                                JOptionPane.showMessageDialog(CleanJerkDialogPanel.this,
                                        "No valid entry: " + frontSquat,
                                        "Error message",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }

                private void doInsertScheduleCleanJerk(String email, int frontSquat, int cleanJerkGoalWeight, String cleanJerkGoalDate) {
                    manager.insertScheduleCleanJerk(email, frontSquat, cleanJerkGoalWeight, cleanJerkGoalDate);
                    saveButton.setVisible(false);
                    cleanJerkScheduleButton.setVisible(true);
                }

                //Schedule Handler for making the schedule
                // The values of the JTextfields cleanJerkGoalWeight and frontSquat from CleanJerkDialogPanel
                // are needed for the math for the schedule
                class ScheduleHandler implements ActionListener {
                    /**
                     * Open schedule menu
                     * Get the exercises from table exercise with a SELECT query form the skill and exercise table
                     * where the skillName is Clean and Jerk
                     *
                     * @return exercises for the skill Clean an Jerk --- werkt niet
                     * Count the values of frontsquat and goalweight
                     * Make a count and fill the textfields of the schedule per week
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == cleanJerkScheduleButton) {
                            //Open schedule Dialog
                            Dialog scheduleDialog = new ScheduleDialog();
                            scheduleDialog.setVisible(true);
                            //Get exercises -- werkt niet
                            //String skillSnatch = skillInput.getText();
                            //doFindExerciseSnatch(skillSnatch);

                        }
                    }
                }

                //public void doFindExerciseCleanJerk(String skillCleanJerk) {
                //    currentSkill = manager.findExerciseCleanJerk(skillCleanJerk);
                //}

                public class ScheduleDialog extends JDialog {
                    private JPanel panelCleanJerkSchedule = new JPanel();
                    private JLabel img = new JLabel();

                    //Make schedule Dialog
                    public ScheduleDialog() {
                        JDialog scheduleDialog = new JDialog();
                        scheduleDialog.setTitle("Clean & Jerk Schedule");
                        scheduleDialog.setSize(900, 750);
                        scheduleDialog.setLocationRelativeTo(null);
                        scheduleDialog.setContentPane(new ScheduleDialogPanel());
                        scheduleDialog.setModal(true);

                        //background image
                        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/cleanschedule.jpg");
                        img = new JLabel(icon1);
                        img.setBounds(0, 0, 900, 700);
                        img.setVisible(true);

                        panelCleanJerkSchedule.setBounds(0, 0, 900, 750);
                        panelCleanJerkSchedule.add(img);
                        panelCleanJerkSchedule.setVisible(true);
                        panelCleanJerkSchedule.repaint();

                        scheduleDialog.add(panelCleanJerkSchedule);
                        scheduleDialog.setVisible(true);
                        scheduleDialog.repaint();

                    }
                }

                public class ScheduleDialogPanel extends JPanel {
                    //Make schedule panel
                    private JLabel week1, week2, week3, week4, skillLabel,
                            exerciseWeek1Label, roundsWeek1Label, repsWeek1Label, weightWeek1Label,
                            exerciseWeek2Label, roundsWeek2Label, repsWeek2Label, weightWeek2Label,
                            exerciseWeek3Label, roundsWeek3Label, repsWeek3Label, weightWeek3Label,
                            exerciseWeek4Label, roundsWeek4Label, repsWeek4Label, weightWeek4Label;
                    private JTextField skillInput,
                            exercise1Week1Input, exercise2Week1Input, exercise3Week1Input,
                            exercise1Week2Input, exercise2Week2Input, exercise3Week2Input,
                            exercise1Week3Input, exercise2Week3Input, exercise3Week3Input,
                            exercise1Week4Input, exercise2Week4Input, exercise3Week4Input,
                            rounds1Week1Input, rounds2Week1Input, rounds3Week1Input,
                            rounds1Week2Input, rounds2Week2Input, rounds3Week2Input,
                            rounds1Week3Input, rounds2Week3Input, rounds3Week3Input,
                            rounds1Week4Input, rounds2Week4Input, rounds3Week4Input,
                            reps1Week1Input, reps2Week1Input, reps3Week1Input,
                            reps1Week2Input, reps2Week2Input, reps3Week2Input,
                            reps1Week3Input, reps2Week3Input, reps3Week3Input,
                            reps1Week4Input, reps2Week4Input, reps3Week4Input,
                            weight1Week1Input, weight2Week1Input, weight3Week1Input,
                            weight1Week2Input, weight2Week2Input, weight3Week2Input,
                            weight1Week3Input, weight2Week3Input, weight3Week3Input,
                            weight1Week4Input, weight2Week4Input, weight3Week4Input;
                    private int reps, reps4, rounds, week1Count, week2Count, week3Count, week4Count;

                    public ScheduleDialogPanel() {
                        //fixed values for the reps, reps4 and rounds
                        reps = 5;
                        reps4 = 1;
                        rounds = 5;

                        //fixed percentages for the counts per week
                        week1Count = 75;
                        week2Count = 85;
                        week3Count = 95;
                        week4Count = 100;

                        setLayout(null);

                        skillLabel = new JLabel("Schedule: ");
                        skillLabel.setFont(new Font("", Font.BOLD, 18));
                        skillLabel.setForeground(Color.WHITE);
                        skillInput = new JTextField(20);
                        skillInput.setBackground(null);
                        skillInput.setBorder(null);
                        skillInput.setText("Clean and Jerk");
                        week1 = new JLabel("Week 1");
                        week1.setForeground(Color.PINK);
                        week2 = new JLabel("Week 2");
                        week2.setForeground(Color.PINK);
                        week3 = new JLabel("Week 3");
                        week3.setForeground(Color.PINK);
                        week4 = new JLabel("Week 4");
                        week4.setForeground(Color.PINK);

                        //labels & textfields week 1
                        exerciseWeek1Label = new JLabel("Exercise");
                        exerciseWeek1Label.setForeground(Color.WHITE);
                        exercise1Week1Input = new JTextField(20);
                        exercise2Week1Input = new JTextField(20);
                        exercise3Week1Input = new JTextField(20);
                        roundsWeek1Label = new JLabel("Rounds");
                        roundsWeek1Label.setForeground(Color.WHITE);
                        rounds1Week1Input = new JTextField(20);
                        rounds2Week1Input = new JTextField(20);
                        rounds3Week1Input = new JTextField(20);
                        repsWeek1Label = new JLabel("Reps");
                        repsWeek1Label.setForeground(Color.WHITE);
                        reps1Week1Input = new JTextField(20);
                        reps2Week1Input = new JTextField(20);
                        reps3Week1Input = new JTextField(20);
                        weightWeek1Label = new JLabel("Weight");
                        weightWeek1Label.setForeground(Color.WHITE);
                        weight1Week1Input = new JTextField(20);
                        weight2Week1Input = new JTextField(20);
                        weight3Week1Input = new JTextField(20);

                        //labels & textfields week 2
                        exerciseWeek2Label = new JLabel("Exercise");
                        exerciseWeek2Label.setForeground(Color.WHITE);
                        exercise1Week2Input = new JTextField(20);
                        exercise2Week2Input = new JTextField(20);
                        exercise3Week2Input = new JTextField(20);
                        roundsWeek2Label = new JLabel("Rounds");
                        roundsWeek2Label.setForeground(Color.WHITE);
                        rounds1Week2Input = new JTextField(20);
                        rounds2Week2Input = new JTextField(20);
                        rounds3Week2Input = new JTextField(20);
                        repsWeek2Label = new JLabel("Reps");
                        repsWeek2Label.setForeground(Color.WHITE);
                        reps1Week2Input = new JTextField(20);
                        reps2Week2Input = new JTextField(20);
                        reps3Week2Input = new JTextField(20);
                        weightWeek2Label = new JLabel("Weight");
                        weightWeek2Label.setForeground(Color.WHITE);
                        weight1Week2Input = new JTextField(20);
                        weight2Week2Input = new JTextField(20);
                        weight3Week2Input = new JTextField(20);

                        //labels & textfields week 3
                        exerciseWeek3Label = new JLabel("Exercise");
                        exerciseWeek3Label.setForeground(Color.WHITE);
                        exercise1Week3Input = new JTextField(20);
                        exercise2Week3Input = new JTextField(20);
                        exercise3Week3Input = new JTextField(20);
                        roundsWeek3Label = new JLabel("Rounds");
                        roundsWeek3Label.setForeground(Color.WHITE);
                        rounds1Week3Input = new JTextField(20);
                        rounds2Week3Input = new JTextField(20);
                        rounds3Week3Input = new JTextField(20);
                        repsWeek3Label = new JLabel("Reps");
                        repsWeek3Label.setForeground(Color.WHITE);
                        reps1Week3Input = new JTextField(20);
                        reps2Week3Input = new JTextField(20);
                        reps3Week3Input = new JTextField(20);
                        weightWeek3Label = new JLabel("Weight");
                        weightWeek3Label.setForeground(Color.WHITE);
                        weight1Week3Input = new JTextField(20);
                        weight2Week3Input = new JTextField(20);
                        weight3Week3Input = new JTextField(20);

                        //labels & textfields week 4
                        exerciseWeek4Label = new JLabel("Exercise");
                        exerciseWeek4Label.setForeground(Color.WHITE);
                        exercise1Week4Input = new JTextField(20);
                        exercise2Week4Input = new JTextField(20);
                        exercise3Week4Input = new JTextField(20);
                        roundsWeek4Label = new JLabel("Rounds");
                        roundsWeek4Label.setForeground(Color.WHITE);
                        rounds1Week4Input = new JTextField(20);
                        rounds2Week4Input = new JTextField(20);
                        rounds3Week4Input = new JTextField(20);
                        repsWeek4Label = new JLabel("Reps");
                        repsWeek4Label.setForeground(Color.WHITE);
                        reps1Week4Input = new JTextField(20);
                        reps2Week4Input = new JTextField(20);
                        reps3Week4Input = new JTextField(20);
                        weightWeek4Label = new JLabel("Weight");
                        weightWeek4Label.setForeground(Color.WHITE);
                        weight1Week4Input = new JTextField(20);
                        weight2Week4Input = new JTextField(20);
                        weight3Week4Input = new JTextField(20);

                        //layout skill label + textfield
                        skillLabel.setBounds(25, 10, 100, 20);
                        skillInput.setBounds(125, 10, 100, 20);

                        //layout schedule week 1
                        week1.setBounds(25, 30, 100, 30);
                        exerciseWeek1Label.setBounds(25, 60, 100, 30);
                        exercise1Week1Input.setBounds(25, 90, 100, 30);
                        exercise2Week1Input.setBounds(25, 120, 100, 30);
                        exercise3Week1Input.setBounds(25, 150, 100, 30);
                        roundsWeek1Label.setBounds(125, 60, 100, 30);
                        rounds1Week1Input.setBounds(125, 90, 100, 30);
                        rounds2Week1Input.setBounds(125, 120, 100, 30);
                        rounds3Week1Input.setBounds(125, 150, 100, 30);
                        repsWeek1Label.setBounds(225, 60, 100, 30);
                        reps1Week1Input.setBounds(225, 90, 100, 30);
                        reps2Week1Input.setBounds(225, 120, 100, 30);
                        reps3Week1Input.setBounds(225, 150, 100, 30);
                        weightWeek1Label.setBounds(325, 60, 100, 30);
                        weight1Week1Input.setBounds(325, 90, 100, 30);
                        weight2Week1Input.setBounds(325, 120, 100, 30);
                        weight3Week1Input.setBounds(325, 150, 100, 30);

                        //layout schedule week 2
                        week2.setBounds(475, 30, 100, 30);
                        exerciseWeek2Label.setBounds(475, 60, 100, 30);
                        exercise1Week2Input.setBounds(475, 90, 100, 30);
                        exercise2Week2Input.setBounds(475, 120, 100, 30);
                        exercise3Week2Input.setBounds(475, 150, 100, 30);
                        roundsWeek2Label.setBounds(575, 60, 100, 30);
                        rounds1Week2Input.setBounds(575, 90, 100, 30);
                        rounds2Week2Input.setBounds(575, 120, 100, 30);
                        rounds3Week2Input.setBounds(575, 150, 100, 30);
                        repsWeek2Label.setBounds(675, 60, 100, 30);
                        reps1Week2Input.setBounds(675, 90, 100, 30);
                        reps2Week2Input.setBounds(675, 120, 100, 30);
                        reps3Week2Input.setBounds(675, 150, 100, 30);
                        weightWeek2Label.setBounds(775, 60, 100, 30);
                        weight1Week2Input.setBounds(775, 90, 100, 30);
                        weight2Week2Input.setBounds(775, 120, 100, 30);
                        weight3Week2Input.setBounds(775, 150, 100, 30);

                        //layout schedule week 3
                        week3.setBounds(25, 405, 100, 30);
                        exerciseWeek3Label.setBounds(25, 435, 100, 30);
                        exercise1Week3Input.setBounds(25, 465, 100, 30);
                        exercise2Week3Input.setBounds(25, 495, 100, 30);
                        exercise3Week3Input.setBounds(25, 525, 100, 30);
                        roundsWeek3Label.setBounds(125, 435, 100, 30);
                        rounds1Week3Input.setBounds(125, 465, 100, 30);
                        rounds2Week3Input.setBounds(125, 495, 100, 30);
                        rounds3Week3Input.setBounds(125, 525, 100, 30);
                        repsWeek3Label.setBounds(225, 435, 100, 30);
                        reps1Week3Input.setBounds(225, 465, 100, 30);
                        reps2Week3Input.setBounds(225, 495, 100, 30);
                        reps3Week3Input.setBounds(225, 525, 100, 30);
                        weightWeek3Label.setBounds(325, 435, 100, 30);
                        weight1Week3Input.setBounds(325, 465, 100, 30);
                        weight2Week3Input.setBounds(325, 495, 100, 30);
                        weight3Week3Input.setBounds(325, 525, 100, 30);

                        //layout schedule week 4
                        week4.setBounds(475, 405, 100, 30);
                        exerciseWeek4Label.setBounds(475, 435, 100, 30);
                        exercise1Week4Input.setBounds(475, 465, 100, 30);
                        exercise2Week4Input.setBounds(475, 495, 100, 30);
                        exercise3Week4Input.setBounds(475, 525, 100, 30);
                        roundsWeek4Label.setBounds(575, 435, 100, 30);
                        rounds1Week4Input.setBounds(575, 465, 100, 30);
                        rounds2Week4Input.setBounds(575, 495, 100, 30);
                        rounds3Week4Input.setBounds(575, 525, 100, 30);
                        repsWeek4Label.setBounds(675, 435, 100, 30);
                        reps1Week4Input.setBounds(675, 465, 100, 30);
                        reps2Week4Input.setBounds(675, 495, 100, 30);
                        reps3Week4Input.setBounds(675, 525, 100, 30);
                        weightWeek4Label.setBounds(775, 435, 100, 30);
                        weight1Week4Input.setBounds(775, 465, 100, 30);
                        weight2Week4Input.setBounds(775, 495, 100, 30);
                        weight3Week4Input.setBounds(775, 525, 100, 30);

                        //Fill schedule textfields
                        //Step 1:
                        //The reps and rounds are fixed values
                        reps1Week1Input.setText("" + reps);
                        rounds1Week1Input.setText("" + rounds);
                        reps2Week1Input.setText("" + reps);
                        rounds2Week1Input.setText("" + rounds);
                        reps3Week1Input.setText("" + reps);
                        rounds3Week1Input.setText("" + rounds);
                        reps1Week2Input.setText("" + reps);
                        rounds1Week2Input.setText("" + rounds);
                        reps2Week2Input.setText("" + reps);
                        rounds2Week2Input.setText("" + rounds);
                        reps3Week2Input.setText("" + reps);
                        rounds3Week2Input.setText("" + rounds);
                        reps1Week3Input.setText("" + reps);
                        rounds1Week3Input.setText("" + rounds);
                        reps2Week3Input.setText("" + reps);
                        rounds2Week3Input.setText("" + rounds);
                        reps3Week3Input.setText("" + reps);
                        rounds3Week3Input.setText("" + rounds);
                        reps1Week4Input.setText("" + reps4);
                        rounds1Week4Input.setText("" + rounds);
                        reps2Week4Input.setText("" + reps4);
                        rounds2Week4Input.setText("" + rounds);
                        reps3Week4Input.setText("" + reps4);
                        rounds3Week4Input.setText("" + rounds);

                        //Step 2:
                        //Get the exercises
                        //Exercises are selected by textfield skillInput,
                        // after choosing the snatch button in the skill menu, the skillInput is "Clean and Jerk schedule"
                        // The query now knows witch exercises are for the snatch schedule
                        //werkt niet, dus hard geprogrammerd!
                        /*

                        exercise1Week1Input.setText(currentSkill.getExerciseC1());
                        exercise2Week1Input.setText(currentSkill.getExerciseC2());
                        exercise3Week1Input.setText(currentSkill.getExerciseC3());
                        exercise1Week2Input.setText(currentSkill.getExerciseC1());
                        exercise2Week2Input.setText(currentSkill.getExerciseC2());
                        exercise3Week2Input.setText(currentSkill.getExerciseC3());
                        exercise1Week3Input.setText(currentSkill.getExerciseC1());
                        exercise2Week3Input.setText(currentSkill.getExerciseC2());
                        exercise3Week3Input.setText(currentSkill.getExerciseC3());
                        exercise1Week4Input.setText(currentSkill.getExerciseC1());
                        exercise2Week4Input.setText(currentSkill.getExerciseC2());
                        exercise3Week4Input.setText(currentSkill.getExerciseC3());

                        }

                         */
                        exercise1Week1Input.setText("Cleanpull");
                        exercise2Week1Input.setText("Clean and Jerk");
                        exercise3Week1Input.setText("Frontsquat");
                        exercise1Week2Input.setText("Cleanpull");
                        exercise2Week2Input.setText("Clean and Jerk");
                        exercise3Week2Input.setText("Frontsquat");
                        exercise1Week3Input.setText("Cleanpull");
                        exercise2Week3Input.setText("Clean and Jerk");
                        exercise3Week3Input.setText("Frontsquat");
                        exercise1Week4Input.setText("Cleanpull");
                        exercise2Week4Input.setText("Clean and Jerk");
                        exercise3Week4Input.setText("Frontsquat");


                        //Step 3:
                        //Counts for weight of the exercises

                        //Count for weight 1 and 2 (cleanpulls and clean and jerk)
                        String exercise12 = cleanJerkGoalInput.getText();
                        int exercise12Weight = Integer.parseInt(exercise12);

                        int resultWeek1Weigt12 = week1Count * exercise12Weight / 100;
                        int resultWeek2Weight12 = week2Count * exercise12Weight / 100;
                        int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                        int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                        weight1Week1Input.setText("" + resultWeek1Weigt12);
                        weight2Week1Input.setText("" + resultWeek1Weigt12);
                        weight1Week2Input.setText("" + resultWeek2Weight12);
                        weight2Week2Input.setText("" + resultWeek2Weight12);
                        weight1Week3Input.setText("" + resultWeek3Weight12);
                        weight2Week3Input.setText("" + resultWeek3Weight12);
                        weight1Week4Input.setText("" + resultWeek4Weight12);
                        weight2Week4Input.setText("" + resultWeek4Weight12);

                        //Count for weight 3 (frontsquat)
                        String frontsquat = frontSquatInput.getText();
                        int frontsquatRM = Integer.parseInt(frontsquat);

                        int resultWeek1 = week1Count * frontsquatRM / 100;
                        int resultWeek2 = week2Count * frontsquatRM / 100;
                        int resultWeek3 = week3Count * frontsquatRM / 100;
                        int resultWeek4 = week4Count * frontsquatRM / 100;

                        weight3Week1Input.setText("" + resultWeek1);
                        weight3Week2Input.setText("" + resultWeek2);
                        weight3Week3Input.setText("" + resultWeek3);
                        weight3Week4Input.setText("" + resultWeek4);


                        //add labels & textfield to panel
                        add(skillLabel);
                        add(skillInput);
                        add(week1);
                        add(week2);
                        add(week3);
                        add(week4);
                        add(exerciseWeek1Label);
                        add(exerciseWeek2Label);
                        add(exerciseWeek3Label);
                        add(exerciseWeek4Label);
                        add(exercise1Week1Input);
                        add(exercise2Week1Input);
                        add(exercise3Week1Input);
                        add(exercise1Week2Input);
                        add(exercise2Week2Input);
                        add(exercise3Week2Input);
                        add(exercise1Week3Input);
                        add(exercise2Week3Input);
                        add(exercise3Week3Input);
                        add(exercise1Week4Input);
                        add(exercise2Week4Input);
                        add(exercise2Week4Input);
                        add(exercise3Week4Input);
                        add(roundsWeek1Label);
                        add(rounds1Week1Input);
                        add(rounds2Week1Input);
                        add(rounds3Week1Input);
                        add(roundsWeek2Label);
                        add(rounds1Week2Input);
                        add(rounds2Week2Input);
                        add(rounds3Week2Input);
                        add(roundsWeek3Label);
                        add(rounds1Week3Input);
                        add(rounds2Week3Input);
                        add(rounds3Week3Input);
                        add(roundsWeek4Label);
                        add(rounds1Week4Input);
                        add(rounds2Week4Input);
                        add(rounds3Week4Input);
                        add(repsWeek1Label);
                        add(reps1Week1Input);
                        add(reps2Week1Input);
                        add(reps3Week1Input);
                        add(repsWeek2Label);
                        add(reps1Week2Input);
                        add(reps2Week2Input);
                        add(reps3Week2Input);
                        add(repsWeek3Label);
                        add(reps1Week3Input);
                        add(reps2Week3Input);
                        add(reps3Week3Input);
                        add(repsWeek4Label);
                        add(reps1Week4Input);
                        add(reps2Week4Input);
                        add(reps3Week4Input);
                        add(weightWeek1Label);
                        add(weight1Week1Input);
                        add(weight2Week1Input);
                        add(weight3Week1Input);
                        add(weightWeek2Label);
                        add(weight1Week2Input);
                        add(weight2Week2Input);
                        add(weight3Week2Input);
                        add(weightWeek3Label);
                        add(weight1Week3Input);
                        add(weight2Week3Input);
                        add(weight3Week3Input);
                        add(weightWeek4Label);
                        add(weight1Week4Input);
                        add(weight2Week4Input);
                        add(weight3Week4Input);


                    }
                }
            }
        }
    }





            /**
             * -------------------------PROGRESS-------------------------------------------
             * Progress menu gives schedules when you are in your 4-week-training
             * Email, weeknumber and snatch/cleanjerk-button are needed for the query en if-statement
             *
             * @return value of SnatchGoalWeight and backSquat or CleanjerkGoalWeight and FrontSquat
             * based on the most recent GoalDate the textfields of the schedule are filled
             */

            public class ProgressDialog extends JDialog {
                private JPanel panelProgress = new JPanel();
                private JLabel img = new JLabel();

                public ProgressDialog() {
                    JDialog progressDialog = new JDialog();
                    progressDialog.setTitle("Your Progress");
                    progressDialog.setSize(900, 750);
                    progressDialog.setLocationRelativeTo(null);
                    progressDialog.setContentPane(new ProgressDialogPanel(new WeightLiftManager()));
                    progressDialog.setModal(true);

                    //background image
                    ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/frontsquatwarmup2.jpg");
                    img = new JLabel(icon1);
                    img.setBounds(0, 0, 900, 700);
                    img.setVisible(true);

                    panelProgress.setBounds(0, 0, 900, 750);
                    panelProgress.add(img);
                    panelProgress.setVisible(true);
                    panelProgress.repaint();

                    progressDialog.add(panelProgress);
                    progressDialog.setVisible(true);
                    progressDialog.repaint();
                }
            }

            public class ProgressDialogPanel extends JPanel {
                private JLabel emailProgressLabel, progressQuestionLabel, week1, week2, week3, week4, commentLabel,
                        exerciseWeek1Label, roundsWeek1Label, repsWeek1Label, weightWeek1Label,
                        exerciseWeek2Label, roundsWeek2Label, repsWeek2Label, weightWeek2Label,
                        exerciseWeek3Label, roundsWeek3Label, repsWeek3Label, weightWeek3Label,
                        exerciseWeek4Label, roundsWeek4Label, repsWeek4Label, weightWeek4Label;
                private JTextField emailProgressInput, progressQuestionInput, backSquatFromDb, frontSquatFromDb, snatchGoalFromDb, cleanJerkFromDb,
                        exercise1Week1Input, exercise2Week1Input, exercise3Week1Input,
                        exercise1Week2Input, exercise2Week2Input, exercise3Week2Input,
                        exercise1Week3Input, exercise2Week3Input, exercise3Week3Input,
                        exercise1Week4Input, exercise2Week4Input, exercise3Week4Input,
                        rounds1Week1Input, rounds2Week1Input, rounds3Week1Input,
                        rounds1Week2Input, rounds2Week2Input, rounds3Week2Input,
                        rounds1Week3Input, rounds2Week3Input, rounds3Week3Input,
                        rounds1Week4Input, rounds2Week4Input, rounds3Week4Input,
                        reps1Week1Input, reps2Week1Input, reps3Week1Input,
                        reps1Week2Input, reps2Week2Input, reps3Week2Input,
                        reps1Week3Input, reps2Week3Input, reps3Week3Input,
                        reps1Week4Input, reps2Week4Input, reps3Week4Input,
                        weight1Week1Input, weight2Week1Input, weight3Week1Input,
                        weight1Week2Input, weight2Week2Input, weight3Week2Input,
                        weight1Week3Input, weight2Week3Input, weight3Week3Input,
                        weight1Week4Input, weight2Week4Input, weight3Week4Input;
                private int reps, reps4, rounds, week1Count, week2Count, week3Count, week4Count;
                private JButton progressButtonSnatch, progressButtonCleanJerk;
                private final WeightLiftManager manager;
                private Schedule currentProgress;
                private ScheduleCleanJerk currentProgressCJ;

                public ProgressDialogPanel(WeightLiftManager weightLiftManager) {
                    //fixed values for the reps, reps4 and rounds
                    reps = 5;
                    reps4 = 1;
                    rounds = 5;

                    //fixed percentages for the counts per week
                    week1Count = 75;
                    week2Count = 85;
                    week3Count = 95;
                    week4Count = 100;

                    setLayout(null);

                    emailProgressLabel = new JLabel("Emailaddress: ");
                    emailProgressLabel.setForeground(Color.WHITE);
                    emailProgressInput = new JTextField(60);
                    progressQuestionLabel = new JLabel("This weeknr I've done (0, 1, 2, 3 or 4): ");
                    progressQuestionLabel.setForeground(Color.WHITE);
                    progressQuestionInput = new JTextField(10);
                    progressButtonSnatch = new JButton("Progress Snatch");
                    progressButtonSnatch.addActionListener(new ProgressSnatchHandler());
                    progressButtonCleanJerk = new JButton("Progress Clean&Jerk");
                    progressButtonCleanJerk.addActionListener(new ProgressCleanJerkHandler());
                    commentLabel = new JLabel("");
                    commentLabel.setForeground(Color.WHITE);
                    commentLabel.setVisible(false);
                    manager = weightLiftManager;
                    currentProgress = null;//Textfields from db schedulesnatch
                    currentProgressCJ = null;//Textfields from db schedulecleanjerk
                    backSquatFromDb = new JTextField(30);
                    backSquatFromDb.setVisible(false);
                    frontSquatFromDb = new JTextField(30);
                    frontSquatFromDb.setVisible(false);
                    snatchGoalFromDb = new JTextField(30);
                    snatchGoalFromDb.setVisible(false);
                    cleanJerkFromDb = new JTextField(30);
                    cleanJerkFromDb.setVisible(false);
                    //JLabels JTextfields week 1
                    week1 = new JLabel("Week 1");
                    week1.setForeground(Color.BLUE);
                    week1.setVisible(false);
                    exerciseWeek1Label = new JLabel("Exercise");
                    exerciseWeek1Label.setForeground(Color.WHITE);
                    exerciseWeek1Label.setVisible(false);
                    exercise1Week1Input = new JTextField(60);
                    exercise1Week1Input.setVisible(true);
                    exercise2Week1Input = new JTextField(60);
                    exercise2Week1Input.setVisible(false);
                    exercise3Week1Input = new JTextField(60);
                    exercise3Week1Input.setVisible(false);
                    roundsWeek1Label = new JLabel("Rounds");
                    roundsWeek1Label.setForeground(Color.WHITE);
                    roundsWeek1Label.setVisible(false);
                    rounds1Week1Input = new JTextField(30);
                    rounds1Week1Input.setVisible(false);
                    rounds2Week1Input = new JTextField(30);
                    rounds2Week1Input.setVisible(false);
                    rounds3Week1Input = new JTextField(30);
                    rounds3Week1Input.setVisible(false);
                    repsWeek1Label = new JLabel("Reps");
                    repsWeek1Label.setForeground(Color.WHITE);
                    repsWeek1Label.setVisible(false);
                    reps1Week1Input = new JTextField(30);
                    reps1Week1Input.setVisible(false);
                    reps2Week1Input = new JTextField(30);
                    reps2Week1Input.setVisible(false);
                    reps3Week1Input = new JTextField(30);
                    reps3Week1Input.setVisible(false);
                    weightWeek1Label = new JLabel("Weight");
                    weightWeek1Label.setForeground(Color.WHITE);
                    weightWeek1Label.setVisible(false);
                    weight1Week1Input = new JTextField(30);
                    weight1Week1Input.setVisible(false);
                    weight2Week1Input = new JTextField(30);
                    weight2Week1Input.setVisible(false);
                    weight3Week1Input = new JTextField(30);
                    weight3Week1Input.setVisible(false);
                    //JLabels JTextfields week 2
                    week2 = new JLabel("Week 2");
                    week2.setForeground(Color.BLUE);
                    week2.setVisible(false);
                    exerciseWeek2Label = new JLabel("Exercise");
                    exerciseWeek2Label.setForeground(Color.WHITE);
                    exerciseWeek2Label.setVisible(false);
                    exercise1Week2Input = new JTextField(60);
                    exercise1Week2Input.setVisible(true);
                    exercise2Week2Input = new JTextField(60);
                    exercise2Week2Input.setVisible(false);
                    exercise3Week2Input = new JTextField(60);
                    exercise3Week2Input.setVisible(false);
                    roundsWeek2Label = new JLabel("Rounds");
                    roundsWeek2Label.setForeground(Color.WHITE);
                    roundsWeek2Label.setVisible(false);
                    rounds1Week2Input = new JTextField(30);
                    rounds1Week2Input.setVisible(false);
                    rounds2Week2Input = new JTextField(30);
                    rounds2Week2Input.setVisible(false);
                    rounds3Week2Input = new JTextField(30);
                    rounds3Week2Input.setVisible(false);
                    repsWeek2Label = new JLabel("Reps");
                    repsWeek2Label.setForeground(Color.WHITE);
                    repsWeek2Label.setVisible(false);
                    reps1Week2Input = new JTextField(30);
                    reps1Week2Input.setVisible(false);
                    reps2Week2Input = new JTextField(30);
                    reps2Week2Input.setVisible(false);
                    reps3Week2Input = new JTextField(30);
                    reps3Week2Input.setVisible(false);
                    weightWeek2Label = new JLabel("Weight");
                    weightWeek2Label.setForeground(Color.WHITE);
                    weightWeek2Label.setVisible(false);
                    weight1Week2Input = new JTextField(30);
                    weight1Week2Input.setVisible(false);
                    weight2Week2Input = new JTextField(30);
                    weight2Week2Input.setVisible(false);
                    weight3Week2Input = new JTextField(30);
                    weight3Week2Input.setVisible(false);
                    //JLabels JTextfields week 3
                    week3 = new JLabel("Week 3");
                    week3.setForeground(Color.BLUE);
                    week3.setVisible(false);
                    exerciseWeek3Label = new JLabel("Exercise");
                    exerciseWeek3Label.setForeground(Color.WHITE);
                    exerciseWeek3Label.setVisible(false);
                    exercise1Week3Input = new JTextField(60);
                    exercise1Week3Input.setVisible(true);
                    exercise2Week3Input = new JTextField(60);
                    exercise2Week3Input.setVisible(false);
                    exercise3Week3Input = new JTextField(60);
                    exercise3Week3Input.setVisible(false);
                    roundsWeek3Label = new JLabel("Rounds");
                    roundsWeek3Label.setForeground(Color.WHITE);
                    roundsWeek3Label.setVisible(false);
                    rounds1Week3Input = new JTextField(30);
                    rounds1Week3Input.setVisible(false);
                    rounds2Week3Input = new JTextField(30);
                    rounds2Week3Input.setVisible(false);
                    rounds3Week3Input = new JTextField(30);
                    rounds3Week3Input.setVisible(false);
                    repsWeek3Label = new JLabel("Reps");
                    repsWeek3Label.setForeground(Color.WHITE);
                    repsWeek3Label.setVisible(false);
                    reps1Week3Input = new JTextField(30);
                    reps1Week3Input.setVisible(false);
                    reps2Week3Input = new JTextField(30);
                    reps2Week3Input.setVisible(false);
                    reps3Week3Input = new JTextField(30);
                    reps3Week3Input.setVisible(false);
                    weightWeek3Label = new JLabel("Weight");
                    weightWeek3Label.setForeground(Color.WHITE);
                    weightWeek3Label.setVisible(false);
                    weight1Week3Input = new JTextField(30);
                    weight1Week3Input.setVisible(false);
                    weight2Week3Input = new JTextField(30);
                    weight2Week3Input.setVisible(false);
                    weight3Week3Input = new JTextField(30);
                    weight3Week3Input.setVisible(false);
                    //JLabels JTextfields week 4
                    week4 = new JLabel("Week 4");
                    week4.setForeground(Color.BLUE);
                    week4.setVisible(false);
                    exerciseWeek4Label = new JLabel("Exercise");
                    exerciseWeek4Label.setForeground(Color.WHITE);
                    exerciseWeek4Label.setVisible(false);
                    exercise1Week4Input = new JTextField(60);
                    exercise1Week4Input.setVisible(true);
                    exercise2Week4Input = new JTextField(60);
                    exercise2Week4Input.setVisible(false);
                    exercise3Week4Input = new JTextField(60);
                    exercise3Week4Input.setVisible(false);
                    roundsWeek4Label = new JLabel("Rounds");
                    roundsWeek4Label.setForeground(Color.WHITE);
                    roundsWeek4Label.setVisible(false);
                    rounds1Week4Input = new JTextField(30);
                    rounds1Week4Input.setVisible(false);
                    rounds2Week4Input = new JTextField(30);
                    rounds2Week4Input.setVisible(false);
                    rounds3Week4Input = new JTextField(30);
                    rounds3Week4Input.setVisible(false);
                    repsWeek4Label = new JLabel("Reps");
                    repsWeek4Label.setForeground(Color.WHITE);
                    repsWeek4Label.setVisible(false);
                    reps1Week4Input = new JTextField(30);
                    reps1Week4Input.setVisible(false);
                    reps2Week4Input = new JTextField(30);
                    reps2Week4Input.setVisible(false);
                    reps3Week4Input = new JTextField(30);
                    reps3Week4Input.setVisible(false);
                    weightWeek4Label = new JLabel("Weight");
                    weightWeek4Label.setForeground(Color.WHITE);
                    weightWeek4Label.setVisible(false);
                    weight1Week4Input = new JTextField(30);
                    weight1Week4Input.setVisible(false);
                    weight2Week4Input = new JTextField(30);
                    weight2Week4Input.setVisible(false);
                    weight3Week4Input = new JTextField(30);
                    weight3Week4Input.setVisible(false);

                    //layout Progress input information
                    emailProgressLabel.setBounds(20, 50, 200, 30);
                    emailProgressInput.setBounds(270, 50, 200, 30);
                    progressQuestionLabel.setBounds(20, 100, 220, 30);
                    progressQuestionInput.setBounds(270, 100, 200, 30);
                    progressButtonSnatch.setBounds(500, 50, 200, 30);
                    progressButtonCleanJerk.setBounds(500, 100, 200, 30);
                    commentLabel.setBounds(500, 150, 400, 30);

                    //layout textfields from db
                    backSquatFromDb.setBounds(20, 150, 100, 30);
                    snatchGoalFromDb.setBounds(125, 150, 100, 30);
                    frontSquatFromDb.setBounds(230, 150, 100, 30);
                    cleanJerkFromDb.setBounds(335, 150, 100, 30);

                    add(emailProgressLabel);
                    add(emailProgressInput);
                    add(progressQuestionLabel);
                    add(progressQuestionInput);
                    add(progressButtonSnatch);
                    add(progressButtonCleanJerk);
                    add(commentLabel);
                    add(backSquatFromDb);
                    add(snatchGoalFromDb);
                    add(frontSquatFromDb);
                    add(cleanJerkFromDb);
                    add(week1);
                    add(exerciseWeek1Label);
                    add(exercise1Week1Input);
                    add(exercise2Week1Input);
                    add(exercise3Week1Input);
                    add(roundsWeek1Label);
                    add(rounds1Week1Input);
                    add(rounds2Week1Input);
                    add(rounds3Week1Input);
                    add(repsWeek1Label);
                    add(reps1Week1Input);
                    add(reps2Week1Input);
                    add(reps3Week1Input);
                    add(weightWeek1Label);
                    add(weight1Week1Input);
                    add(weight2Week1Input);
                    add(weight3Week1Input);
                    add(week2);
                    add(exerciseWeek2Label);
                    add(exercise1Week2Input);
                    add(exercise2Week2Input);
                    add(exercise3Week2Input);
                    add(roundsWeek2Label);
                    add(rounds1Week2Input);
                    add(rounds2Week2Input);
                    add(rounds3Week2Input);
                    add(repsWeek2Label);
                    add(reps1Week2Input);
                    add(reps2Week2Input);
                    add(reps3Week2Input);
                    add(weightWeek2Label);
                    add(weight1Week2Input);
                    add(weight2Week2Input);
                    add(weight3Week2Input);
                    add(week3);
                    add(exerciseWeek3Label);
                    add(exercise1Week3Input);
                    add(exercise2Week3Input);
                    add(exercise3Week3Input);
                    add(roundsWeek3Label);
                    add(rounds1Week3Input);
                    add(rounds2Week3Input);
                    add(rounds3Week3Input);
                    add(repsWeek3Label);
                    add(reps1Week3Input);
                    add(reps2Week3Input);
                    add(reps3Week3Input);
                    add(weightWeek3Label);
                    add(weight1Week3Input);
                    add(weight2Week3Input);
                    add(weight3Week3Input);
                    add(week4);
                    add(exerciseWeek4Label);
                    add(exercise1Week4Input);
                    add(exercise2Week4Input);
                    add(exercise3Week4Input);
                    add(roundsWeek4Label);
                    add(rounds1Week4Input);
                    add(rounds2Week4Input);
                    add(rounds3Week4Input);
                    add(repsWeek4Label);
                    add(reps1Week4Input);
                    add(reps2Week4Input);
                    add(reps3Week4Input);
                    add(weightWeek4Label);
                    add(weight1Week4Input);
                    add(weight2Week4Input);
                    add(weight3Week4Input);
                }

                //HANDLERS of Progress
                //----------------------PROGRESS SKILL SNATCH---------------------------------------------
                //ProgressSnatchHandler getting the values of the backsquat and snatchgoalweight from snatchschedule
                //@return Email and most recent values are shown
                //Weeknumbers show the schedules are the athlete still have to do

                class ProgressSnatchHandler implements ActionListener {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == progressButtonSnatch) {
                            String email = emailProgressInput.getText();
                            doFindProgressSnatch(email);

                            String weekNumber = progressQuestionInput.getText();
                            try {
                                int resultWeek = Integer.parseInt(weekNumber);

                                if (resultWeek == 0) {
                                    //Step 1: show schedules 1, 2, 3 and 4
                                    commentLabel.setText("You're starting this schedule. Good luck");
                                    commentLabel.setVisible(true);
                                    week1.setVisible(true);
                                    week1.setBounds(25, 200, 200, 30);
                                    exerciseWeek1Label.setVisible(true);
                                    exerciseWeek1Label.setBounds(25, 240, 100, 30);
                                    exercise1Week1Input.setVisible(true);
                                    exercise1Week1Input.setBounds(25, 270, 100, 30);
                                    exercise2Week1Input.setVisible(true);
                                    exercise2Week1Input.setBounds(25, 300, 100, 30);
                                    exercise3Week1Input.setVisible(true);
                                    exercise3Week1Input.setBounds(25, 330, 100, 30);
                                    roundsWeek1Label.setVisible(true);
                                    roundsWeek1Label.setBounds(125, 240, 100, 30);
                                    rounds1Week1Input.setVisible(true);
                                    rounds1Week1Input.setBounds(125, 270, 100, 30);
                                    rounds2Week1Input.setVisible(true);
                                    rounds2Week1Input.setBounds(125, 300, 100, 30);
                                    rounds3Week1Input.setVisible(true);
                                    rounds3Week1Input.setBounds(125, 330, 100, 30);
                                    repsWeek1Label.setVisible(true);
                                    repsWeek1Label.setBounds(225, 240, 100, 30);
                                    reps1Week1Input.setVisible(true);
                                    reps1Week1Input.setBounds(225, 270, 100, 30);
                                    reps2Week1Input.setVisible(true);
                                    reps2Week1Input.setBounds(225, 300, 100, 30);
                                    reps3Week1Input.setVisible(true);
                                    reps3Week1Input.setBounds(225, 330, 100, 30);
                                    weightWeek1Label.setVisible(true);
                                    weightWeek1Label.setBounds(325, 240, 100, 30);
                                    weight1Week1Input.setVisible(true);
                                    weight1Week1Input.setBounds(325, 270, 100, 30);
                                    weight2Week1Input.setVisible(true);
                                    weight2Week1Input.setBounds(325, 300, 100, 30);
                                    weight3Week1Input.setVisible(true);
                                    weight3Week1Input.setBounds(325, 330, 100, 30);
                                    week2.setVisible(true);
                                    week2.setBounds(475, 200, 100, 30);
                                    exerciseWeek2Label.setVisible(true);
                                    exerciseWeek2Label.setBounds(475, 240, 100, 30);
                                    exercise1Week2Input.setVisible(true);
                                    exercise1Week2Input.setBounds(475, 270, 100, 30);
                                    exercise2Week2Input.setVisible(true);
                                    exercise2Week2Input.setBounds(475, 300, 100, 30);
                                    exercise3Week2Input.setVisible(true);
                                    exercise3Week2Input.setBounds(475, 330, 100, 30);
                                    roundsWeek2Label.setVisible(true);
                                    roundsWeek2Label.setBounds(575, 240, 100, 30);
                                    rounds1Week2Input.setVisible(true);
                                    rounds1Week2Input.setBounds(575, 270, 100, 30);
                                    rounds2Week2Input.setVisible(true);
                                    rounds2Week2Input.setBounds(575, 300, 100, 30);
                                    rounds3Week2Input.setVisible(true);
                                    rounds3Week2Input.setBounds(575, 330, 100, 30);
                                    repsWeek2Label.setVisible(true);
                                    repsWeek2Label.setBounds(675, 240, 100, 30);
                                    reps1Week2Input.setVisible(true);
                                    reps1Week2Input.setBounds(675, 270, 100, 30);
                                    reps2Week2Input.setVisible(true);
                                    reps2Week2Input.setBounds(675, 300, 100, 30);
                                    reps3Week2Input.setVisible(true);
                                    reps3Week2Input.setBounds(675, 330, 100, 30);
                                    weightWeek2Label.setVisible(true);
                                    weightWeek2Label.setBounds(775, 240, 100, 30);
                                    weight1Week2Input.setVisible(true);
                                    weight1Week2Input.setBounds(775, 270, 100, 30);
                                    weight2Week2Input.setVisible(true);
                                    weight2Week2Input.setBounds(775, 300, 100, 30);
                                    weight3Week2Input.setVisible(true);
                                    weight3Week2Input.setBounds(775, 330, 100, 30);
                                    week3.setVisible(true);
                                    week3.setBounds(25, 370, 100, 30);
                                    exerciseWeek3Label.setVisible(true);
                                    exerciseWeek3Label.setBounds(25, 400, 100, 30);
                                    exercise1Week3Input.setVisible(true);
                                    exercise1Week3Input.setBounds(25, 430, 100, 30);
                                    exercise2Week3Input.setVisible(true);
                                    exercise2Week3Input.setBounds(25, 460, 100, 30);
                                    exercise3Week3Input.setVisible(true);
                                    exercise3Week3Input.setBounds(25, 490, 100, 30);
                                    roundsWeek3Label.setVisible(true);
                                    roundsWeek3Label.setBounds(125, 400, 100, 30);
                                    rounds1Week3Input.setVisible(true);
                                    rounds1Week3Input.setBounds(125, 430, 100, 30);
                                    rounds2Week3Input.setVisible(true);
                                    rounds2Week3Input.setBounds(125, 460, 100, 30);
                                    rounds3Week3Input.setVisible(true);
                                    rounds3Week3Input.setBounds(125, 490, 100, 30);
                                    repsWeek3Label.setVisible(true);
                                    repsWeek3Label.setBounds(225, 400, 100, 30);
                                    reps1Week3Input.setVisible(true);
                                    reps1Week3Input.setBounds(225, 430, 100, 30);
                                    reps2Week3Input.setVisible(true);
                                    reps2Week3Input.setBounds(225, 460, 100, 30);
                                    reps3Week3Input.setVisible(true);
                                    reps3Week3Input.setBounds(225, 490, 100, 30);
                                    weightWeek3Label.setVisible(true);
                                    weightWeek3Label.setBounds(325, 400, 100, 30);
                                    weight1Week3Input.setVisible(true);
                                    weight1Week3Input.setBounds(325, 430, 100, 30);
                                    weight2Week3Input.setVisible(true);
                                    weight2Week3Input.setBounds(325, 460, 100, 30);
                                    weight3Week3Input.setVisible(true);
                                    weight3Week3Input.setBounds(325, 490, 100, 30);
                                    week4.setVisible(true);
                                    week4.setBounds(475, 370, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(475, 400, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(475, 430, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(475, 460, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(475, 490, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(575, 400, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(575, 430, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(575, 460, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(575, 490, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(675, 400, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(675, 430, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(675, 460, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(675, 490, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(775, 400, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(775, 430, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(775, 460, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(775, 490, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week1Input.setText("" + reps);
                                    rounds1Week1Input.setText("" + rounds);
                                    reps2Week1Input.setText("" + reps);
                                    rounds2Week1Input.setText("" + rounds);
                                    reps3Week1Input.setText("" + reps);
                                    rounds3Week1Input.setText("" + rounds);
                                    reps1Week2Input.setText("" + reps);
                                    rounds1Week2Input.setText("" + rounds);
                                    reps2Week2Input.setText("" + reps);
                                    rounds2Week2Input.setText("" + rounds);
                                    reps3Week2Input.setText("" + reps);
                                    rounds3Week2Input.setText("" + rounds);
                                    reps1Week3Input.setText("" + reps);
                                    rounds1Week3Input.setText("" + rounds);
                                    reps2Week3Input.setText("" + reps);
                                    rounds2Week3Input.setText("" + rounds);
                                    reps3Week3Input.setText("" + reps);
                                    rounds3Week3Input.setText("" + rounds);
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week1Input.setText("Snatchpull");
                                    exercise2Week1Input.setText("Snatch");
                                    exercise3Week1Input.setText("Backsquat");
                                    exercise1Week2Input.setText("Snatchpull");
                                    exercise2Week2Input.setText("Snatch");
                                    exercise3Week2Input.setText("Backsquat");
                                    exercise1Week3Input.setText("Snatchpull");
                                    exercise2Week3Input.setText("Snatch");
                                    exercise3Week3Input.setText("Backsquat");
                                    exercise1Week4Input.setText("Snatchpull");
                                    exercise2Week4Input.setText("Snatch");
                                    exercise3Week4Input.setText("Backsquat");

                                    //step 4: Count the weight with the backsquat and snatchgoalweight
                                    //from the values of backSquatFromDb & snatchGoalFromDb
                                    String exercise12 = snatchGoalFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek1Weigt12 = week1Count * exercise12Weight / 100;
                                    int resultWeek2Weight12 = week2Count * exercise12Weight / 100;
                                    int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week1Input.setText("" + resultWeek1Weigt12);
                                    weight2Week1Input.setText("" + resultWeek1Weigt12);
                                    weight1Week2Input.setText("" + resultWeek2Weight12);
                                    weight2Week2Input.setText("" + resultWeek2Weight12);
                                    weight1Week3Input.setText("" + resultWeek3Weight12);
                                    weight2Week3Input.setText("" + resultWeek3Weight12);
                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (backsquat)
                                    String backsquat = backSquatFromDb.getText();
                                    int backsquatRM = Integer.parseInt(backsquat);

                                    int resultWeek1 = week1Count * backsquatRM / 100;
                                    int resultWeek2 = week2Count * backsquatRM / 100;
                                    int resultWeek3 = week3Count * backsquatRM / 100;
                                    int resultWeek4 = week4Count * backsquatRM / 100;

                                    weight3Week1Input.setText("" + resultWeek1);
                                    weight3Week2Input.setText("" + resultWeek2);
                                    weight3Week3Input.setText("" + resultWeek3);
                                    weight3Week4Input.setText("" + resultWeek4);


                                }

                                if (resultWeek == 1) {
                                    //Step 1: Show schedule 2, 3, and 4
                                    commentLabel.setText("You did week: " + resultWeek + ". Good luck with week 2, 3 and 4");
                                    commentLabel.setVisible(true);
                                    week2.setVisible(true);
                                    week2.setBounds(25, 200, 100, 30);
                                    exerciseWeek2Label.setVisible(true);
                                    exerciseWeek2Label.setBounds(25, 240, 100, 30);
                                    exercise1Week2Input.setVisible(true);
                                    exercise1Week2Input.setBounds(25, 270, 100, 30);
                                    exercise2Week2Input.setVisible(true);
                                    exercise2Week2Input.setBounds(25, 300, 100, 30);
                                    exercise3Week2Input.setVisible(true);
                                    exercise3Week2Input.setBounds(25, 330, 100, 30);
                                    roundsWeek2Label.setVisible(true);
                                    roundsWeek2Label.setBounds(125, 240, 100, 30);
                                    rounds1Week2Input.setVisible(true);
                                    rounds1Week2Input.setBounds(125, 270, 100, 30);
                                    rounds2Week2Input.setVisible(true);
                                    rounds2Week2Input.setBounds(125, 300, 100, 30);
                                    rounds3Week2Input.setVisible(true);
                                    rounds3Week2Input.setBounds(125, 330, 100, 30);
                                    repsWeek2Label.setVisible(true);
                                    repsWeek2Label.setBounds(225, 240, 100, 30);
                                    reps1Week2Input.setVisible(true);
                                    reps1Week2Input.setBounds(225, 270, 100, 30);
                                    reps2Week2Input.setVisible(true);
                                    reps2Week2Input.setBounds(225, 300, 100, 30);
                                    reps3Week2Input.setVisible(true);
                                    reps3Week2Input.setBounds(225, 330, 100, 30);
                                    weightWeek2Label.setVisible(true);
                                    weightWeek2Label.setBounds(325, 240, 100, 30);
                                    weight1Week2Input.setVisible(true);
                                    weight1Week2Input.setBounds(325, 270, 100, 30);
                                    weight2Week2Input.setVisible(true);
                                    weight2Week2Input.setBounds(325, 300, 100, 30);
                                    weight3Week2Input.setVisible(true);
                                    weight3Week2Input.setBounds(325, 330, 100, 30);
                                    week3.setVisible(true);
                                    week3.setBounds(475, 200, 100, 30);
                                    exerciseWeek3Label.setVisible(true);
                                    exerciseWeek3Label.setBounds(475, 240, 100, 30);
                                    exercise1Week3Input.setVisible(true);
                                    exercise1Week3Input.setBounds(475, 270, 100, 30);
                                    exercise2Week3Input.setVisible(true);
                                    exercise2Week3Input.setBounds(475, 300, 100, 30);
                                    exercise3Week3Input.setVisible(true);
                                    exercise3Week3Input.setBounds(475, 330, 100, 30);
                                    roundsWeek3Label.setVisible(true);
                                    roundsWeek3Label.setBounds(575, 240, 100, 30);
                                    rounds1Week3Input.setVisible(true);
                                    rounds1Week3Input.setBounds(575, 270, 100, 30);
                                    rounds2Week3Input.setVisible(true);
                                    rounds2Week3Input.setBounds(575, 300, 100, 30);
                                    rounds3Week3Input.setVisible(true);
                                    rounds3Week3Input.setBounds(575, 330, 100, 30);
                                    repsWeek3Label.setVisible(true);
                                    repsWeek3Label.setBounds(675, 240, 100, 30);
                                    reps1Week3Input.setVisible(true);
                                    reps1Week3Input.setBounds(675, 270, 100, 30);
                                    reps2Week3Input.setVisible(true);
                                    reps2Week3Input.setBounds(675, 300, 100, 30);
                                    reps3Week3Input.setVisible(true);
                                    reps3Week3Input.setBounds(675, 330, 100, 30);
                                    weightWeek3Label.setVisible(true);
                                    weightWeek3Label.setBounds(775, 240, 100, 30);
                                    weight1Week3Input.setVisible(true);
                                    weight1Week3Input.setBounds(775, 270, 100, 30);
                                    weight2Week3Input.setVisible(true);
                                    weight2Week3Input.setBounds(775, 300, 100, 30);
                                    weight3Week3Input.setVisible(true);
                                    weight3Week3Input.setBounds(775, 330, 100, 30);
                                    week4.setVisible(true);
                                    week4.setBounds(25, 370, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(25, 400, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(25, 430, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(25, 460, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(25, 490, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(125, 400, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(125, 430, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(125, 460, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(125, 490, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(225, 400, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(225, 430, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(225, 460, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(225, 490, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(325, 400, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(325, 430, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(325, 460, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(325, 490, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week2Input.setText("" + reps);
                                    rounds1Week2Input.setText("" + rounds);
                                    reps2Week2Input.setText("" + reps);
                                    rounds2Week2Input.setText("" + rounds);
                                    reps3Week2Input.setText("" + reps);
                                    rounds3Week2Input.setText("" + rounds);
                                    reps1Week3Input.setText("" + reps);
                                    rounds1Week3Input.setText("" + rounds);
                                    reps2Week3Input.setText("" + reps);
                                    rounds2Week3Input.setText("" + rounds);
                                    reps3Week3Input.setText("" + reps);
                                    rounds3Week3Input.setText("" + rounds);
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week2Input.setText("Snatchpull");
                                    exercise2Week2Input.setText("Snatch");
                                    exercise3Week2Input.setText("Backsquat");
                                    exercise1Week3Input.setText("Snatchpull");
                                    exercise2Week3Input.setText("Snatch");
                                    exercise3Week3Input.setText("Backsquat");
                                    exercise1Week4Input.setText("Snatchpull");
                                    exercise2Week4Input.setText("Snatch");
                                    exercise3Week4Input.setText("Backsquat");

                                    //step 4: Count the weight with the backsquat and snatchgoalweight
                                    //from the values of backSquatFromDb & snatchGoalFromDb
                                    String exercise12 = snatchGoalFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek2Weight12 = week2Count * exercise12Weight / 100;
                                    int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week2Input.setText("" + resultWeek2Weight12);
                                    weight2Week2Input.setText("" + resultWeek2Weight12);
                                    weight1Week3Input.setText("" + resultWeek3Weight12);
                                    weight2Week3Input.setText("" + resultWeek3Weight12);
                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (backsquat)
                                    String backsquat = backSquatFromDb.getText();
                                    int backsquatRM = Integer.parseInt(backsquat);

                                    int resultWeek2 = week2Count * backsquatRM / 100;
                                    int resultWeek3 = week3Count * backsquatRM / 100;
                                    int resultWeek4 = week4Count * backsquatRM / 100;

                                    weight3Week2Input.setText("" + resultWeek2);
                                    weight3Week3Input.setText("" + resultWeek3);
                                    weight3Week4Input.setText("" + resultWeek4);


                                }

                                if (resultWeek == 2) {
                                    //Step 1: Show schedule 3 and 4
                                    commentLabel.setText("You did week: " + resultWeek + ". Great work, good luck with week 3 and 4");
                                    commentLabel.setVisible(true);
                                    week3.setVisible(true);
                                    week3.setBounds(25, 200, 100, 30);
                                    exerciseWeek3Label.setVisible(true);
                                    exerciseWeek3Label.setBounds(25, 240, 100, 30);
                                    exercise1Week3Input.setVisible(true);
                                    exercise1Week3Input.setBounds(25, 270, 100, 30);
                                    exercise2Week3Input.setVisible(true);
                                    exercise2Week3Input.setBounds(25, 300, 100, 30);
                                    exercise3Week3Input.setVisible(true);
                                    exercise3Week3Input.setBounds(25, 330, 100, 30);
                                    roundsWeek3Label.setVisible(true);
                                    roundsWeek3Label.setBounds(125, 240, 100, 30);
                                    rounds1Week3Input.setVisible(true);
                                    rounds1Week3Input.setBounds(125, 270, 100, 30);
                                    rounds2Week3Input.setVisible(true);
                                    rounds2Week3Input.setBounds(125, 300, 100, 30);
                                    rounds3Week3Input.setVisible(true);
                                    rounds3Week3Input.setBounds(125, 330, 100, 30);
                                    repsWeek3Label.setVisible(true);
                                    repsWeek3Label.setBounds(225, 240, 100, 30);
                                    reps1Week3Input.setVisible(true);
                                    reps1Week3Input.setBounds(225, 270, 100, 30);
                                    reps2Week3Input.setVisible(true);
                                    reps2Week3Input.setBounds(225, 300, 100, 30);
                                    reps3Week3Input.setVisible(true);
                                    reps3Week3Input.setBounds(225, 330, 100, 30);
                                    weightWeek3Label.setVisible(true);
                                    weightWeek3Label.setBounds(325, 240, 100, 30);
                                    weight1Week3Input.setVisible(true);
                                    weight1Week3Input.setBounds(325, 270, 100, 30);
                                    weight2Week3Input.setVisible(true);
                                    weight2Week3Input.setBounds(325, 300, 100, 30);
                                    weight3Week3Input.setVisible(true);
                                    weight3Week3Input.setBounds(325, 330, 100, 30);
                                    week4.setVisible(true);
                                    week4.setBounds(475, 200, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(475, 240, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(475, 270, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(475, 300, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(475, 330, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(575, 240, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(575, 270, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(575, 300, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(575, 330, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(675, 240, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(675, 270, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(675, 300, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(675, 330, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(775, 240, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(775, 270, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(775, 300, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(775, 330, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week3Input.setText("" + reps);
                                    rounds1Week3Input.setText("" + rounds);
                                    reps2Week3Input.setText("" + reps);
                                    rounds2Week3Input.setText("" + rounds);
                                    reps3Week3Input.setText("" + reps);
                                    rounds3Week3Input.setText("" + rounds);
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week3Input.setText("Snatchpull");
                                    exercise2Week3Input.setText("Snatch");
                                    exercise3Week3Input.setText("Backsquat");
                                    exercise1Week4Input.setText("Snatchpull");
                                    exercise2Week4Input.setText("Snatch");
                                    exercise3Week4Input.setText("Backsquat");

                                    //step 4: Count the weight with the backsquat and snatchgoalweight
                                    //from the values of backSquatFromDb & snatchGoalFromDb
                                    String exercise12 = snatchGoalFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week3Input.setText("" + resultWeek3Weight12);
                                    weight2Week3Input.setText("" + resultWeek3Weight12);
                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (backsquat)
                                    String backsquat = backSquatFromDb.getText();
                                    int backsquatRM = Integer.parseInt(backsquat);

                                    int resultWeek3 = week3Count * backsquatRM / 100;
                                    int resultWeek4 = week4Count * backsquatRM / 100;

                                    weight3Week3Input.setText("" + resultWeek3);
                                    weight3Week4Input.setText("" + resultWeek4);
                                }
                                if (resultWeek == 3) {
                                    //Step 1: Show schedule 4
                                    commentLabel.setText("You did week: " + resultWeek + ". Great work, good luck with week 4");
                                    commentLabel.setVisible(true);
                                    week4.setVisible(true);
                                    week4.setBounds(25, 200, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(25, 240, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(25, 270, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(25, 300, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(25, 330, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(125, 240, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(125, 270, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(125, 300, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(125, 330, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(225, 240, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(225, 270, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(225, 300, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(225, 330, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(325, 240, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(325, 270, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(325, 300, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(325, 330, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week4Input.setText("Snatchpull");
                                    exercise2Week4Input.setText("Snatch");
                                    exercise3Week4Input.setText("Backsquat");

                                    //step 4: Count the weight with the backsquat and snatchgoalweight
                                    //from the values of backSquatFromDb & snatchGoalFromDb
                                    String exercise12 = snatchGoalFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (backsquat)
                                    String backsquat = backSquatFromDb.getText();
                                    int backsquatRM = Integer.parseInt(backsquat);

                                    int resultWeek4 = week4Count * backsquatRM / 100;

                                    weight3Week4Input.setText("" + resultWeek4);
                                }
                                if (resultWeek == 4) {
                                    commentLabel.setText("Well done, you've finshed week: " + resultWeek + ". You're ready with this schedule");
                                    commentLabel.setVisible(true);
                                }
                            } catch (NumberFormatException nfe) {
                                if (weekNumber.equals(""))
                                    weekNumber = "Weeknumber is required";
                                JOptionPane.showMessageDialog(ProgressDialogPanel.this,
                                        "No valid entry: " + weekNumber,
                                        "Error message",
                                        JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    }

                }

                private void doFindProgressSnatch(String email) {
                    currentProgress = manager.findProgressSnatch(email);
                    backSquatFromDb.setText("" + currentProgress.getBackSquat());
                    snatchGoalFromDb.setText("" + currentProgress.getSnatchGoalWeight());

                }

                //----------------------PROGRESS SKILL CLEANANDJERK---------------------------------------------
                //ProgressCleanJerkHandler getting the values of the frontsquat and cleanjerkgoalweight from schedulecleanjerk
                //@return Email and most recent values are shown
                //Weeknumbers show the schedules are the athlete still have to do

                //ProgressCleanJerkHandler
                class ProgressCleanJerkHandler implements ActionListener {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == progressButtonCleanJerk) {
                            String email = emailProgressInput.getText();
                            doFindProgressCleanJerk(email);

                            String weekNumber = progressQuestionInput.getText();
                            try {
                                int resultWeek = Integer.parseInt(weekNumber);

                                if (resultWeek == 0) {
                                    //Step 1: show schedules 1, 2, 3 and 4
                                    commentLabel.setText("You're starting this schedule. Good luck");
                                    commentLabel.setVisible(true);
                                    week1.setVisible(true);
                                    week1.setBounds(25, 200, 200, 30);
                                    exerciseWeek1Label.setVisible(true);
                                    exerciseWeek1Label.setBounds(25, 240, 100, 30);
                                    exercise1Week1Input.setVisible(true);
                                    exercise1Week1Input.setBounds(25, 270, 100, 30);
                                    exercise2Week1Input.setVisible(true);
                                    exercise2Week1Input.setBounds(25, 300, 100, 30);
                                    exercise3Week1Input.setVisible(true);
                                    exercise3Week1Input.setBounds(25, 330, 100, 30);
                                    roundsWeek1Label.setVisible(true);
                                    roundsWeek1Label.setBounds(125, 240, 100, 30);
                                    rounds1Week1Input.setVisible(true);
                                    rounds1Week1Input.setBounds(125, 270, 100, 30);
                                    rounds2Week1Input.setVisible(true);
                                    rounds2Week1Input.setBounds(125, 300, 100, 30);
                                    rounds3Week1Input.setVisible(true);
                                    rounds3Week1Input.setBounds(125, 330, 100, 30);
                                    repsWeek1Label.setVisible(true);
                                    repsWeek1Label.setBounds(225, 240, 100, 30);
                                    reps1Week1Input.setVisible(true);
                                    reps1Week1Input.setBounds(225, 270, 100, 30);
                                    reps2Week1Input.setVisible(true);
                                    reps2Week1Input.setBounds(225, 300, 100, 30);
                                    reps3Week1Input.setVisible(true);
                                    reps3Week1Input.setBounds(225, 330, 100, 30);
                                    weightWeek1Label.setVisible(true);
                                    weightWeek1Label.setBounds(325, 240, 100, 30);
                                    weight1Week1Input.setVisible(true);
                                    weight1Week1Input.setBounds(325, 270, 100, 30);
                                    weight2Week1Input.setVisible(true);
                                    weight2Week1Input.setBounds(325, 300, 100, 30);
                                    weight3Week1Input.setVisible(true);
                                    weight3Week1Input.setBounds(325, 330, 100, 30);
                                    week2.setVisible(true);
                                    week2.setBounds(475, 200, 100, 30);
                                    exerciseWeek2Label.setVisible(true);
                                    exerciseWeek2Label.setBounds(475, 240, 100, 30);
                                    exercise1Week2Input.setVisible(true);
                                    exercise1Week2Input.setBounds(475, 270, 100, 30);
                                    exercise2Week2Input.setVisible(true);
                                    exercise2Week2Input.setBounds(475, 300, 100, 30);
                                    exercise3Week2Input.setVisible(true);
                                    exercise3Week2Input.setBounds(475, 330, 100, 30);
                                    roundsWeek2Label.setVisible(true);
                                    roundsWeek2Label.setBounds(575, 240, 100, 30);
                                    rounds1Week2Input.setVisible(true);
                                    rounds1Week2Input.setBounds(575, 270, 100, 30);
                                    rounds2Week2Input.setVisible(true);
                                    rounds2Week2Input.setBounds(575, 300, 100, 30);
                                    rounds3Week2Input.setVisible(true);
                                    rounds3Week2Input.setBounds(575, 330, 100, 30);
                                    repsWeek2Label.setVisible(true);
                                    repsWeek2Label.setBounds(675, 240, 100, 30);
                                    reps1Week2Input.setVisible(true);
                                    reps1Week2Input.setBounds(675, 270, 100, 30);
                                    reps2Week2Input.setVisible(true);
                                    reps2Week2Input.setBounds(675, 300, 100, 30);
                                    reps3Week2Input.setVisible(true);
                                    reps3Week2Input.setBounds(675, 330, 100, 30);
                                    weightWeek2Label.setVisible(true);
                                    weightWeek2Label.setBounds(775, 240, 100, 30);
                                    weight1Week2Input.setVisible(true);
                                    weight1Week2Input.setBounds(775, 270, 100, 30);
                                    weight2Week2Input.setVisible(true);
                                    weight2Week2Input.setBounds(775, 300, 100, 30);
                                    weight3Week2Input.setVisible(true);
                                    weight3Week2Input.setBounds(775, 330, 100, 30);
                                    week3.setVisible(true);
                                    week3.setBounds(25, 370, 100, 30);
                                    exerciseWeek3Label.setVisible(true);
                                    exerciseWeek3Label.setBounds(25, 400, 100, 30);
                                    exercise1Week3Input.setVisible(true);
                                    exercise1Week3Input.setBounds(25, 430, 100, 30);
                                    exercise2Week3Input.setVisible(true);
                                    exercise2Week3Input.setBounds(25, 460, 100, 30);
                                    exercise3Week3Input.setVisible(true);
                                    exercise3Week3Input.setBounds(25, 490, 100, 30);
                                    roundsWeek3Label.setVisible(true);
                                    roundsWeek3Label.setBounds(125, 400, 100, 30);
                                    rounds1Week3Input.setVisible(true);
                                    rounds1Week3Input.setBounds(125, 430, 100, 30);
                                    rounds2Week3Input.setVisible(true);
                                    rounds2Week3Input.setBounds(125, 460, 100, 30);
                                    rounds3Week3Input.setVisible(true);
                                    rounds3Week3Input.setBounds(125, 490, 100, 30);
                                    repsWeek3Label.setVisible(true);
                                    repsWeek3Label.setBounds(225, 400, 100, 30);
                                    reps1Week3Input.setVisible(true);
                                    reps1Week3Input.setBounds(225, 430, 100, 30);
                                    reps2Week3Input.setVisible(true);
                                    reps2Week3Input.setBounds(225, 460, 100, 30);
                                    reps3Week3Input.setVisible(true);
                                    reps3Week3Input.setBounds(225, 490, 100, 30);
                                    weightWeek3Label.setVisible(true);
                                    weightWeek3Label.setBounds(325, 400, 100, 30);
                                    weight1Week3Input.setVisible(true);
                                    weight1Week3Input.setBounds(325, 430, 100, 30);
                                    weight2Week3Input.setVisible(true);
                                    weight2Week3Input.setBounds(325, 460, 100, 30);
                                    weight3Week3Input.setVisible(true);
                                    weight3Week3Input.setBounds(325, 490, 100, 30);
                                    week4.setVisible(true);
                                    week4.setBounds(475, 370, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(475, 400, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(475, 430, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(475, 460, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(475, 490, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(575, 400, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(575, 430, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(575, 460, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(575, 490, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(675, 400, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(675, 430, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(675, 460, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(675, 490, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(775, 400, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(775, 430, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(775, 460, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(775, 490, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week1Input.setText("" + reps);
                                    rounds1Week1Input.setText("" + rounds);
                                    reps2Week1Input.setText("" + reps);
                                    rounds2Week1Input.setText("" + rounds);
                                    reps3Week1Input.setText("" + reps);
                                    rounds3Week1Input.setText("" + rounds);
                                    reps1Week2Input.setText("" + reps);
                                    rounds1Week2Input.setText("" + rounds);
                                    reps2Week2Input.setText("" + reps);
                                    rounds2Week2Input.setText("" + rounds);
                                    reps3Week2Input.setText("" + reps);
                                    rounds3Week2Input.setText("" + rounds);
                                    reps1Week3Input.setText("" + reps);
                                    rounds1Week3Input.setText("" + rounds);
                                    reps2Week3Input.setText("" + reps);
                                    rounds2Week3Input.setText("" + rounds);
                                    reps3Week3Input.setText("" + reps);
                                    rounds3Week3Input.setText("" + rounds);
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week1Input.setText("Cleanpull");
                                    exercise2Week1Input.setText("Clean and Jerk");
                                    exercise3Week1Input.setText("Frontsquat");
                                    exercise1Week2Input.setText("Cleanpull");
                                    exercise2Week2Input.setText("Clean and Jerk");
                                    exercise3Week2Input.setText("Frontsquat");
                                    exercise1Week3Input.setText("Cleanpull");
                                    exercise2Week3Input.setText("Clean and Jerk");
                                    exercise3Week3Input.setText("Frontsquat");
                                    exercise1Week4Input.setText("Cleanpull");
                                    exercise2Week4Input.setText("Clean and Jerk");
                                    exercise3Week4Input.setText("Frontsquat");

                                    //step 4: Count the weight with the frontsquat and cleanjerkgoalweight
                                    //from the values of frontSquatFromDb & cleanJerkFromDb
                                    String exercise12 = cleanJerkFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek1Weigt12 = week1Count * exercise12Weight / 100;
                                    int resultWeek2Weight12 = week2Count * exercise12Weight / 100;
                                    int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week1Input.setText("" + resultWeek1Weigt12);
                                    weight2Week1Input.setText("" + resultWeek1Weigt12);
                                    weight1Week2Input.setText("" + resultWeek2Weight12);
                                    weight2Week2Input.setText("" + resultWeek2Weight12);
                                    weight1Week3Input.setText("" + resultWeek3Weight12);
                                    weight2Week3Input.setText("" + resultWeek3Weight12);
                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (frontsquat)
                                    String frontsquat = frontSquatFromDb.getText();
                                    int frontsquatRM = Integer.parseInt(frontsquat);

                                    int resultWeek1 = week1Count * frontsquatRM / 100;
                                    int resultWeek2 = week2Count * frontsquatRM / 100;
                                    int resultWeek3 = week3Count * frontsquatRM / 100;
                                    int resultWeek4 = week4Count * frontsquatRM / 100;

                                    weight3Week1Input.setText("" + resultWeek1);
                                    weight3Week2Input.setText("" + resultWeek2);
                                    weight3Week3Input.setText("" + resultWeek3);
                                    weight3Week4Input.setText("" + resultWeek4);


                                }

                                if (resultWeek == 1) {
                                    //Step 1: Show schedule 2, 3, and 4
                                    commentLabel.setText("You did week: " + resultWeek + ". Good luck with week 2, 3 and 4");
                                    commentLabel.setVisible(true);
                                    week2.setVisible(true);
                                    week2.setBounds(25, 200, 100, 30);
                                    exerciseWeek2Label.setVisible(true);
                                    exerciseWeek2Label.setBounds(25, 240, 100, 30);
                                    exercise1Week2Input.setVisible(true);
                                    exercise1Week2Input.setBounds(25, 270, 100, 30);
                                    exercise2Week2Input.setVisible(true);
                                    exercise2Week2Input.setBounds(25, 300, 100, 30);
                                    exercise3Week2Input.setVisible(true);
                                    exercise3Week2Input.setBounds(25, 330, 100, 30);
                                    roundsWeek2Label.setVisible(true);
                                    roundsWeek2Label.setBounds(125, 240, 100, 30);
                                    rounds1Week2Input.setVisible(true);
                                    rounds1Week2Input.setBounds(125, 270, 100, 30);
                                    rounds2Week2Input.setVisible(true);
                                    rounds2Week2Input.setBounds(125, 300, 100, 30);
                                    rounds3Week2Input.setVisible(true);
                                    rounds3Week2Input.setBounds(125, 330, 100, 30);
                                    repsWeek2Label.setVisible(true);
                                    repsWeek2Label.setBounds(225, 240, 100, 30);
                                    reps1Week2Input.setVisible(true);
                                    reps1Week2Input.setBounds(225, 270, 100, 30);
                                    reps2Week2Input.setVisible(true);
                                    reps2Week2Input.setBounds(225, 300, 100, 30);
                                    reps3Week2Input.setVisible(true);
                                    reps3Week2Input.setBounds(225, 330, 100, 30);
                                    weightWeek2Label.setVisible(true);
                                    weightWeek2Label.setBounds(325, 240, 100, 30);
                                    weight1Week2Input.setVisible(true);
                                    weight1Week2Input.setBounds(325, 270, 100, 30);
                                    weight2Week2Input.setVisible(true);
                                    weight2Week2Input.setBounds(325, 300, 100, 30);
                                    weight3Week2Input.setVisible(true);
                                    weight3Week2Input.setBounds(325, 330, 100, 30);
                                    week3.setVisible(true);
                                    week3.setBounds(475, 200, 100, 30);
                                    exerciseWeek3Label.setVisible(true);
                                    exerciseWeek3Label.setBounds(475, 240, 100, 30);
                                    exercise1Week3Input.setVisible(true);
                                    exercise1Week3Input.setBounds(475, 270, 100, 30);
                                    exercise2Week3Input.setVisible(true);
                                    exercise2Week3Input.setBounds(475, 300, 100, 30);
                                    exercise3Week3Input.setVisible(true);
                                    exercise3Week3Input.setBounds(475, 330, 100, 30);
                                    roundsWeek3Label.setVisible(true);
                                    roundsWeek3Label.setBounds(575, 240, 100, 30);
                                    rounds1Week3Input.setVisible(true);
                                    rounds1Week3Input.setBounds(575, 270, 100, 30);
                                    rounds2Week3Input.setVisible(true);
                                    rounds2Week3Input.setBounds(575, 300, 100, 30);
                                    rounds3Week3Input.setVisible(true);
                                    rounds3Week3Input.setBounds(575, 330, 100, 30);
                                    repsWeek3Label.setVisible(true);
                                    repsWeek3Label.setBounds(675, 240, 100, 30);
                                    reps1Week3Input.setVisible(true);
                                    reps1Week3Input.setBounds(675, 270, 100, 30);
                                    reps2Week3Input.setVisible(true);
                                    reps2Week3Input.setBounds(675, 300, 100, 30);
                                    reps3Week3Input.setVisible(true);
                                    reps3Week3Input.setBounds(675, 330, 100, 30);
                                    weightWeek3Label.setVisible(true);
                                    weightWeek3Label.setBounds(775, 240, 100, 30);
                                    weight1Week3Input.setVisible(true);
                                    weight1Week3Input.setBounds(775, 270, 100, 30);
                                    weight2Week3Input.setVisible(true);
                                    weight2Week3Input.setBounds(775, 300, 100, 30);
                                    weight3Week3Input.setVisible(true);
                                    weight3Week3Input.setBounds(775, 330, 100, 30);
                                    week4.setVisible(true);
                                    week4.setBounds(25, 370, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(25, 400, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(25, 430, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(25, 460, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(25, 490, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(125, 400, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(125, 430, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(125, 460, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(125, 490, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(225, 400, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(225, 430, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(225, 460, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(225, 490, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(325, 400, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(325, 430, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(325, 460, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(325, 490, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week2Input.setText("" + reps);
                                    rounds1Week2Input.setText("" + rounds);
                                    reps2Week2Input.setText("" + reps);
                                    rounds2Week2Input.setText("" + rounds);
                                    reps3Week2Input.setText("" + reps);
                                    rounds3Week2Input.setText("" + rounds);
                                    reps1Week3Input.setText("" + reps);
                                    rounds1Week3Input.setText("" + rounds);
                                    reps2Week3Input.setText("" + reps);
                                    rounds2Week3Input.setText("" + rounds);
                                    reps3Week3Input.setText("" + reps);
                                    rounds3Week3Input.setText("" + rounds);
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week2Input.setText("Cleanpull");
                                    exercise2Week2Input.setText("Clean and Jerk");
                                    exercise3Week2Input.setText("Frontsquat");
                                    exercise1Week3Input.setText("Cleanpull");
                                    exercise2Week3Input.setText("Clean and Jerk");
                                    exercise3Week3Input.setText("Frontsquat");
                                    exercise1Week4Input.setText("Cleanpull");
                                    exercise2Week4Input.setText("Clean and Jerk");
                                    exercise3Week4Input.setText("Frontsquat");

                                    //step 4: Count the weight with the frontsquat and cleanjerkgoalweight
                                    //from the values of frontSquatFromDb & cleanJerkFromDb
                                    String exercise12 = cleanJerkFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek2Weight12 = week2Count * exercise12Weight / 100;
                                    int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week2Input.setText("" + resultWeek2Weight12);
                                    weight2Week2Input.setText("" + resultWeek2Weight12);
                                    weight1Week3Input.setText("" + resultWeek3Weight12);
                                    weight2Week3Input.setText("" + resultWeek3Weight12);
                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (frontsquat)
                                    String frontsquat = frontSquatFromDb.getText();
                                    int frontsquatRM = Integer.parseInt(frontsquat);

                                    int resultWeek2 = week2Count * frontsquatRM / 100;
                                    int resultWeek3 = week3Count * frontsquatRM / 100;
                                    int resultWeek4 = week4Count * frontsquatRM / 100;

                                    weight3Week2Input.setText("" + resultWeek2);
                                    weight3Week3Input.setText("" + resultWeek3);
                                    weight3Week4Input.setText("" + resultWeek4);


                                }

                                if (resultWeek == 2) {
                                    //Step 1: Show schedule 3 and 4
                                    commentLabel.setText("You did week: " + resultWeek + ". Great work, good luck with week 3 and 4");
                                    commentLabel.setVisible(true);
                                    week3.setVisible(true);
                                    week3.setBounds(25, 200, 100, 30);
                                    exerciseWeek3Label.setVisible(true);
                                    exerciseWeek3Label.setBounds(25, 240, 100, 30);
                                    exercise1Week3Input.setVisible(true);
                                    exercise1Week3Input.setBounds(25, 270, 100, 30);
                                    exercise2Week3Input.setVisible(true);
                                    exercise2Week3Input.setBounds(25, 300, 100, 30);
                                    exercise3Week3Input.setVisible(true);
                                    exercise3Week3Input.setBounds(25, 330, 100, 30);
                                    roundsWeek3Label.setVisible(true);
                                    roundsWeek3Label.setBounds(125, 240, 100, 30);
                                    rounds1Week3Input.setVisible(true);
                                    rounds1Week3Input.setBounds(125, 270, 100, 30);
                                    rounds2Week3Input.setVisible(true);
                                    rounds2Week3Input.setBounds(125, 300, 100, 30);
                                    rounds3Week3Input.setVisible(true);
                                    rounds3Week3Input.setBounds(125, 330, 100, 30);
                                    repsWeek3Label.setVisible(true);
                                    repsWeek3Label.setBounds(225, 240, 100, 30);
                                    reps1Week3Input.setVisible(true);
                                    reps1Week3Input.setBounds(225, 270, 100, 30);
                                    reps2Week3Input.setVisible(true);
                                    reps2Week3Input.setBounds(225, 300, 100, 30);
                                    reps3Week3Input.setVisible(true);
                                    reps3Week3Input.setBounds(225, 330, 100, 30);
                                    weightWeek3Label.setVisible(true);
                                    weightWeek3Label.setBounds(325, 240, 100, 30);
                                    weight1Week3Input.setVisible(true);
                                    weight1Week3Input.setBounds(325, 270, 100, 30);
                                    weight2Week3Input.setVisible(true);
                                    weight2Week3Input.setBounds(325, 300, 100, 30);
                                    weight3Week3Input.setVisible(true);
                                    weight3Week3Input.setBounds(325, 330, 100, 30);
                                    week4.setVisible(true);
                                    week4.setBounds(475, 200, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(475, 240, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(475, 270, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(475, 300, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(475, 330, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(575, 240, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(575, 270, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(575, 300, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(575, 330, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(675, 240, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(675, 270, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(675, 300, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(675, 330, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(775, 240, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(775, 270, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(775, 300, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(775, 330, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week3Input.setText("" + reps);
                                    rounds1Week3Input.setText("" + rounds);
                                    reps2Week3Input.setText("" + reps);
                                    rounds2Week3Input.setText("" + rounds);
                                    reps3Week3Input.setText("" + reps);
                                    rounds3Week3Input.setText("" + rounds);
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week3Input.setText("Cleanpull");
                                    exercise2Week3Input.setText("Clean and Jerk");
                                    exercise3Week3Input.setText("Frontsquat");
                                    exercise1Week4Input.setText("Cleanpull");
                                    exercise2Week4Input.setText("Clean and Jerk");
                                    exercise3Week4Input.setText("Frontsquat");

                                    //step 4: Count the weight with the Frontsquat and cleanjerkgoalweight
                                    //from the values of frontSquatFromDb & cleanJerkFromDb
                                    String exercise12 = cleanJerkFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek3Weight12 = week3Count * exercise12Weight / 100;
                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week3Input.setText("" + resultWeek3Weight12);
                                    weight2Week3Input.setText("" + resultWeek3Weight12);
                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (frontsquat)
                                    String frontsquat = frontSquatFromDb.getText();
                                    int frontsquatRM = Integer.parseInt(frontsquat);

                                    int resultWeek3 = week3Count * frontsquatRM / 100;
                                    int resultWeek4 = week4Count * frontsquatRM / 100;

                                    weight3Week3Input.setText("" + resultWeek3);
                                    weight3Week4Input.setText("" + resultWeek4);
                                }
                                if (resultWeek == 3) {
                                    //Step 1: Show schedule 4
                                    commentLabel.setText("You did week: " + resultWeek + ". Great work, good luck with week 4");
                                    commentLabel.setVisible(true);
                                    week4.setVisible(true);
                                    week4.setBounds(25, 200, 100, 30);
                                    exerciseWeek4Label.setVisible(true);
                                    exerciseWeek4Label.setBounds(25, 240, 100, 30);
                                    exercise1Week4Input.setVisible(true);
                                    exercise1Week4Input.setBounds(25, 270, 100, 30);
                                    exercise2Week4Input.setVisible(true);
                                    exercise2Week4Input.setBounds(25, 300, 100, 30);
                                    exercise3Week4Input.setVisible(true);
                                    exercise3Week4Input.setBounds(25, 330, 100, 30);
                                    roundsWeek4Label.setVisible(true);
                                    roundsWeek4Label.setBounds(125, 240, 100, 30);
                                    rounds1Week4Input.setVisible(true);
                                    rounds1Week4Input.setBounds(125, 270, 100, 30);
                                    rounds2Week4Input.setVisible(true);
                                    rounds2Week4Input.setBounds(125, 300, 100, 30);
                                    rounds3Week4Input.setVisible(true);
                                    rounds3Week4Input.setBounds(125, 330, 100, 30);
                                    repsWeek4Label.setVisible(true);
                                    repsWeek4Label.setBounds(225, 240, 100, 30);
                                    reps1Week4Input.setVisible(true);
                                    reps1Week4Input.setBounds(225, 270, 100, 30);
                                    reps2Week4Input.setVisible(true);
                                    reps2Week4Input.setBounds(225, 300, 100, 30);
                                    reps3Week4Input.setVisible(true);
                                    reps3Week4Input.setBounds(225, 330, 100, 30);
                                    weightWeek4Label.setVisible(true);
                                    weightWeek4Label.setBounds(325, 240, 100, 30);
                                    weight1Week4Input.setVisible(true);
                                    weight1Week4Input.setBounds(325, 270, 100, 30);
                                    weight2Week4Input.setVisible(true);
                                    weight2Week4Input.setBounds(325, 300, 100, 30);
                                    weight3Week4Input.setVisible(true);
                                    weight3Week4Input.setBounds(325, 330, 100, 30);

                                    //Step 2: Fill the textfields reps and rounds.
                                    //The reps and rounds are fixed values
                                    reps1Week4Input.setText("" + reps4);
                                    rounds1Week4Input.setText("" + rounds);
                                    reps2Week4Input.setText("" + reps4);
                                    rounds2Week4Input.setText("" + rounds);
                                    reps3Week4Input.setText("" + reps4);
                                    rounds3Week4Input.setText("" + rounds);

                                    //Step 3: Fill the textfields Exercise
                                    exercise1Week4Input.setText("Cleanpull");
                                    exercise2Week4Input.setText("Clean and Jerk");
                                    exercise3Week4Input.setText("Frontsquat");

                                    //step 4: Count the weight with the frontsquat and cleanjerkgoalweight
                                    //from the values of frontSquatFromDb & cleanJerkFromDb
                                    String exercise12 = cleanJerkFromDb.getText();
                                    int exercise12Weight = Integer.parseInt(exercise12);

                                    int resultWeek4Weight12 = week4Count * exercise12Weight / 100;

                                    weight1Week4Input.setText("" + resultWeek4Weight12);
                                    weight2Week4Input.setText("" + resultWeek4Weight12);

                                    //Count for weight 3 (frontsquat)
                                    String frontsquat = frontSquatFromDb.getText();
                                    int frontsquatRM = Integer.parseInt(frontsquat);

                                    int resultWeek4 = week4Count * frontsquatRM / 100;

                                    weight3Week4Input.setText("" + resultWeek4);
                                }
                                if (resultWeek == 4) {
                                    commentLabel.setText("Well done, you've finshed week: " + resultWeek + ". You're ready with this schedule");
                                    commentLabel.setVisible(true);
                                }
                            } catch (NumberFormatException nfe) {
                                if (weekNumber.equals(""))
                                    weekNumber = "Weeknumber is required";
                                JOptionPane.showMessageDialog(ProgressDialogPanel.this,
                                        "No valid entry: " + weekNumber,
                                        "Error message",
                                        JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    }

                }

                private void doFindProgressCleanJerk(String email) {
                    currentProgressCJ = manager.findProgressCleanJerk(email);
                    frontSquatFromDb.setText("" + currentProgressCJ.getFrontSquat());
                    cleanJerkFromDb.setText("" + currentProgressCJ.getCleanJerkGoalWeight());

                }




                            }

            /**
             * -------------------------------ATLETE----------------------------------------------
             * Athlete menu shows you known athletes
             * Create new athletes with an INSERT query
             */

            public class AtleteDialog extends JDialog {
                //Open Atlete dialog
                public AtleteDialog() {
                    setTitle("Athlete");
                    setSize(900, 750);
                    setLocationRelativeTo(null);
                    setContentPane(new AtleteDialogPanel(new WeightLiftManager()));
                    setModal(true);
                }
            }

            public class AtleteDialogPanel extends JPanel {
                //Open atlete panel
                private JLabel atleteEmailLabel, firstNameLabel, lastNameLabel, atleteLabel, atleteScheduleIDLabel, newAtleteLabel, newAtleteEmailLabel, newAtleteFirtsNameLabel, newAtleteLastNameLabel;
                private JTextField atleteEmailInput, firstNameInput, lastNameInput, atleteScheduleIDInput, newEmailInput, newFisrtNameInput, newLastNameInput, newAtleteCommentInput;
                private JButton emailSearchButton, createButton;
                private final WeightLiftManager manager;
                private Atlete currentAtlete;

                public AtleteDialogPanel(WeightLiftManager weightLiftManager) {
                    setLayout(null);
                    atleteLabel = new JLabel("Athlete");
                    newAtleteLabel = new JLabel("New Athlete");
                    atleteEmailLabel = new JLabel("Emailadres: ");
                    atleteEmailInput = new JTextField(30);
                    firstNameLabel = new JLabel("Fisrtname: ");
                    firstNameInput = new JTextField(30);
                    lastNameLabel = new JLabel("Lastname: ");
                    lastNameInput = new JTextField(30);
                    atleteScheduleIDLabel = new JLabel("Schedule nr: ");
                    atleteScheduleIDInput = new JTextField(30);
                    newAtleteEmailLabel = new JLabel("Emailadres: ");
                    newEmailInput = new JTextField(30);
                    newAtleteFirtsNameLabel = new JLabel("Fisrtname: ");
                    newFisrtNameInput = new JTextField(30);
                    newAtleteLastNameLabel = new JLabel("Lastname: ");
                    newLastNameInput = new JTextField(30);
                    newAtleteCommentInput = new JTextField(60);
                    newAtleteCommentInput.setBackground(null);
                    newAtleteCommentInput.setBorder(null);
                    emailSearchButton = new JButton("Search");
                    emailSearchButton.addActionListener(new EmailSearchHandler());
                    createButton = new JButton("Create");
                    createButton.addActionListener(new CreateAtleteHandler());
                    manager = weightLiftManager;
                    currentAtlete = null;

                    //Layout athlete known
                    atleteLabel.setBounds(220, 20, 100, 50);
                    atleteEmailLabel.setBounds(20, 100, 100, 50);
                    atleteEmailInput.setBounds(100, 100, 200, 50);
                    firstNameLabel.setBounds(20, 170, 100, 50);
                    firstNameInput.setBounds(100, 170, 200, 50);
                    lastNameLabel.setBounds(20, 240, 100, 50);
                    lastNameInput.setBounds(100, 240, 200, 50);
                    atleteScheduleIDLabel.setBounds(20, 310, 100, 50);
                    atleteScheduleIDInput.setBounds(100, 310, 200, 50);
                    emailSearchButton.setBounds(340, 100, 75, 50);

                    //layout athlete new
                    newAtleteLabel.setBounds(670, 20, 100, 50);
                    newAtleteEmailLabel.setBounds(470, 100, 100, 50);
                    newEmailInput.setBounds(550, 100, 200, 50);
                    newAtleteFirtsNameLabel.setBounds(470, 170, 100, 50);
                    newFisrtNameInput.setBounds(550, 170, 200, 50);
                    newAtleteLastNameLabel.setBounds(470, 240, 100, 50);
                    newLastNameInput.setBounds(550, 240, 200, 50);
                    createButton.setBounds(790, 100, 75, 50);
                    newAtleteCommentInput.setBounds(550, 310, 200, 50);

                    add(atleteLabel);
                    add(newAtleteLabel);
                    add(atleteEmailLabel);
                    add(atleteEmailInput);
                    add(firstNameLabel);
                    add(firstNameInput);
                    add(lastNameLabel);
                    add(lastNameInput);
                    add(atleteScheduleIDLabel);
                    add(atleteScheduleIDInput);
                    add(emailSearchButton);
                    add(createButton);
                    add(newAtleteEmailLabel);
                    add(newEmailInput);
                    add(newAtleteFirtsNameLabel);
                    add(newFisrtNameInput);
                    add(newAtleteLastNameLabel);
                    add(newLastNameInput);
                    add(newAtleteCommentInput);

                }

                //HANDLERS OF ATLETEDIALOGPANEL
                //Handler for search athlete
                class EmailSearchHandler implements ActionListener {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == emailSearchButton) {
                            String email = atleteEmailInput.getText();
                            doFindAtlete(email);

                        }
                    }
                }

                private void doFindAtlete(String email) {
                    currentAtlete = manager.findAtlete(email);
                    firstNameInput.setText(currentAtlete.getFirtName());
                    lastNameInput.setText(currentAtlete.getLastName());
                    atleteScheduleIDInput.setText(currentAtlete.getScheduleID());
                    String atleteInfo = "Atleet niet gevonden";
                }

                //Handler for new Athlete
                class CreateAtleteHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == createButton) {
                            String email = newEmailInput.getText();
                            String firstName = newFisrtNameInput.getText();
                            String lastName = newLastNameInput.getText();
                            doCreateAtlete(email, firstName, lastName);
                            newAtleteCommentInput.setText("Athlete is succesfully registered");
                            newAtleteCommentInput.setVisible(true);
                        }
                    }
                }

                private void doCreateAtlete(String email, String firstName, String lastName) {
                    manager.createAtlete(email, firstName, lastName);
                }

            }
        }








