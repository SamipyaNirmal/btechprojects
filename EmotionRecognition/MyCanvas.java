import java.awt.*;  
import javax.swing.*;  
  
public class MyCanvas extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("start.png");  
        g.drawImage(i, 120,100,this);  
          
    }  
        public static void main(String[] args) {  
        MyCanvas m=new MyCanvas();  
        JFrame f=new JFrame();  
        f.add(m);  
		JTextField t1=new JTextField("Welcome to Javatpoint.");  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(t1);
        f.setSize(400,400);  
        f.setVisible(true);  
    }  
  
}  