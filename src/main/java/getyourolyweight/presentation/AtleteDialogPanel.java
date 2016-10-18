package getyourolyweight.presentation;

import getyourolyweight.businesslogic.WeightLiftManager;
import getyourolyweight.domain.Atlete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by r.ceuleers on 6-10-2016.
 */
public class AtleteDialogPanel extends JPanel {
    private JLabel atleteEmailLabel, firstNameLabel, lastNameLabel, atleteLabel, newAtleteLabel, newAtleteEmailLabel, newAtleteFirtsNameLabel, newAtleteLastNameLabel;
    private JTextField atleteEmailInput, firstNameInput, lastNameInput, newEmailInput, newFisrtNameInput, newLastNameInput;
    private JButton emailSearchButton, createButton;
    private final WeightLiftManager manager;
    private Atlete currentAtlete;

    public AtleteDialogPanel(WeightLiftManager weightLiftManager) {
        setLayout( null);
        atleteLabel = new JLabel("main.getyourolyweight.domain.Atlete");
        newAtleteLabel = new JLabel("New main.getyourolyweight.domain.Atlete");
        atleteEmailLabel = new JLabel("Emailadres: ");
        atleteEmailInput = new JTextField( 30 );
        firstNameLabel = new JLabel("Fisrtname: ");
        firstNameInput = new JTextField( 30 );
        lastNameLabel = new JLabel("Lastname: ");
        lastNameInput = new JTextField( 30 );
        newAtleteEmailLabel = new JLabel("Emailadres: ");
        newEmailInput = new JTextField( 30 );
        newAtleteFirtsNameLabel = new JLabel("Fisrtname: ");
        newFisrtNameInput = new JTextField( 30 );
        newAtleteLastNameLabel = new JLabel("Lastname: ");
        newLastNameInput = new JTextField( 30 );
        emailSearchButton = new JButton( "Search" );
        createButton = new JButton("Create");
        manager = weightLiftManager;
        currentAtlete = null;

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
        lastNameInput.setBounds(100, 240, 200, 50);
        newAtleteLastNameLabel.setBounds(470, 240, 100, 50);
        newLastNameInput.setBounds(550, 240, 200, 50);
        emailSearchButton.setBounds(340, 100, 75, 50);
        emailSearchButton.addActionListener( new EmailSearchHandler());
        createButton.setBounds(790, 100, 75, 50);


        add(atleteLabel);
        add(newAtleteLabel);
        add(atleteEmailLabel);
        add(atleteEmailInput);
        add(firstNameLabel);
        add(firstNameInput);
        add(lastNameLabel);
        add(lastNameInput);
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
                String atleteInfo = "Atleet niet gevonden";
            }
        }



