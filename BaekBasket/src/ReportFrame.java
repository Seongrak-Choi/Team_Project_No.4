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
	public ImageIcon icon3 = new ImageIcon("images\\image3.png");
	int reportNo = 1;

	public ReportFrame(Food food) {
		setTitle("백바구니");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		
		Container c = getContentPane();
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(icon3.getImage(),0,0,800,600, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		
		panel.setLayout(null);
		String label = food.getName() + " 신고화면";
		JLabel title = new JLabel(label);
		title.setLocation(50, 15);
		title.setSize(200, 30);
		c.add(panel);
		panel.add(title);

		JTextArea reportContent = new JTextArea();
		reportContent.setLocation(50, 50);
		reportContent.setSize(650, 400);
		panel.add(reportContent);
		reportContent.setBorder(new LineBorder(Color.BLACK));

		JButton reportBtn = new JButton("신고");
		reportBtn.setSize(100, 30);
		reportBtn.setLocation(250, 500);
		reportBtn.setBackground(Color.WHITE);
		reportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream("c:/Users/public/" + food.getName() + "report" + reportNo + ".txt")));
					writer.write(reportContent.getText());
					reportNo++;
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					dispose();
				}
			}
		});
		panel.add(reportBtn);

		JButton backBtn = new JButton("취소");
		backBtn.setSize(100, 30);
		backBtn.setLocation(400, 500);
		backBtn.setBackground(Color.WHITE);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(backBtn);
	}
}