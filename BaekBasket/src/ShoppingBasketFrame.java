import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShoppingBasketFrame extends JFrame{
	JCheckBox[] ingredientBtn;
	
	public ShoppingBasketFrame(String[] str) {
		String[] ingredientArray = str;

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
		deleteBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {    //체크박스를 체크하고 삭제 버튼을 누르면 MainFrame에 있는 basketArray배열중 해당하는 값들이 삭제가 된다.
				int checkedNum=0;
				int j=0;
				
				for(int i=0;i<MainFrame.basketIndex;i++) {
					if(ingredientBtn[i].isSelected()) 
						checkedNum++;
					else {
						MainFrame.basketArray[j]=MainFrame.basketArray[i];
						j++;
					}
				}
			
				for(int i=0;i<checkedNum;i++)
					MainFrame.basketIndex--;
			
				dispose();
				new ShoppingBasketFrame(ingredientArray);
			}
		});;
		c.add(deleteBtn);

		JPanel basketPane = new JPanel();
		basketPane.setLayout(new GridLayout(MainFrame.basketArray.length,1)); //재료의 개수 만큼 행을 나눠줘야해서 배열의 길이만큼 행을 생성
		basketPane.setSize(750,450);

		ingredientBtn= new JCheckBox[MainFrame.basketIndex];
		for(int i=0;i<MainFrame.basketIndex;i++) {
			ingredientBtn[i]=new JCheckBox(MainFrame.basketArray[i]);
			ingredientBtn[i].setBorderPainted(true);
			ingredientBtn[i].setBackground(Color.pink);
			ingredientBtn[i].setForeground(Color.white);
			//ingredientBtn[i].addItemListener(listener);
			basketPane.add(ingredientBtn[i]);
		}

		JScrollPane p1 = new JScrollPane(basketPane);
		p1.setSize(750,450);
		p1.setLocation(15,15);
		p1.setBackground(Color.yellow);

		c.add(p1);
	}
}