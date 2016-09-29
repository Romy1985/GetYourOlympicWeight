/**
 * Created by r.ceuleers on 25-9-2016.
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Main extends JFrame {
    // met deze methode wordt de image in een apart venster getoond
    /*
   private JLabel background ;

   public Main() {
   setSize( 800, 400 );
   setVisible( true );

        setLayout( new BorderLayout() );

        JLabel backgroundImage = new JLabel(new ImageIcon("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/groupsnatch.jpg")) ;

      add( backgroundImage );

} */

    public static void main( String args[] ) {
        JFrame frame = new Main() ;
        frame.setSize( 800, 400 );
        frame.setLocation( 300, 200 ) ;
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setContentPane( new StartPanel() );
        frame.setTitle( "Get Your Olympic Weight" );
        frame.setVisible( true );
        new Main();


       // Met deze methode wordt de image over de knoppen getoond
        /*

        try{
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/r.ceuleers/Documents/Avans 2016-2017/Blok 1 - Aan de slag met Java/Praktijkopdracht/GetYourOlyWeight/src/images/groupsnatch.jpg")))));
        }catch (IOException e)
        {
            System.out.println("Image doesn't exist");
        }
        frame.setResizable( true );
        frame.pack();
        */





    }
}
