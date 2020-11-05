import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class FoodSelectInterface extends JFrame {
	private Image backgroundImage = new ImageIcon("src/image/image.png").getImage();
	private Object[] column = { " ", "���" };
	private Object[][] raw = { { false, "���1" }, { false, "���2" }, { false, "���3" }, { false, "���4" },
			{ false, "���5" }, { false, "���6" }, { false, "���7" }, { false, "���8" }, { false, "���9" }, { false, "���10" },
			{ false, "���11" }, { false, "���12" }, { false, "���13" }, { false, "���14" }, { false, "���15" },
			{ false, "���16" }, { false, "���17" }, { false, "���18" }, { false, "���19" }, { false, "���20" },
			{ false, "���21" }, { false, "���22" }, { false, "���23" }, { false, "���24" }, { false, "���25" },
			{ false, "���26" }, { false, "���27" }, { false, "���28" }, { false, "���29" }, { false, "���30" },
			{ false, "���31" }, { false, "���32" }, { false, "���33" }, { false, "���34" }, { false, "���35" },
			{ false, "���36" }, { false, "���37" }, { false, "���38" }, { false, "���39" }, { false, "���40" },
			{ false, "���41" }, { false, "���42" }, { false, "���43" }, { false, "���44" }, { false, "���45" },
			{ false, "���46" },

	};
	private String[] avi = { "����1" , "����2", "����3", "����4", "����5", "����6", "����7",
			 "����8" , "����9", "����10", "����11", "����12", "����13", "����14",
			 "����15" , "����16", "����17", "����18", "����19", "����20", "����21",
			 "����22" , "����23", "����24", "����25", "����26", "����27", "����28"
			};

	public FoodSelectInterface() {
		// ���� ������
		JFrame frame = new JFrame();
		// ���� �г�
		JPanel panel = new JPanel() {
			// ����̹����� �� ������ �׸��� ���� paintComponent()�޼ҵ�
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

		// �˻���ư
		JButton btn1 = new JButton("�˻�");
		btn1.setLayout(null);
		btn1.setSize(60, 20);
		btn1.setLocation(660, 230);
		btn1.setBackground(Color.white);
		panel.add(btn1);

		// �ڷΰ��� ��ư
		JButton btn2 = new JButton("�ڷΰ���");
		btn2.setLayout(null);
		btn2.setSize(86, 20);
		btn2.setLocation(635, 500);
		btn2.setBackground(Color.white);
		panel.add(btn2);

		// ��ἱ�� ���̺� ����
		DefaultTableModel dtm = new DefaultTableModel(raw, column);
		JTable table = new JTable(dtm);
		table.setBounds(20, 20, 700, 200);

		table.getColumn(" ").setCellRenderer(dcr);
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn(" ").setCellEditor(new DefaultCellEditor(box));

		// ��ἱ�� ���̺� ��ũ�� �ޱ�
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(table.getX(), table.getY(), table.getWidth(), table.getHeight());
		panel.add(scrollPane, "Center");

		// ���� ���̺� ����Ʈ
		JList list = new JList(avi);
		list.setBounds(20, 290, 700, 200);
		JScrollPane sp = new JScrollPane(list);
		sp.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
		panel.add(sp, "Center");
		
		
		frame.setTitle("��ٱ���");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new FoodSelectInterface();

	}

	// ��ἱ�� ���̺� ���� üũ�ڽ� ����
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