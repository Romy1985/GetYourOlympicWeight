package getyourolyweight.presentation; /**
 * Created by r.ceuleers on 25-9-2016.
 */

import getyourolyweight.businesslogic.WeightLiftManager;
import getyourolyweight.domain.Atlete;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel {
    //Start menu with 3 Buttun-options
    private JLabel welcomeAtlete = new JLabel("Welkom");
    private JButton startNewGoalButton = new JButton("Start nieuw doel");
    private JButton progressButton = new JButton("Voortgang");
    private JButton atleteButton = new JButton("Atleet");
    private JPanel panel = new JPanel();
    private JLabel img ;


    public StartPanel() {
        setLayout( null );
        setSize(900, 750);
        setLocation(300, 5);

        welcomeAtlete.setHorizontalTextPosition(JLabel.CENTER);
        welcomeAtlete.setForeground(Color.WHITE);
        welcomeAtlete.setFont(new Font("Arial", Font.BOLD, 18));

        startNewGoalButton.setBackground(Color.GRAY);
        startNewGoalButton.setForeground(Color.WHITE);
        startNewGoalButton.setFont(new Font("Arial", Font.BOLD, 14));

        progressButton.setBackground(Color.gray);
        progressButton.setForeground(Color.WHITE);
        progressButton.setFont(new Font("Arial", Font.BOLD, 14));

        atleteButton.setBackground(Color.gray);
        atleteButton.setForeground(Color.WHITE);
        atleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        //label.setFont(new Font("Serif", Font.PLAIN, 14));

        startNewGoalButton.addActionListener(new NewFrameHandler());
        progressButton.addActionListener(new NewFrameHandler());
        atleteButton.addActionListener(new NewFrameHandler());

        //Layout with 3 equal buttons
        welcomeAtlete.setBounds( 420, 10, 100, 70 );
        startNewGoalButton.setBounds( 615, 200, 150, 150 );
        progressButton.setBounds( 360, 200, 150, 150 );
        atleteButton.setBounds( 105, 200, 150, 150 );

        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/groupsnatch.jpg");
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

    public class SkillDialog extends JDialog {
        public SkillDialog() {
            setTitle("main.getyourolyweight.domain.Skill menu");
            setSize(800, 400);
            setLocation(300, 50);
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
            skillLabel = new JLabel("Kies skill");

            snatchButton = new JButton("Snatch");
            snatchButton.addActionListener(new SkillHandler());

            cleanJerkButton = new JButton("Clean & Jerk");
            cleanJerkButton.addActionListener(new SkillHandler());

            //layout 2 equal buttons
            skillLabel.setBounds( 350, 10, 100, 70 );
            snatchButton.setBounds( 150, 100, 200, 200 );
            cleanJerkButton.setBounds( 450, 100, 200, 200 );

            ImageIcon icon2 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/warmupsnatch.jpg");
            img2 = new JLabel(icon2);
            img2.setBounds( 0, 0, 900, 750 );
            img2.setVisible(true);

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
                    setContentPane(new SnatchDialogPanel(new WeightLiftManager()));
                    setModal(true);
                }
            }

            public class SnatchDialogPanel extends JPanel {
                private JLabel emailLabel, firstNameLabel, lastNameLabel, backSquatLabel, snatchGoalLabel, snatchDateLabel;
                private JButton emailSearchButton, snatchScheduleButton;
                private JTextField emailInput, firstNameInput, lastNameInput, backSquatInput, snatchGoalInput, snatchDateInput;
                private final WeightLiftManager manager;
                private Atlete currentAtlete;

                public SnatchDialogPanel(WeightLiftManager weightLiftManager) {
                    setLayout( null );
                    emailLabel = new JLabel("Emailadres: ");
                    firstNameLabel = new JLabel("Voornaam: ");
                    lastNameLabel = new JLabel("Achternaam: ");
                    backSquatLabel = new JLabel("Backsquat (1RM): ");
                    snatchGoalLabel = new JLabel("Snatch doel gewicht : ");
                    snatchDateLabel = new JLabel("Datum doel gewicht (jjjj-mm-dd): ");
                    emailInput = new JTextField(30);
                    firstNameInput = new JTextField(30);
                    lastNameInput = new JTextField(30);
                    backSquatInput = new JTextField(10);
                    snatchGoalInput = new JTextField(10);
                    snatchDateInput = new JTextField(10);
                    emailSearchButton = new JButton( "Zoek" );
                    emailSearchButton.addActionListener( new EmailSearchHandler() );
                    snatchScheduleButton = new JButton( "Maak Snatch Schema" );
                    manager = weightLiftManager;
                    currentAtlete = null;

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
                    currentAtlete = manager.findAtlete(email);
                    firstNameInput.setText(currentAtlete.getFirtName());
                    String atleteInfo = "Atleet niet gevonden";
                }


                public class AtleteDialog extends JDialog {
                    public AtleteDialog() {
                        setTitle("main.getyourolyweight.domain.Atlete");
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
                setTitle("main.getyourolyweight.domain.Atlete");
                setSize(900, 750);
                setLocation(300, 5);
                setContentPane(new AtleteDialogPanel());
                setModal(true);
            }
        }

        public class AtleteDialogPanel extends JPanel {
            private JLabel atleteEmailLabel, firstNameLabel, lastNameLabel, atleteLabel, newAtleteLabel, newAtleteEmailLabel, newAtleteFirtsNameLabel, newAtleteLastNameLabel;
            private JTextField atleteEmailInput, firstNameInput, lastnameInput, newEmailInput, newFisrtNameInput, newLastNameInput;
            private JButton emailSearchButton, createButton;

            public AtleteDialogPanel() {
                setLayout( null);
                atleteLabel = new JLabel("main.getyourolyweight.domain.Atlete");
                newAtleteLabel = new JLabel("New main.getyourolyweight.domain.Atlete");
                atleteEmailLabel = new JLabel("Emailadres: ");
                atleteEmailInput = new JTextField( 30 );
                firstNameLabel = new JLabel("Fisrtname: ");
                firstNameInput = new JTextField( 30 );
                lastNameLabel = new JLabel("Lastname: ");
                lastnameInput = new JTextField( 30 );
                newAtleteEmailLabel = new JLabel("Emailadres: ");
                newEmailInput = new JTextField( 30 );
                newAtleteFirtsNameLabel = new JLabel("Fisrtname: ");
                newFisrtNameInput = new JTextField( 30 );
                newAtleteLastNameLabel = new JLabel("Lastname: ");
                newLastNameInput = new JTextField( 30 );
                emailSearchButton = new JButton( "Search" );
                createButton = new JButton("Create");

                atleteLabel.setBounds(220, 20, 100, 50);
                newAtleteLabel.setBounds(670, 20, 100, 50);

                atleteEmailLabel.setBounds(20, 100, 100, 50);
                atleteEmailInput.setBounds(100, 100, 200, 50);
                newAtleteEmailLabel.setBounds(470, 100, 100, 50);
                newEmailInput.setBounds(550, 100, 200, 50);
                firstNameLabel.setBounds(20, 170, 100, 50);
                firstNameInput.setBounds(100, 170, 200, 50);
                newAtleteFirtsNameLabel.setBounds(470, 170, 100, 50);
                newFisrtNameInput.setBounds(550, 170, 200, 50);
                lastNameLabel.setBounds(20, 240, 100, 50);
                lastnameInput.setBounds(100, 240, 200, 50);
                newAtleteLastNameLabel.setBounds(470, 240, 100, 50);
                newLastNameInput.setBounds(550, 240, 200, 50);
                emailSearchButton.setBounds(340, 100, 75, 50);
                createButton.setBounds(790, 100, 75, 50);


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
                add(newAtleteEmailLabel);
                add(newEmailInput);
                add(newAtleteFirtsNameLabel);
                add(newFisrtNameInput);
                add(newAtleteLastNameLabel);
                add(newLastNameInput);

            }
        }
    }

