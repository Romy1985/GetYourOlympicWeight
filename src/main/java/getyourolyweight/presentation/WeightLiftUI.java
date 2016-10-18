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
        public WeightLiftUI(WeightLiftManager weightLiftManager) {
            JLabel img;
            JFrame frame = new JFrame();
            frame.setSize(900, 700);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new StartPanel());
            frame.setTitle("Get Your Olympic Weight");
            frame.setVisible(true);
            manager = weightLiftManager;
            currentAtlete = null;

        }
    }

