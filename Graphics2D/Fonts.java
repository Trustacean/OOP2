package Graphics2D;

// Fig. 12.12: Fonts.java
// Using fonts.
import javax.swing.JFrame;

public class Fonts 
{
   // execute application
   public static void main( String args[] )
   {
      // create frame for FontJPanel
      JFrame frame = new JFrame( "Edward Vito - 225314067" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      FontJPanel fontJPanel = new FontJPanel(); // create FontJPanel
      frame.add( fontJPanel ); // add fontJPanel to frame
      frame.setSize( 420, 170 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class Fonts