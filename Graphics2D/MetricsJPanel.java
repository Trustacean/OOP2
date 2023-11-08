package Graphics2D;

// Fig. 12.15: MetricsJPanel.java
// FontMetrics and Graphics methods useful for obtaining font metrics.
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MetricsJPanel extends JPanel 
{
   // display font metrics
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); // call superclass's paintComponent

      g.setFont( new Font( "SansSerif", Font.BOLD, 12 ) );
      FontMetrics metrics = g.getFontMetrics();
      g.drawString( "Current font: " + g.getFont(), 10, 40 );
      g.drawString( "Ascent: " + metrics.getAscent(), 10, 55 );
      g.drawString( "Descent: " + metrics.getDescent(), 10, 70 );
      g.drawString( "Height: " + metrics.getHeight(), 10, 85 );
      g.drawString( "Leading: " + metrics.getLeading(), 10, 100 );

      Font font = new Font( "Serif", Font.ITALIC, 14 );
      metrics = g.getFontMetrics( font );
      g.setFont( font );
      g.drawString( "Current font: " + font, 10, 130 );
      g.drawString( "Ascent: " + metrics.getAscent(), 10, 145 );
      g.drawString( "Descent: " + metrics.getDescent(), 10, 160 );
      g.drawString( "Height: " + metrics.getHeight(), 10, 175 );
      g.drawString( "Leading: " + metrics.getLeading(), 10, 190 );
   } // end method paintComponent
} // end class MetricsJPanel
