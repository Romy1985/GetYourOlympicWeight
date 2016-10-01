
import javax.swing.*;

/**
 * Created by r.ceuleers on 26-9-2016.
 */

/*
public MemberAdminUI(MemberAdminManager memberAdminmanager) {
        initComponents();
        setupFrame();

        manager = memberAdminmanager;
        currentMember = null;
    }
 */

public class WeightLiftUI extends JFrame {
    private final WeightLiftManager manager;
    private Atlete currentAtlete;
        public WeightLiftUI(WeightLiftManager weightLiftManager) {
            JLabel img;
            JFrame frame = new JFrame();
            frame.setSize(900, 700);
            frame.setLocation(280, 5);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new StartPanel());
            frame.setTitle("Get Your Olympic Weight");
            frame.setVisible(true);
            manager = weightLiftManager;
            currentAtlete = null;

            JPanel background = new JPanel();
            background.setBounds(0, 0, 900, 750);
            frame.add(background);
            frame.repaint();

            ImageIcon icon1 = new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/groupsnatch.jpg");
            img = new JLabel(icon1);
            img.setBounds( 0, 0, 900, 750 );
            background.add(img);

        }
    }

