package Graphics2D;

// Fig. 12.16: Metrics.java
// Displaying font metrics.
import javax.swing.JFrame;

public class Metrics 
{
   // execute application
   public static void main( String args[] )
   {
      // create frame for MetricsJPanel
      JFrame frame = new JFrame( "Edward Vito - 225314067" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      MetricsJPanel metricsJPanel = new MetricsJPanel(); 
      frame.add( metricsJPanel ); // add metricsJPanel to frame
      frame.setSize( 510, 250 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
} // end class Metrics