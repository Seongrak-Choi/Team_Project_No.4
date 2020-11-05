import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CookListFrame extends JFrame {
	public CookListFrame() {
		JFrame frame = new JFrame("ø‰∏Æ ∏ÆΩ∫∆Æ »≠∏È");
		frame.setLocation(0,0);
		frame.setSize(800,600);
		frame.setLayout(null);
		
		JPanel pFrame = new JPanel();
		pFrame.setLocation(0,0);
		pFrame.setSize(800,600);
		pFrame.setLayout(null);
		pFrame.setBackground(Color.WHITE);
		
		JButton bNightmeal = new JButton("æﬂΩƒ&æ»¡÷");
		bNightmeal.setLocation(50,20);
		bNightmeal.setSize(100,30);
		pFrame.add(bNightmeal);
		bNightmeal.setBackground(Color.WHITE);
		
		JButton bSnack = new JButton("∞£Ωƒ");
		bSnack.setLocation(150,20);
		bSnack.setSize(75,30);
		pFrame.add(bSnack);
		bSnack.setBackground(Color.WHITE);
		
		JButton bKorean = new JButton("«—Ωƒ");
		bKorean.setLocation(225,20);
		bKorean.setSize(75,30);
		pFrame.add(bKorean);
		bKorean.setBackground(Color.WHITE);
		
		JButton bChinese = new JButton("¡ﬂΩƒ");
		bChinese.setLocation(300,20);
		bChinese.setSize(75,30);
		pFrame.add(bChinese);
		bChinese.setBackground(Color.WHITE);
		
		JButton bWestern = new JButton("æÁΩƒ");
		bWestern.setLocation(375,20);
		bWestern.setSize(75,30);
		pFrame.add(bWestern);
		bWestern.setBackground(Color.WHITE);
		
		JButton bSide = new JButton("π›¬˘");
		bSide.setLocation(450,20);
		bSide.setSize(75,30);
		pFrame.add(bSide);
		bSide.setBackground(Color.WHITE);
		
		JButton bCanCook = new JButton("∏∏µÈ ºˆ ¿÷¥¬ ø‰∏Æ »Æ¿Œ");
		bCanCook.setLocation(380,520);
		bCanCook.setSize(170,30);
		pFrame.add(bCanCook);
		bCanCook.setBackground(Color.WHITE);
		
		JButton bBarsket = new JButton("¿ÂπŸ±∏¥œ");
		bBarsket.setLocation(550,520);
		bBarsket.setSize(90,30);
		pFrame.add(bBarsket);
		bBarsket.setBackground(Color.WHITE);
		
		JButton bCancel = new JButton("¡æ∑·");
		bCancel.setLocation(640,520);
		bCancel.setSize(75,30);
		pFrame.add(bCancel);
		bCancel.setBackground(Color.WHITE);
		
		JTextField tSearch = new JTextField("search");
		tSearch.setLocation(550,20);
		tSearch.setSize(200,30);
		pFrame.add(tSearch);
		tSearch.setBorder(new LineBorder(Color.BLACK));
		
		JPanel pCookList = new JPanel();
		pCookList.setLocation(50,75);
		pCookList.setSize(665,425);
		pCookList.setLayout(null);	
		
		String[] cookList = {"∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã",
				"∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã","∂±∫∫¿Ã"};
		JList lCookList = new JList(cookList);
		lCookList.setLocation(0,0);
		lCookList.setSize(665,425);
		lCookList.setBorder(new LineBorder(Color.BLACK));
		
		
		pCookList.add(lCookList);
	
		
		
		
		frame.add(pCookList);
		frame.add(pFrame);
	
		frame.setVisible(true);
	}

}