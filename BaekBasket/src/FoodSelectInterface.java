import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class FoodSelectInterface extends JFrame {
	
	JCheckBox[] ingredientBox;
	JList cookList = new JList();
	
	public FoodSelectInterface(Food[] food) {
		Food[] f=food;
		setTitle("백바구니");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JPanel checkPane = new JPanel(); //frame에 부탁될 재료선택 panel
		JPanel listPane = new JPanel(); //frame에 부탁될 요리리스트 panel
		JButton searchBtn=new JButton("검 색"); //클릭시 선택한 재료들로 요리추천을 해주는 버튼
		JButton backBtn=new JButton("뒤로가기"); //클릭시 창이 닫히는 버튼
		
		//checkPane.add(ingredientBox);  checkBox 객체 생성할 때 붙혀줘야 겠음. 
		listPane.add(cookList);
		
		checkPane.setLocation(20,10);            
		checkPane.setSize(740,250);
		checkPane.setBackground(Color.yellow);
		listPane.setLocation(20,330);
		listPane.setSize(740,350);
		listPane.setBackground(Color.pink);
		
		
		searchBtn.setLocation(680,220);
		searchBtn.setSize(80,30);
		backBtn.setLocation(660,500);
		backBtn.setSize(100,30);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});;
	}
}
