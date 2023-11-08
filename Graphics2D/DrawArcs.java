package Graphics2D;

// Fig. 12.25: DrawArcs.java
// Drawing arcs.
import javax.swing.JFrame;

public class DrawArcs 
{
   // execute application
   public static void main( String args[] )
   {
      // create frame for ArcsJPanel
      JFrame frame = new JFrame( "Edward Vito 225314067" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      ArcsJPanel arcsJPanel = new ArcsJPanel(); // create ArcsJPanel
      frame.add( arcsJPanel ); // add arcsJPanel to frame
      frame.setSize( 300, 210 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class DrawArcs