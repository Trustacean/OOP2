
package Graphics2D;

// Fig. 12.28: DrawPolygons.java
// Drawing polygons.
import javax.swing.JFrame;

public class DrawPolygons 
{
   // execute application
   public static void main( String args[] )
   {
      // create frame for PolygonsJPanel
      JFrame frame = new JFrame( "Edward Vito - 225314067" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      PolygonsJPanel polygonsJPanel = new PolygonsJPanel(); 
      frame.add( polygonsJPanel ); // add polygonsJPanel to frame
      frame.setSize( 280, 270 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class DrawPolygons