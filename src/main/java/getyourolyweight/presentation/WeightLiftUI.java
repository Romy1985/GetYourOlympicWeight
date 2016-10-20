package getyourolyweight.presentation;

import getyourolyweight.businesslogic.WeightLiftManager;
import getyourolyweight.domain.Atlete;

import javax.swing.*;

/**
 * Created by r.ceuleers on 26-9-2016.
 */


public class WeightLiftUI extends JFrame {
    private final WeightLiftManager manager;
    private Atlete currentAtlete;
    private JPanel panel = new JPanel();
    private JLabel img;
        public WeightLiftUI(WeightLiftManager weightLiftManager) {
            JFrame frame = new JFrame();
            frame.setSize(900, 700);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new StartPanel());
            frame.setTitle("Get Your Olympic Weight");

            manager = weightLiftManager;
            currentAtlete = null;

            ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/main/resources/images/groupsnatch.jpg");
            img = new JLabel(icon1);
            img.setBounds(0, 0, 900, 750);
            img.setVisible(true);


            panel.setBounds(0,0, 900, 750);
            panel.add(img);
            panel.setVisible(true);
            panel.repaint();

            frame.add(panel);
            frame.setVisible(true);
            frame.repaint();

        }
    }

