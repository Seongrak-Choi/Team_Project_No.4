import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CookListFrame extends JFrame {

	public ImageIcon icon3 = new ImageIcon("images/image3.png");
	int index=MainFrame.index;
	JFrame frame = new JFrame("요리 리스트 화면");
	JPanel pFrame = new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(icon3.getImage(),0,0,800,600, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};

	JButton bSnack = new JButton("간식");
	JButton bSoup = new JButton("찌개&국");
	JButton bSide = new JButton("반찬");
	JButton bRice = new JButton("밥");
	JButton bEtc = new JButton("기타");
	JButton bBack = new JButton("이전");
	JTextField tSearch = new JTextField();
	JButton bSearch = new JButton("검색");
	JPanel pCookList = new JPanel();
	String[] snack = new String[MainFrame.snack];
	String[] soup = new String[MainFrame.soup];
	String[] side = new String[MainFrame.side];
	String[] rice = new String[MainFrame.rice];
	String[] etc =new String[MainFrame.etc];
	String[] cook = new String[index];
	JList lCookList = new JList(cook);
	String[] compare = new String[index];

	public CookListFrame(Food[] food) {
		Food[] f= food;
		frame.setLocation(0, 0); // 필요한 컴포넌트들 추가
		frame.setSize(800, 600);
		frame.setLayout(null);

		pFrame.setLocation(0, 0);
		pFrame.setSize(800, 600);
		pFrame.setLayout(null);
		pFrame.setBackground(Color.WHITE);

		bSnack.setLocation(50, 46);
		bSnack.setSize(100, 30);
		pFrame.add(bSnack);
		bSnack.setForeground(Color.gray);
		bSnack.setBackground(Color.WHITE);


		bSoup.setLocation(150, 46);
		bSoup.setSize(90, 30);
		pFrame.add(bSoup);
		bSoup.setForeground(Color.gray);
		bSoup.setBackground(Color.WHITE);

		bSide.setLocation(240, 46);
		bSide.setSize(75, 30);
		pFrame.add(bSide);
		bSide.setForeground(Color.gray);
		bSide.setBackground(Color.WHITE);

		bRice.setLocation(315, 46);
		bRice.setSize(75, 30);
		pFrame.add(bRice);
		bRice.setForeground(Color.gray);
		bRice.setBackground(Color.WHITE);

		bEtc.setLocation(390, 46);
		bEtc.setSize(75, 30);
		pFrame.add(bEtc);
		bEtc.setForeground(Color.gray);
		bEtc.setBackground(Color.WHITE);

		bBack.setLocation(690, 520);
		bBack.setSize(75, 30);
		pFrame.add(bBack);
		bBack.setBackground(Color.WHITE);		

		tSearch.setLocation(550, 20);
		tSearch.setSize(150,30);
		pFrame.add(tSearch);
		tSearch.setBorder(new LineBorder(Color.BLACK));

		bSearch.setLocation(710,20);
		bSearch.setSize(60,30);
		pFrame.add(bSearch);
		bSearch.setBackground(Color.WHITE);

		pCookList.setLocation(50, 75);
		pCookList.setSize(665, 425);
		pCookList.setLayout(null);
		pCookList.setVisible(true);


		int iSnack =0; // 순서대로 적재하기 위한 필드 선언
		int iSoup =0;
		int iSide =0;
		int iRice =0;
		int iEtc =0;
		
		bSnack.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {    
				bSnack.setBackground(Color.pink);
				bSoup.setBackground(Color.white);
				bSide.setBackground(Color.white);
				bRice.setBackground(Color.white);
				bEtc.setBackground(Color.white);
				bSnack.setForeground(Color.black);
				bSoup.setForeground(Color.gray);
				bSide.setForeground(Color.gray);
				bRice.setForeground(Color.gray);
				bEtc.setForeground(Color.gray);
			}
		});;
		bSoup.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {   
				bSnack.setBackground(Color.white);
				bSoup.setBackground(Color.pink);
				bSide.setBackground(Color.white);
				bRice.setBackground(Color.white);
				bEtc.setBackground(Color.white);
				bSnack.setForeground(Color.gray);
				bSoup.setForeground(Color.black);
				bSide.setForeground(Color.gray);
				bRice.setForeground(Color.gray);
				bEtc.setForeground(Color.gray);
			}
		});;
		bSide.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {   
				bSnack.setBackground(Color.white);
				bSoup.setBackground(Color.white);
				bSide.setBackground(Color.pink);
				bRice.setBackground(Color.white);
				bEtc.setBackground(Color.white);
				bSnack.setForeground(Color.gray);
				bSoup.setForeground(Color.gray);
				bSide.setForeground(Color.black);
				bRice.setForeground(Color.gray);
				bEtc.setForeground(Color.gray);
			}
		});;
		bRice.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {    
				bSnack.setBackground(Color.white);
				bSoup.setBackground(Color.white);
				bSide.setBackground(Color.white);
				bRice.setBackground(Color.pink);
				bEtc.setBackground(Color.white);
				bSnack.setForeground(Color.gray);
				bSoup.setForeground(Color.gray);
				bSide.setForeground(Color.gray);
				bRice.setForeground(Color.black);
				bEtc.setForeground(Color.gray);
			}
		});;
		bEtc.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {    
				bSnack.setBackground(Color.white);
				bSoup.setBackground(Color.white);
				bSide.setBackground(Color.white);
				bRice.setBackground(Color.white);
				bEtc.setBackground(Color.pink);
				bSnack.setForeground(Color.gray);
				bSoup.setForeground(Color.gray);
				bSide.setForeground(Color.gray);
				bRice.setForeground(Color.gray);
				bEtc.setForeground(Color.black);
			}
		});;

		
		
		for(int i=0;i<index;i++) { // 분류 된 메뉴를 순서대로 저장
			if(f[i]!=null) { 
				if(f[i].categoryNo==0) {
					snack[iSnack]=f[i].name;
					iSnack++;
				}
				else if(f[i].categoryNo==1) {
					soup[iSoup]=f[i].name;
					iSoup++;
				}
				else if(f[i].categoryNo==2) {
					side[iSide]=f[i].name;
					iSide++;
				}
				else if(f[i].categoryNo==3) {
					rice[iRice]=f[i].name;
					iRice++;
				}
				else if(f[i].categoryNo==4) {
					etc[iEtc]=f[i].name;
					iEtc++;
				}
			}
		}
		for(int i=0;i<index;i++) { // cook배열 초기화
			if(f[i]!=null)
				cook[i] = f[i].name;
		}

		for(int i=0;i<index;i++)
			compare[i]=cook[i];

		lCookList.setLocation(0, 0);
		lCookList.setSize(665, 425);
		lCookList.setBorder(new LineBorder(Color.BLACK));

		lCookList.addMouseListener(new MouseAdapter() { // 리스트 배열 더블클릭 이벥트 
			@Override public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					String compare=(String)lCookList.getSelectedValue(); 
					int j=0;
					for(int i=0;i<index;i++) {
						if(f[i]!=null&&f[i].name.equals(compare))
							j=i;
					}   
					RecipeInterface recipeInterface = new RecipeInterface(f[j]); // 선택한 음식을 넘기며 RecipeInterface 생성
				}
			}});

		JScrollPane sb = new JScrollPane(lCookList);
		sb.setLocation(0,0);
		sb.setSize(665,425);
		pCookList.add(sb);

		bSnack.addActionListener(new EventHandler());
		bSoup.addActionListener(new EventHandler());
		bSide.addActionListener(new EventHandler());
		bRice.addActionListener(new EventHandler());
		bEtc.addActionListener(new EventHandler());
		bBack.addActionListener(new EventHandler());
		bSearch.addActionListener(new EventHandler());

		frame.add(pCookList);
		frame.add(pFrame);

		frame.setVisible(true);
	}
	class EventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bBack) 
				frame.dispose();
			else if(e.getSource()==bSnack) {
				lCookList.setListData(snack);
			}
			else if(e.getSource()==bSoup) 
				lCookList.setListData(soup);
			else if(e.getSource()==bSide) 
				lCookList.setListData(side);
			else if(e.getSource()==bRice) 
				lCookList.setListData(rice);
			else if(e.getSource()==bEtc) 
				lCookList.setListData(etc);
			else if(e.getSource()==bSearch) {
				String searchCook = tSearch.getText(); 
				String[] searchedCook = new String[index];

				for(int i=0;i<index;i++) // cook 초기화 작업
					cook[i]=compare[i];

				int j=0;
				for(int i=0;i<index;i++) {
					if(cook[i].contains(searchCook)) {
						searchedCook[j]=cook[i];
						j++;
					}
				}
				lCookList.setListData(searchedCook);
			}
		}
	}
}

