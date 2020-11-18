import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ReportFrame extends JFrame {
	int reportNo = 1;
	JTextArea reportCon =null;
	Food f = null;

	public ReportFrame(Food food) {
		f = food;
		setTitle("백바구니");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		// setResizable(false); //프레임 크기 고정
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		String label = food.getName() + " 신고화면";
		JLabel title = new JLabel(label);
		title.setLocation(50, 15);
		title.setSize(200, 30);
		c.add(title);

		JTextArea reportContent = new JTextArea();
		reportContent.setLocation(50, 50);
		reportContent.setSize(650, 400);
		c.add(reportContent);
		reportContent.setBorder(new LineBorder(Color.BLACK));
		reportCon = reportContent;
		
		JButton reportBtn = new JButton("신고"); // 요리추천 버튼
		reportBtn.setSize(100, 30);
		reportBtn.setLocation(250, 500);
		reportBtn.setBackground(Color.WHITE);
		c.add(reportBtn);
		reportBtn.addActionListener(new MyActionListener());

		JButton backBtn = new JButton("뒤로 가기"); // 신고 버튼
		backBtn.setSize(100, 30);
		backBtn.setLocation(400, 500);
		backBtn.setBackground(Color.WHITE);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		c.add(backBtn);
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("신고")) {
				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream("c:/Users/public/" + f.getName() + "report" + reportNo + ".txt")));
					writer.write(reportCon.getText());
					reportNo++;
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					dispose();
				}
			}
		}
	}
}