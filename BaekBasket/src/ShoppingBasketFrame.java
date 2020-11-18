import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShoppingBasketFrame extends JFrame{
	public ShoppingBasketFrame() {
		setTitle("백바구니");
		setSize(800,600);
		setVisible(true);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		
		JButton backBtn = new JButton("뒤로가기");
		backBtn.setLocation(670,500);
		backBtn.setSize(100,30);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});;
		c.add(backBtn);
		
		
		JButton deleteBtn = new JButton("삭 제");
		deleteBtn.setLocation(590,500);
		deleteBtn.setSize(70,30);
		c.add(deleteBtn);
		
		
		JScrollPane p1 = new JScrollPane();
		p1.setSize(750,450);
		p1.setLocation(15,15);
		p1.setBackground(Color.yellow);
		
		
		
		c.add(p1);
	}
	public static void main(String[] args) {
		new ShoppingBasketFrame();
	}

}
