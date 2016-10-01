/**
 * Created by r.ceuleers on 25-9-2016.
 */


public class Main {
    private Main() {
    }
    public static void main(String[] args) {
        WeightLiftUI ui = new WeightLiftUI(new WeightLiftManager() );
        ui.setVisible( true);
    }
}

/*
import javax.swing.*;

public class Main extends JFrame {
    public static void main(String args[]) {
        JLabel img ;
        JFrame frame = new Main();
        frame.setSize(900, 750);
        frame.setLocation(300, 5);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new StartPanel());
        frame.setTitle("Get Your Olympic Weight");
        frame.setVisible(true);
        new Main();

        JPanel background = new JPanel();
        background.setBounds(0, 0, 900, 800);
        frame.add(background);
        frame.repaint();

        ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/groupsnatch.jpg");
        img = new JLabel(icon1);
        img.setBounds( 0, 0, 900, 800 );
        background.add(img);


    }
}
*/






