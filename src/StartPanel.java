/**
 * Created by r.ceuleers on 25-9-2016.
 */

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel {
    //Start menu with 3 Buttun-options
    private JLabel welcomeAtlete = new JLabel("Welkom");
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

        startNewGoalButton.addActionListener(new NewFrameHandler());
        progressButton.addActionListener(new NewFrameHandler());
        atleteButton.addActionListener(new NewFrameHandler());

        //Layout with 3 equal buttons
        welcomeAtlete.setBounds( 350, 10, 100, 70 );
        startNewGoalButton.setBounds( 105, 200, 150, 150 );
        progressButton.setBounds( 360, 200, 150, 150 );
        atleteButton.setBounds( 615, 200, 150, 150 );

        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/groupsnatch.jpg");
        img = new JLabel(icon1);
        img.setBounds( 0, 0, 800, 400 );

        add(welcomeAtlete);
        add(startNewGoalButton);
        add(progressButton);
        add(atleteButton);
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
            setSize(800, 400);
            setLocation(300, 200);
            setContentPane(new SkillDialogPanel());
            setModal(true);
        }
    }

    public class SkillDialogPanel extends JPanel {
        private JLabel skillLabel;
        private JButton snatchButton, cleanJerkButton;

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

            add(skillLabel);
            add(snatchButton);
            add(cleanJerkButton);
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
                    setSize(800, 400);
                    setLocation(300, 200);
                    setContentPane(new SnatchDialogPanel());
                    setModal(true);
                }
            }

            public class SnatchDialogPanel extends JPanel {
                private JLabel emailLabel, snatchGoalLabel, snatchDateLabel;
                private JButton emailSearchButton, snatchScheduleButton;
                private JTextField emailInput, snatchGoalInput, snatchDateInput;

                public SnatchDialogPanel() {
                    setLayout( null );
                    emailLabel = new JLabel("Email adress: ");
                    //When email is found show Atlete menu and fill in snatch goal weight and date
                    //Then Press Button Make Snatch Schedule and the new schedule opens
                    snatchGoalLabel = new JLabel("Snatch goal weight (kg): ");
                    snatchDateLabel = new JLabel("Date goal weight (yyyy-mm-dd): ");
                    emailInput = new JTextField(30);
                    snatchGoalInput = new JTextField(10);
                    snatchDateInput = new JTextField(10);
                    emailSearchButton = new JButton( "Search" );
                    emailSearchButton.addActionListener( new EmailSearchHandler() );
                    snatchScheduleButton = new JButton( "Make Snatch Schedule" );

                    emailLabel.setBounds( 50, 50, 300, 70 );
                    emailInput.setBounds( 250, 50, 300, 70 );
                    emailSearchButton.setBounds( 600, 50, 100, 70 );
                    snatchGoalLabel.setBounds( 50, 120, 300, 70 );
                    snatchGoalInput.setBounds( 250, 120, 300, 70 );
                    snatchDateLabel.setBounds( 50, 190, 300, 70 );
                    snatchDateInput.setBounds( 250, 190, 300, 70 );
                    snatchScheduleButton.setBounds( 600, 190, 100, 70 );

                    add(emailLabel);
                    add(emailInput);
                    add(emailSearchButton);
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
                            //Open snatch menu Dialog
                            Dialog atleteDialog = new AtleteDialog();
                            atleteDialog.setVisible(true);
                        }
                    }

                }

                public class AtleteDialog extends JDialog {
                    public AtleteDialog() {
                        setTitle("Atlete");
                        setSize(800, 400);
                        setLocation(300, 200);
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
                setSize(800, 400);
                setLocation(300, 200);
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
                setSize(800, 400);
                setLocation(300, 200);
                setContentPane(new AtleteDialogPanel());
                setModal(true);
            }
        }

        public class AtleteDialogPanel extends JPanel {
            private JLabel atleteEmailLabel;
            private JTextField atleteEmailInput;
            private JButton emailSearchButton;

            public AtleteDialogPanel() {
                setLayout( null);
                atleteEmailLabel = new JLabel("Emailadres: ");
                atleteEmailInput = new JTextField( 30 );
                emailSearchButton = new JButton( "Search" );
                emailSearchButton.addActionListener( new Email);

                atleteEmailLabel.setBounds( 50, 50, 300, 70 );
                atleteEmailInput.setBounds( 250, 50, 300, 70 );
                emailSearchButton.setBounds( 600, 50, 100, 70 );

                add(atleteEmailLabel);
                add(atleteEmailInput);
                add(emailSearchButton);

            }
        }
    }

