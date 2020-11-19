import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ReportFrame extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/image.png").getImage();

	public ReportFrame(Food food) {
		setTitle("백바구니");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		//setResizable(false); //프레임 크기 고정
		Container c = getContentPane();
		c.setLayout(null);
		String label = food.getName() + " 신고화면";
		JLabel title = new JLabel(label);
		title.setLocation(50,15);
		title.setSize(200,30);
		c.add(title);
		JPanel panel = new JPanel() {
			// 배경이미지와 밑 라인을 그리기 위한 paintComponent()메소드
			public void paintComponent(Graphics g) {
				g.drawImage(backgroundImage, 0, 0, 800, 600, null);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(1, Font.BOLD, 0));
				g2.drawLine(0, 530, 800, 530);
			}
		};

		JTextArea reportContent = new JTextArea();
		reportContent.setLocation(50,50 );
		reportContent.setSize(650, 400);
		c.add(reportContent);
		reportContent.setBorder(new LineBorder(Color.BLACK));
		
		JButton reportdBtn = new JButton("신고"); //요리추천 버튼
		reportdBtn.setSize(100,30);
		reportdBtn.setLocation(250, 500);
		c.add(reportdBtn);
		
		JButton backBtn = new JButton("뒤로 가기"); //신고 버튼
		backBtn.setSize(100,30);
		backBtn.setLocation(400, 500);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){

					dispose();
			}
		});
		c.add(backBtn);
	}

}
