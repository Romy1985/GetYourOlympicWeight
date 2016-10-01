/**
 * Created by r.ceuleers on 25-9-2016.
 */

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel {
    //Start menu with 3 Buttun-options
    private JLabel welcomeAtlete = new JLabel("Welcome");
    private JButton startNewGoalButton = new JButton("Start new goal");
    private JButton progressButton = new JButton("Progress");
    private JButton atleteButton = new JButton("Atlete");
    private JPanel panel = new JPanel();
    private JLabel img ;


    public StartPanel() {
        setLayout( null );
        setSize(900, 750);
        setLocation(300, 5);

        welcomeAtlete.setHorizontalTextPosition(JLabel.CENTER);
        welcomeAtlete.setForeground(Color.WHITE);
        welcomeAtlete.setFont(new Font("Arial", Font.BOLD, 16));

        //label.setFont(new Font("Serif", Font.PLAIN, 14));

        startNewGoalButton.addActionListener(new NewFrameHandler());
        progressButton.addActionListener(new NewFrameHandler());
        atleteButton.addActionListener(new NewFrameHandler());

        //Layout with 3 equal buttons
        welcomeAtlete.setBounds( 420, 10, 100, 70 );
        startNewGoalButton.setBounds( 615, 200, 150, 150 );
        progressButton.setBounds( 360, 200, 150, 150 );
        atleteButton.setBounds( 105, 200, 150, 150 );

        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/groupsnatch.jpg");
        img = new JLabel(icon1);
        img.setBounds( 0, 0, 900, 750 );

        add(welcomeAtlete);
        add(atleteButton);
        add(startNewGoalButton);
        add(progressButton);
        panel.add(img);
        panel.repaint();

    }

    class NewFrameHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startNewGoalButton) {
                //Open new Skill Dialog
                Dialog skillDialog = new SkillDialog();
                skillDialog.setVisible(true);
            } else if (e.getSource() == progressButton) {
                //Open new Progress Dialog
                Dialog progressDialog = new ProgressDialog();
                progressDialog.setVisible(true);
            } else if (e.getSource() == atleteButton) {
                //Open new Atlete Dialog
                Dialog atleteDialog = new AtleteDialog();
                atleteDialog.setVisible(true);
            }

        }

    }

    public class SkillDialog extends JDialog {
        public SkillDialog() {
            setTitle("Skill menu");
            setSize(900, 750);
            setLocation(300, 5);
            setContentPane(new SkillDialogPanel());
            setModal(true);
        }
    }

    public class SkillDialogPanel extends JPanel {
        private JPanel panelSkill = new JPanel();
        private JLabel skillLabel;
        private JButton snatchButton, cleanJerkButton;
        JLabel img2;

        public SkillDialogPanel() {
            setLayout( null );
            skillLabel = new JLabel("Choose your skill");

            snatchButton = new JButton("Snatch");
            snatchButton.addActionListener(new SkillHandler());

            cleanJerkButton = new JButton("Clean & Jerk");
            cleanJerkButton.addActionListener(new SkillHandler());

            //layout 2 equal buttons
            skillLabel.setBounds( 350, 10, 100, 70 );
            snatchButton.setBounds( 150, 100, 200, 200 );
            cleanJerkButton.setBounds( 450, 100, 200, 200 );

            ImageIcon icon2 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/warmupsnatch.jpg");
            img2 = new JLabel(icon2);
            img2.setBounds( 0, 0, 900, 750 );

            add(skillLabel);
            add(snatchButton);
            add(cleanJerkButton);
            panelSkill.add(img2);
            panelSkill.repaint();
        }

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
                }
            }

            public class SnatchDialog extends JDialog {
                public SnatchDialog() {
                    setTitle("Snatch");
                    setSize(900, 750);
                    setLocation(300, 5);
                    setContentPane(new SnatchDialogPanel());
                    setModal(true);
                }
            }

            public class SnatchDialogPanel extends JPanel {
                private JLabel emailLabel, firstNameLabel, lastNameLabel, backSquatLabel, snatchGoalLabel, snatchDateLabel;
                private JButton emailSearchButton, snatchScheduleButton;
                private JTextField emailInput, firstNameInput, lastNameInput, backSquatInput, snatchGoalInput, snatchDateInput;

                public SnatchDialogPanel() {
                    setLayout( null );
                    emailLabel = new JLabel("Emailadress: ");
                    firstNameLabel = new JLabel("Firstname: ");
                    lastNameLabel = new JLabel("Lastname: ");
                    backSquatLabel = new JLabel("Backsquat (1RM): ");
                    snatchGoalLabel = new JLabel("Snatch goal weight : ");
                    snatchDateLabel = new JLabel("Date goal weight (yyyy-mm-dd): ");
                    emailInput = new JTextField(30);
                    firstNameInput = new JTextField(30);
                    lastNameInput = new JTextField(30);
                    backSquatInput = new JTextField(10);
                    snatchGoalInput = new JTextField(10);
                    snatchDateInput = new JTextField(10);
                    emailSearchButton = new JButton( "Search" );
                    emailSearchButton.addActionListener( new EmailSearchHandler() );
                    snatchScheduleButton = new JButton( "Make Snatch Schedule" );

                    emailLabel.setBounds( 50, 50, 300, 70 );
                    emailInput.setBounds( 250, 50, 300, 70 );
                    emailSearchButton.setBounds( 600, 50, 100, 70 );
                    firstNameLabel.setBounds(50, 120, 300, 70);
                    firstNameInput.setBounds( 250, 120, 300, 70);
                    lastNameLabel.setBounds(50, 190, 300, 70 );
                    lastNameInput.setBounds(250, 190, 300, 70);
                    backSquatLabel.setBounds(50, 260, 300, 70);
                    backSquatInput.setBounds(250, 260, 300, 70);
                    snatchGoalLabel.setBounds( 50, 330, 300, 70 );
                    snatchGoalInput.setBounds( 250, 330, 300, 70 );
                    snatchDateLabel.setBounds( 50, 400, 300, 70 );
                    snatchDateInput.setBounds( 250, 400, 300, 70 );
                    snatchScheduleButton.setBounds( 600, 400, 100, 70 );

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
                }

                class EmailSearchHandler implements ActionListener {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == emailSearchButton) {
                            String email = emailInput.getText();
                            doFindAtlete(email);

                            //Open snatch menu Dialog
                           // Dialog atleteDialog = new AtleteDialog();
                           // atleteDialog.setVisible(true);
                        }
                    }

                }

                private void doFindAtlete(String email) {
                    //currentAtlete = manager.findAtlete(email);
                    String atleteInfo = "Atlete not found";
                }


                public class AtleteDialog extends JDialog {
                    public AtleteDialog() {
                        setTitle("Atlete");
                        setSize(900, 750);
                        setLocation(300, 5);
                        setContentPane(new AtleteDialogPanel() );
                        setModal(true);
                    }
                }

            }
        }
    }

        public class ProgressDialog extends JDialog {
            public ProgressDialog() {
                setTitle("Your Progress");
                setSize(900, 750);
                setLocation(300, 5);
                setContentPane(new ProgressDialogPanel());
                setModal(true);
            }
        }

        public class ProgressDialogPanel extends JPanel {
            private JLabel progressLabel;

            public ProgressDialogPanel() {
                progressLabel = new JLabel("Progress");

                add(progressLabel);
            }
        }

        public class AtleteDialog extends JDialog {
            public AtleteDialog() {
                setTitle("Atlete");
                setSize(900, 750);
                setLocation(300, 5);
                setContentPane(new AtleteDialogPanel());
                setModal(true);
            }
        }

        public class AtleteDialogPanel extends JPanel {
            private JLabel atleteEmailLabel, firstNameLabel, lastNameLabel, atleteLabel, newAtleteLabel;
            private JTextField atleteEmailInput, firstNameInput, lastnameInput;
            private JButton emailSearchButton, createButton;

            public AtleteDialogPanel() {
                setLayout( null);
                atleteLabel = new JLabel("Atlete");
                newAtleteLabel = new JLabel("New Atlete");
                atleteEmailLabel = new JLabel("Emailadres: ");
                atleteEmailInput = new JTextField( 30 );
                firstNameLabel = new JLabel("Fisrtname: ");
                firstNameInput = new JTextField( 30 );
                lastNameLabel = new JLabel("Lastname: ");
                lastnameInput = new JTextField( 30 );
                emailSearchButton = new JButton( "Search" );
                createButton = new JButton("Create");

                atleteLabel.setBounds(220, 20, 50, 50);
                newAtleteLabel.setBounds(670, 20, 50, 50);
                atleteEmailLabel.setBounds(20, 50, 50, 50);
                atleteEmailInput.setBounds(100, 50, 50, 50);
              //  atleteEmailLabel.setBounds(470, 50, 50, 50);
              //  atleteEmailInput.setBounds(550, 50, 50, 50);
                firstNameLabel.setBounds(20, 120, 50, 50);
                firstNameInput.setBounds(100, 120, 50, 50);
              //  firstNameLabel.setBounds(470, 120, 50, 50);
              //  firstNameInput.setBounds(550, 120, 50, 50);
                lastNameLabel.setBounds(20, 190, 50, 50);
                lastnameInput.setBounds(100, 190, 50, 50);
              //  lastNameLabel.setBounds(470, 190, 50, 50);
              //  lastnameInput.setBounds(550, 190, 50, 50);
                emailSearchButton.setBounds(200, 50, 50, 50);
                createButton.setBounds(470, 260, 50, 50);


                /*
                atleteEmailLabel.setBounds( 50, 50, 300, 70 );
                atleteEmailInput.setBounds( 250, 50, 300, 70 );
                firstNameLabel.setBounds( 50, 140, 300, 70 );
                firstNameInput.setBounds( 250, 140, 300, 70 );
                lastNameLabel.setBounds( 50, 230, 300, 70 );
                lastnameInput.setBounds( 250, 230, 300, 70 );
                emailSearchButton.setBounds( 50, 320, 100, 70 );
                createButton.setBounds( 250, 320, 100, 70 ); */

                add(atleteLabel);
                add(newAtleteLabel);
                add(atleteEmailLabel);
                add(atleteEmailInput);
                add(firstNameLabel);
                add(firstNameInput);
                add(lastNameLabel);
                add(lastnameInput);
                add(emailSearchButton);
                add(createButton);

            }
        }
    }

