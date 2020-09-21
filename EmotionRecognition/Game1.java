import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game1 extends JApplet
{
   
	  public void run()
	 {
        Display secondApplet = (Display)getAppletContext().getApplet("Display");
        if (secondApplet != null) {
            secondApplet.init();
            secondApplet.start();
        }
        else {
            System.out.println("Not Running\n");
        }
	  }

}
