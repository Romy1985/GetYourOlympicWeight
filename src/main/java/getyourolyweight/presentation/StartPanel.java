package getyourolyweight.presentation; /**
 * Created by r.ceuleers on 25-9-2016.
 */

import getyourolyweight.businesslogic.WeightLiftManager;
import getyourolyweight.domain.Atlete;
import getyourolyweight.domain.Schedule;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel {
    //Start menu with 3 Buttun-options
    private JLabel welcomeAtlete = new JLabel("Welcome");
    private JButton startNewGoalButton = new JButton("Start new goal");
    private JButton progressButton = new JButton("Progress");
    private JButton atleteButton = new JButton("Athlete");
    // Panel for image
    private JPanel panel = new JPanel();
    private JLabel img;


    public StartPanel() {
        setLayout(null);
        setSize(900, 750);

        welcomeAtlete.setHorizontalTextPosition(JLabel.CENTER);
        welcomeAtlete.setFont(new Font("Arial", Font.BOLD, 18));
        startNewGoalButton.setFont(new Font("Arial", Font.BOLD, 14));
        progressButton.setFont(new Font("Arial", Font.BOLD, 14));
        atleteButton.setFont(new Font("Arial", Font.BOLD, 14));


        startNewGoalButton.addActionListener(new NewFrameHandler());
        progressButton.addActionListener(new NewFrameHandler());
        atleteButton.addActionListener(new NewFrameHandler());

        //Layout with 3 equal buttons
        welcomeAtlete.setBounds(420, 10, 100, 70);
        startNewGoalButton.setBounds(615, 200, 150, 150);
        progressButton.setBounds(360, 200, 150, 150);
        atleteButton.setBounds(105, 200, 150, 150);


        //background image (it doesn't work)
        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/groupsnatch.jpg");
        img = new JLabel(icon1);
        img.setBounds(0, 0, 900, 750);
        img.setVisible(true);

        add(welcomeAtlete);
        add(atleteButton);
        add(startNewGoalButton);
        add(progressButton);
        panel.add(img);
        panel.repaint();

    }

    //Button Handlers StartPanel
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
        public SkillDialog() {
            //choose your skill dialog
            setTitle("Skill menu");
            setSize(800, 400);
            setLocationRelativeTo(null);
            setContentPane(new SkillDialogPanel());
            setModal(true);
        }
    }

    public class SkillDialogPanel extends JPanel {
        // choose your skill panel
        private JPanel panelSkill = new JPanel();
        private JLabel skillLabel;
        private JButton snatchButton, cleanJerkButton;

        public SkillDialogPanel() {
            //Skill panel with 2 JButtons
            setLayout(null);
            skillLabel = new JLabel("Choose skill");

            snatchButton = new JButton("Snatch");
            snatchButton.addActionListener(new SkillHandler());

            cleanJerkButton = new JButton("Clean & Jerk");
            cleanJerkButton.addActionListener(new SkillHandler());

            //layout 2 equal buttons
            skillLabel.setBounds(350, 10, 100, 70);
            snatchButton.setBounds(150, 100, 200, 200);
            cleanJerkButton.setBounds(450, 100, 200, 200);

            add(skillLabel);
            add(snatchButton);
            add(cleanJerkButton);

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
                    //Open clean en jerk menu Dialog
                        e.getSource() == cleanJerkButton
                        ) {
                }
            }

            /**
             * Snatch input form
             * Athlete information from database
             * Extra information: Goal weigt, Goal date and 1RM backsquat
             * With the Save button, this information does an INSERT query to the Schedule table
             * Then the save button changes in a Schedule button
             * With the Schedule button, the snatch schedule is getting started
             */

            public class SnatchDialog extends JDialog {
                //Open snatch dialog
                public SnatchDialog() {
                    setTitle("Snatch");
                    setSize(900, 750);
                    setLocationRelativeTo(null);
                    setContentPane(new SnatchDialogPanel(new WeightLiftManager()));
                    setModal(true);
                }
            }

            public class SnatchDialogPanel extends JPanel {
                //Open snatch panel
                private JLabel emailLabel, firstNameLabel, lastNameLabel, backSquatLabel, snatchGoalLabel, snatchDateLabel;
                private JButton emailSearchButton, saveButton, snatchScheduleButton;
                private JTextField emailInput, firstNameInput, lastNameInput, backSquatInput, snatchGoalInput, snatchDateInput;
                private final WeightLiftManager manager;
                private Atlete currentAtlete;
                private Schedule currentSchedule;
                private Schedule currentProgress;

                public SnatchDialogPanel(WeightLiftManager weightLiftManager) {
                    setLayout(null);
                    emailLabel = new JLabel("Emailaddress: ");
                    firstNameLabel = new JLabel("Firstname: ");
                    lastNameLabel = new JLabel("Lastname: ");
                    backSquatLabel = new JLabel("Backsquat (1RM): ");
                    snatchGoalLabel = new JLabel("Snatch goal weight: ");
                    snatchDateLabel = new JLabel("Snatch goal date (yyyy-mm-dd): ");
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
                    currentSchedule = null;
                    currentProgress = null;

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
                     * After using the Save button turns into the Show Schedule button
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == saveButton) {
                            String email = emailInput.getText();
                            doInsertSchedule(email);
                        }
                    }
                }

                private void doInsertSchedule(String email) {
                  //  currentSchedule = manager.insertSchedule(email);
                    saveButton.setVisible(false);
                    snatchScheduleButton.setVisible(true);


                }

                //Schedule Handler for SELECT query on the schedule table
                //The SnatchGoalWeight and backSquat is needed for the math for the schedule
                class ScheduleHandler implements ActionListener {
                    /**
                     * Open schedule menu
                     * Insert the values of snatchgoalweight, backsquat and date into table schedulesnatch
                     * Get the exercises from table exercise
                     * Count the values of backsquat and goalweight
                     * Make a count and fill the textfields of the schedule per week
                     */

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == snatchScheduleButton) {
                            //Open schedule Dialog
                            Dialog scheduleDialog = new ScheduleDialog();
                            scheduleDialog.setVisible(true);
                            //Get exercises
                            //Get values of backsquat and goalweight

                        }


                    }

                }

                public class ScheduleDialog extends JDialog {
                    //Make schedule Dialog
                    public ScheduleDialog() {
                        setTitle("Trainingsschema");
                        setSize(900, 750);
                        setLocationRelativeTo(null);
                        setContentPane(new ScheduleDialogPanel());
                        setModal(true);
                    }
                }

                public class ScheduleDialogPanel extends JPanel {
                    //Make schedule panel
                    private JPanel panelSchedule = new JPanel();
                    private JLabel week1, week2, week3, week4,
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
                    private int reps, rounds, week1Count, week2Count, week3Count, week4Count;

                    public ScheduleDialogPanel() {
                        //fixed values for the reps and rounds
                        reps = 5;
                        rounds = 5;

                        //fixed percentages for the counts per week
                        week1Count = 75;
                        week2Count = 85;
                        week3Count = 95;
                        week4Count = 100;

                        setLayout(null);

                        skillInput = new JTextField(20);
                        skillInput.setBackground(null);
                        skillInput.setBorder(null);
                        skillInput.setText("Snatch schedule");
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
                        exercise1Week1Input = new JTextField(20);
                        exercise2Week1Input = new JTextField(20);
                        exercise3Week1Input = new JTextField(20);
                        roundsWeek1Label = new JLabel("Rounds");
                        rounds1Week1Input = new JTextField(20);
                        rounds2Week1Input = new JTextField(20);
                        rounds3Week1Input = new JTextField(20);
                        repsWeek1Label = new JLabel("Reps");
                        reps1Week1Input = new JTextField(20);
                        reps2Week1Input = new JTextField(20);
                        reps3Week1Input = new JTextField(20);
                        weightWeek1Label = new JLabel("Weight");
                        weight1Week1Input = new JTextField(20);
                        weight2Week1Input = new JTextField(20);
                        weight3Week1Input = new JTextField(20);

                        //labels & textfields week 2
                        exerciseWeek2Label = new JLabel("Exercise");
                        exercise1Week2Input = new JTextField(20);
                        exercise2Week2Input = new JTextField(20);
                        exercise3Week2Input = new JTextField(20);
                        roundsWeek2Label = new JLabel("Rounds");
                        rounds1Week2Input = new JTextField(20);
                        rounds2Week2Input = new JTextField(20);
                        rounds3Week2Input = new JTextField(20);
                        repsWeek2Label = new JLabel("Reps");
                        reps1Week2Input = new JTextField(20);
                        reps2Week2Input = new JTextField(20);
                        reps3Week2Input = new JTextField(20);
                        weightWeek2Label = new JLabel("Weight");
                        weight1Week2Input = new JTextField(20);
                        weight2Week2Input = new JTextField(20);
                        weight3Week2Input = new JTextField(20);

                        //labels & textfields week 3
                        exerciseWeek3Label = new JLabel("Exercise");
                        exercise1Week3Input = new JTextField(20);
                        exercise2Week3Input = new JTextField(20);
                        exercise3Week3Input = new JTextField(20);
                        roundsWeek3Label = new JLabel("Rounds");
                        rounds1Week3Input = new JTextField(20);
                        rounds2Week3Input = new JTextField(20);
                        rounds3Week3Input = new JTextField(20);
                        repsWeek3Label = new JLabel("Reps");
                        reps1Week3Input = new JTextField(20);
                        reps2Week3Input = new JTextField(20);
                        reps3Week3Input = new JTextField(20);
                        weightWeek3Label = new JLabel("Weight");
                        weight1Week3Input = new JTextField(20);
                        weight2Week3Input = new JTextField(20);
                        weight3Week3Input = new JTextField(20);

                        //labels & textfields week 4
                        exerciseWeek4Label = new JLabel("Exercise");
                        exercise1Week4Input = new JTextField(20);
                        exercise2Week4Input = new JTextField(20);
                        exercise3Week4Input = new JTextField(20);
                        roundsWeek4Label = new JLabel("Rounds");
                        rounds1Week4Input = new JTextField(20);
                        rounds2Week4Input = new JTextField(20);
                        rounds3Week4Input = new JTextField(20);
                        repsWeek4Label = new JLabel("Reps");
                        reps1Week4Input = new JTextField(20);
                        reps2Week4Input = new JTextField(20);
                        reps3Week4Input = new JTextField(20);
                        weightWeek4Label = new JLabel("Weight");
                        weight1Week4Input = new JTextField(20);
                        weight2Week4Input = new JTextField(20);
                        weight3Week4Input = new JTextField(20);

                        //layout skill textfield
                        skillInput.setBounds(25, 10, 100, 20 );

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
                        reps1Week4Input.setText("" + reps);
                        rounds1Week4Input.setText("" + rounds);
                        reps2Week4Input.setText("" + reps);
                        rounds2Week4Input.setText("" + rounds);
                        reps3Week4Input.setText("" + reps);
                        rounds3Week4Input.setText("" + rounds);

                        //Step 2:
                        //Get the exercises
                        //Exercises are selected by textfield skillInput,
                        // after choosing the snatch button in the skill menu, the skillInput is "Snatch schedule"
                        // The query now knows witch exercises are for the snatch schedule
                        /*
                        String skill = skillInput.getText();
                        doFindExercise(skill);

                        private void doFindExercise(String skill) {
                        currentSchedule = manager.findExercise(skill);
                        exercise1Week1Input.setText(currentSchedule.getExercise1());
                        exercise2Week1Input.setText(currentSchedule.getExercise2());
                        exercise3Week1Input.setText(currentSchedule.getExercise3());
                        exercise1Week2Input.setText(currentSchedule.getExercise1());
                        exercise2Week2Input.setText(currentSchedule.getExercise2());
                        exercise3Week2Input.setText(currentSchedule.getExercise3());
                        exercise1Week3Input.setText(currentSchedule.getExercise1());
                        exercise2Week3Input.setText(currentSchedule.getExercise2());
                        exercise3Week3Input.setText(currentSchedule.getExercise3());
                        exercise1Week4Input.setText(currentSchedule.getExercise1());
                        exercise2Week4Input.setText(currentSchedule.getExercise2());
                        exercise3Week4Input.setText(currentSchedule.getExercise3());

                        }

                         */

                        //Step 3:
                        //Counts for weight of the exercises

                        //Count for weight 1 and 2 (snatchpulls and snatch)
                        String exercise12 = snatchGoalInput.getText();
                        int exercise12Weight = Integer.parseInt(exercise12);

                        int resultWeek1Weigt12 = week1Count * exercise12Weight/100;
                        int resultWeek2Weight12 = week2Count * exercise12Weight/100;
                        int resultWeek3Weight12 = week3Count * exercise12Weight/100;
                        int resultWeek4Weight12 = week4Count * exercise12Weight/100;

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

                        int resultWeek1 = week1Count * backsquatRM/100;
                        int resultWeek2 = week2Count * backsquatRM/100;
                        int resultWeek3 = week3Count * backsquatRM/100;
                        int resultWeek4 = week4Count * backsquatRM/100;

                        weight3Week1Input.setText("" + resultWeek1);
                        weight3Week2Input.setText("" + resultWeek2);
                        weight3Week3Input.setText("" + resultWeek3);
                        weight3Week4Input.setText("" + resultWeek4);


                        //add labels & textfield to panel
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
     * Progress menu gives schedules when you are in your 4-week-training
     * Email, weeknumber and snatch/cleanjerk-button are needed for the query
     * @return value of SnatchGoalWeight and backSquat or CleanjerkGoalWeight and FrontSquat
     * based on the most recent GoalDate the textfields of the schedule are filled
     */

    public class ProgressDialog extends JDialog {
        public ProgressDialog() {
            setTitle("Your Progress");
            setSize(900, 750);
            setLocationRelativeTo(null);
            setContentPane(new ProgressDialogPanel());
            setModal(true);
        }
    }

    public class ProgressDialogPanel extends JPanel {
        private JLabel emailProgressLabel, progressQuestionLabel;
        private JTextField emailProgressInput, progressQuestionInput;
        private JButton progressButtonSnatch, progressButtonCleanjerk;

        public ProgressDialogPanel() {
            setLayout(null);
            emailProgressLabel = new JLabel("Emailaddress: ");
            emailProgressInput = new JTextField(60);
            progressQuestionLabel = new JLabel("This weeknr I've done (1, 2, 3 or 4): ");
            progressQuestionInput = new JTextField(10);
            progressButtonSnatch = new JButton("Progress Snatch");
            progressButtonSnatch.addActionListener(new ProgressSnatchHandler());
            progressButtonCleanjerk = new JButton("Progress Clean&Jerk");
            // progressButtonCleanJerk.addActionListener(new ProgressCleanjerkHandler());

            //layout Progress input information
            emailProgressLabel.setBounds(20, 50, 200, 30);
            emailProgressInput.setBounds(250, 50, 200, 30);
            progressQuestionLabel.setBounds(20, 100, 200, 30);
            progressQuestionInput.setBounds(250, 100, 200, 30);
            progressButtonSnatch.setBounds(500, 50, 200, 30);
            progressButtonCleanjerk.setBounds(500, 100, 200, 30);

            add(emailProgressLabel);
            add(emailProgressInput);
            add(progressQuestionLabel);
            add(progressQuestionInput);
            add(progressButtonSnatch);
            add(progressButtonCleanjerk);
        }

        //Hier komt ProgressSnatchHandler die van het emailadres en het week nummer de trainingsschema Snatch laat zien wat de atleet nog moet doen

        class ProgressSnatchHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == progressButtonSnatch) {
                    String email = emailProgressInput.getText();
                    String weekNumber = progressQuestionInput.getText();
                    doFindSnatchProgress(email, weekNumber);

                }
            }

        }

        private void doFindSnatchProgress(String email, String weekNumber) {
           // currentProgress = manager.findProgress(email, weekNumber);


        }

        /*
      private void doFindAtlete(String email) {
            currentAtlete = manager.findAtlete(email);
            firstNameInput.setText(currentAtlete.getFirtName());
            lastNameInput.setText(currentAtlete.getLastName());
            atleteScheduleIDInput.setText(currentAtlete.getScheduleID());
            String atleteInfo = "Atleet niet gevonden";
        }
         */

        //Hier komt ProgressCleanjerkHandler die van het emailadres en het week nummer de trainingsschema C&J laat zien wat de atleet nog moet doen
    }

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
        private JTextField atleteEmailInput, firstNameInput, lastNameInput, atleteScheduleIDInput, newEmailInput, newFisrtNameInput, newLastNameInput;
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
            emailSearchButton = new JButton("Search");
            createButton = new JButton("Create");
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
            emailSearchButton.addActionListener(new EmailSearchHandler());


            //layout athlete new
            newAtleteLabel.setBounds(670, 20, 100, 50);
            newAtleteEmailLabel.setBounds(470, 100, 100, 50);
            newEmailInput.setBounds(550, 100, 200, 50);
            newAtleteFirtsNameLabel.setBounds(470, 170, 100, 50);
            newFisrtNameInput.setBounds(550, 170, 200, 50);
            newAtleteLastNameLabel.setBounds(470, 240, 100, 50);
            newLastNameInput.setBounds(550, 240, 200, 50);
            createButton.setBounds(790, 100, 75, 50);


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

        }

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
    }
}



