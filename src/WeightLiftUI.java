import javax.swing.*;

/**
 * Created by r.ceuleers on 26-9-2016.
 */

public class WeightLiftUI extends JFrame {
        public static void main(String args[]) {
            JFrame frame = new JFrame();
            frame.setSize(800, 400);
            frame.setLocation(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new StartPanel());
            frame.setTitle("Get Your Olympic Weight");
            frame.setVisible(true);

        }
    }

