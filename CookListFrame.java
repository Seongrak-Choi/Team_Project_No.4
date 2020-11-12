package Team;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CookListFrame extends JFrame {
	JPanel[] Jpanel = new JPanel[7]; // �г�, ����Ʈ, ��ũ�� ����
	JList[] Jlist = new JList[7];
	JScrollPane[] Jsb = new JScrollPane[7];
	JFrame frame = new JFrame("�丮 ����Ʈ ȭ��"); 
	JPanel pFrame = new JPanel();
	JButton bNightmeal = new JButton("�߽�&����");
	JButton bSnack = new JButton("����");
	JButton bKorean = new JButton("�ѽ�");
	JButton bChinese = new JButton("�߽�");
	JButton bWestern = new JButton("���");
	JButton bSide = new JButton("����");
	JButton bCanCook = new JButton("���� �� �ִ� �丮 Ȯ��");
	JButton bBarsket = new JButton("��ٱ���");
	JButton bBack = new JButton("����");
	JTextField tSearch = new JTextField();
	JButton bSearch = new JButton("�˻�");

	public CookListFrame() {
		frame.setLocation(0,0);
		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] allMenu = new String[5];
		allMenu[0]="�߽�0";
		allMenu[1]="����0";
		allMenu[2]="�ѽ�0";
		allMenu[3]="���½�0";
		allMenu[4]="����0";
		String[] compare = new String[allMenu.length];

		for(int i=0;i<allMenu.length;i++) // compare�� allMenu����
			compare[i]=allMenu[i];

		pFrame.setLocation(0,0);
		pFrame.setSize(800,600);
		pFrame.setLayout(null);
		pFrame.setBackground(Color.WHITE);

		bNightmeal.setLocation(50,20);
		bNightmeal.setSize(100,30);
		pFrame.add(bNightmeal);
		bNightmeal.setBackground(Color.WHITE);

		bSnack.setLocation(150,20);
		bSnack.setSize(75,30);
		pFrame.add(bSnack);
		bSnack.setBackground(Color.WHITE);

		bKorean.setLocation(225,20);
		bKorean.setSize(75,30);
		pFrame.add(bKorean);
		bKorean.setBackground(Color.WHITE);

		bChinese.setLocation(300,20);
		bChinese.setSize(75,30);
		pFrame.add(bChinese);
		bChinese.setBackground(Color.WHITE);

		bWestern.setLocation(375,20);
		bWestern.setSize(75,30);
		pFrame.add(bWestern);
		bWestern.setBackground(Color.WHITE);

		bSide.setLocation(450,20);
		bSide.setSize(75,30);
		pFrame.add(bSide);
		bSide.setBackground(Color.WHITE);

		bCanCook.setLocation(380,520);
		bCanCook.setSize(170,30);
		pFrame.add(bCanCook);
		bCanCook.setBackground(Color.WHITE);

		bBarsket.setLocation(550,520);
		bBarsket.setSize(90,30);
		pFrame.add(bBarsket);
		bBarsket.setBackground(Color.WHITE);

		bBack.setLocation(640,520);
		bBack.setSize(75,30);
		pFrame.add(bBack);
		bBack.setBackground(Color.WHITE);

		tSearch.setLocation(550,20);
		tSearch.setSize(150,30);
		pFrame.add(tSearch);
		tSearch.setBorder(new LineBorder(Color.BLACK));

		bSearch.setLocation(710,20);
		bSearch.setSize(60,30);
		pFrame.add(bSearch);
		bSearch.setBackground(Color.WHITE);

		String[] nightmeal = new String[30]; // �߽� ���� ĭ
		for(int i=0;i<30;i++)
			nightmeal[i] = "�߽�"+i ;

		String[] snack = new String[30]; // ����
		for(int i=0;i<30;i++)
			snack[i] = "����"+i ;

		String[] korean = new String[30]; // �ѽ�
		for(int i=0;i<30;i++)
			korean[i] = "�ѽ�"+i ;

		for(int i=0;i<7;i++) {
			Jpanel[i] = new JPanel();
			Jpanel[i].setLocation(50,75);
			Jpanel[i].setSize(665,425);
			Jpanel[i].setLayout(null);
			if(i!=0)
				Jpanel[i].setVisible(false);

			if(i==0) 
				Jlist[i] = new JList(nightmeal);
			else if(i==1)
				Jlist[i] = new JList(snack);
			else if(i==2)
				Jlist[i] = new JList(korean);
			else if(i==3)
				Jlist[i] = new JList();
			else if(i==4)
				Jlist[i] = new JList();
			else if(i==5)
				Jlist[i] = new JList();
			else if(i==6)
				Jlist[i] = new JList(allMenu);

			Jlist[i].setLocation(0,0);
			Jlist[i].setSize(665,425);
			Jlist[i].setBorder(new LineBorder(Color.BLACK));

			Jsb[i] = new JScrollPane(Jlist[i]);
			Jsb[i].setLocation(0,0);
			Jsb[i].setSize(665,425);
			Jpanel[i].add(Jsb[i]);
			frame.add(Jpanel[i]);
		}
		bNightmeal.addActionListener(new EventHandler());
		bSnack.addActionListener(new EventHandler());
		bKorean.addActionListener(new EventHandler());
		bBack.addActionListener(new EventHandler());

		bSearch.addActionListener(new ActionListener(){  // ����ư ������
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==bSearch) {
					String searchCook = tSearch.getText(); 

					for(int i=0;i<compare.length;i++)
						allMenu[i]=compare[i];
					for(int i=0;i<compare.length;i++) {
						if(allMenu[i].equals(searchCook)) {
							allMenu[0] = allMenu[i];
						}
					}

					for(int i=1;i<compare.length;i++) {
						if(allMenu[0].contentEquals(searchCook))
							allMenu[i]=null;
					}

					for(int i=0;i<7;i++) {
						if(i!=6)
							Jpanel[i].setVisible(false);
						else
							Jpanel[i].setVisible(true);
					}
				}
				else if(e.getSource()==bKorean) {
					for(int i=0;i<7;i++) {
						if(i!=2)
							Jpanel[i].setVisible(false);
						else
							Jpanel[i].setVisible(true);
					}
				}
			}
		});;

		frame.add(pFrame);
		frame.setVisible(true);
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bNightmeal) {
				for(int i=0;i<7;i++) {
					if(i!=0)
						Jpanel[i].setVisible(false);
					else
						Jpanel[i].setVisible(true);
				}
			}
			else if(e.getSource()==bSnack) {
				for(int i=0;i<7;i++) {
					if(i!=1)
						Jpanel[i].setVisible(false);
					else
						Jpanel[i].setVisible(true);
				}
			}
			else if(e.getSource()==bKorean) {
				for(int i=0;i<7;i++) {
					if(i!=2)
						Jpanel[i].setVisible(false);
					else
						Jpanel[i].setVisible(true);
				}
			}
			else if(e.getSource()==bBack) {
				MainFrame mainFrame = new MainFrame();
				frame.setVisible(false);
			}

		}
	}
}
