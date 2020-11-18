import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class FoodSelectInterface extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/image.png").getImage();
	private Object[] column = { " ", "재료" };
	private Object[][] raw = { { false, "재료1" }, { false, "재료2" }, { false, "재료3" }, { false, "재료4" },
			{ false, "재료5" }, { false, "재료6" }, { false, "재료7" }, { false, "재료8" }, { false, "재료9" }, { false, "재료10" },
			{ false, "재료11" }, { false, "재료12" }, { false, "재료13" }, { false, "재료14" }, { false, "재료15" },
			{ false, "재료16" }, { false, "재료17" }, { false, "재료18" }, { false, "재료19" }, { false, "재료20" },
			{ false, "재료21" }, { false, "재료22" }, { false, "재료23" }, { false, "재료24" }, { false, "재료25" },
			{ false, "재료26" }, { false, "재료27" }, { false, "재료28" }, { false, "재료29" }, { false, "재료30" },
			{ false, "재료31" }, { false, "재료32" }, { false, "재료33" }, { false, "재료34" }, { false, "재료35" },
			{ false, "재료36" }, { false, "재료37" }, { false, "재료38" }, { false, "재료39" }, { false, "재료40" },
			{ false, "재료41" }, { false, "재료42" }, { false, "재료43" }, { false, "재료44" }, { false, "재료45" },
			{ false, "재료46" },

	};
	private String[] avi = { "영상1" , "영상2", "영상3", "영상4", "영상5", "영상6", "영상7",
			 "영상8" , "영상9", "영상10", "영상11", "영상12", "영상13", "영상14",
			 "영상15" , "영상16", "영상17", "영상18", "영상19", "영상20", "영상21",
			 "영상22" , "영상23", "영상24", "영상25", "영상26", "영상27", "영상28"
			};

	public FoodSelectInterface() {
		// 메인 프레임
		JFrame frame = new JFrame();
		// 메인 패널
		JPanel panel = new JPanel() {
			// 배경이미지와 밑 라인을 그리기 위한 paintComponent()메소드
			public void paintComponent(Graphics g) {
				g.drawImage(backgroundImage, 0, 0, 800, 600, null);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(1, Font.BOLD, 0));
				g2.drawLine(0, 530, 800, 530);
			}
		};

		panel.setLayout(null);
		panel.setBackground(Color.white);

		frame.add(panel);

		// 검색버튼
		JButton btn1 = new JButton("검색");
		btn1.setLayout(null);
		btn1.setSize(60, 20);
		btn1.setLocation(660, 230);
		btn1.setBackground(Color.white);
		panel.add(btn1);

		// 뒤로가기 버튼
		JButton btn2 = new JButton("뒤로가기");
		btn2.setLayout(null);
		btn2.setSize(86, 20);
		btn2.setLocation(635, 500);
		btn2.setBackground(Color.white);
		panel.add(btn2);

		// 재료선택 테이블 구성
		DefaultTableModel dtm = new DefaultTableModel(raw, column);
		JTable table = new JTable(dtm);
		table.setBounds(20, 20, 700, 200);

		table.getColumn(" ").setCellRenderer(dcr);
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn(" ").setCellEditor(new DefaultCellEditor(box));

		// 재료선택 테이블에 스크롤 달기
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(table.getX(), table.getY(), table.getWidth(), table.getHeight());
		panel.add(scrollPane, "Center");

		// 영상 테이블 리스트
		JList list = new JList(avi);
		list.setBounds(20, 290, 700, 200);
		JScrollPane sp = new JScrollPane(list);
		sp.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
		panel.add(sp, "Center");
		
		
		frame.setTitle("백바구니");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new FoodSelectInterface();

	}

	// 재료선택 테이블에 담을 체크박스 구현
	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JCheckBox box = new JCheckBox();
			box.setSelected(((Boolean) value).booleanValue());
			box.setHorizontalAlignment(JLabel.CENTER);
			return box;
		}
	};

}