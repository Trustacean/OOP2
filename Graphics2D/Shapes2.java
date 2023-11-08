package Graphics2D;


// Fig. 12.32: Shapes2.java
// Demonstrating a general path.
import java.awt.Color;
import javax.swing.JFrame;

public class Shapes2 extends Thread
{
   // execute application
   private static Shapes2JPanel shapes2JPanel;
   public static void main( String args[] )
   {
      // create frame for Shapes2JPanel
      JFrame frame = new JFrame( "Edward Vito - 225314067" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      shapes2JPanel = new Shapes2JPanel();
      frame.add( shapes2JPanel ); // add shapes2JPanel to frame
      frame.setBackground( Color.WHITE ); // set frame background color
      frame.setSize( 400, 400 ); // set frame size
      frame.setVisible( true ); // display frame
      Shapes2 sh=new Shapes2();
      sh.start();
   } // end main


    public void run(){
        while (true){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){break;}
            shapes2JPanel.repaint();
        }
    }
} // end class Shapes2