import javax.swing.*;
import java.awt.*;

public class exercise extends JFrame{
	public exercise(ImageIcon[] img) {
		setSize(800,600);
		setVisible(true);
		System.out.println(img.length);
		JButton[] btn = new JButton[img.length];
		ImageIcon[] images=img.clone();
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,8));
		for(int i=0;i<img.length;i++) {
			btn[i]=new JButton("1",images[i]);
			c.add(btn[i]);
		}
		
		
		
	}


}
