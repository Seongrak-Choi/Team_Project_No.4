import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class MainFrame extends JFrame{
	public MainFrame() {
		Font f1;
		JFrame frame = new JFrame("��ٱ���");
		frame.setLocation(0,0);
		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setLocation(0,0);
		panel1.setSize(800,200);
		panel1.setLayout(null);
		panel1.setBackground(Color.ORANGE);

		JPanel panel2 = new JPanel();
		panel2.setLocation(0,200);
		panel2.setSize(800,400);
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);

		f1 = new Font("����", Font.BOLD, 50);
		JLabel label = new JLabel("�ڹ�ٱ���");
		label.setFont(f1);
		label.setLocation(270,50);
		label.setSize(300,50);

		JButton bSelectCook = new JButton("�丮 �����ϱ�");
		bSelectCook.setLocation(270,50);
		bSelectCook.setSize(250,50);
		bSelectCook.setBackground(Color.WHITE);
		
		bSelectCook.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				JButton btn = (JButton) e.getSource();
				if(btn.getText().equals("�丮 �����ϱ�")) {
					CookListFrame cookListFrame = new CookListFrame();
				}
			}
		});;

		JButton bSelectIngredient = new JButton("��� �����ϱ�");
		bSelectIngredient.setLocation(270,150);
		bSelectIngredient.setSize(250,50);
		bSelectIngredient.setBackground(Color.WHITE);

		JButton bCancel = new JButton("  ��  ��  ");
		bCancel.setLocation(270,250);
		bCancel.setSize(250,50);
		bCancel.setBackground(Color.WHITE);
		
		panel1.add(label);
		panel2.add(bSelectCook);
		panel2.add(bSelectIngredient);
		panel2.add(bCancel);

		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Food[] f = new Food[100];
		f[0]=new Food(1,	"��콺����ũī�� ",	"1.��� ������ ������ ���� �ְ� �ұݡ����߷� �ذ��մϴ�. �ذ��� ���� �� �� �ֵ��� ������ ������ ��⸦ �ε�� �ݴϴ�.#2. ������ī�� ���, ���ڸ� �Ա� ���� ũ��� ��� ���ĸ� ä��ϴ�. ��, ���� ����� ������ī�� ���ⲯ �ٲ㵵 ���� ���� ����Դϴ�.#3. �ҿ� �⸧�� �θ���, ����� ���� ������ �� ������ ���ҿ� �����ϴ�. �ʹ� ������ ���� ������ ���� ���� ����Ʈ����.#4. ä�� ���ĸ� �ְ� �ߺҷ� ���� ��, ���� ��ٰ� ����, ���� �ְ� ���Դϴ�.#5. ���ڿ� ����� �� ������ ī�� ������ �ְ� �� �����ϴ�. ����ī���� �Ϲ� ��Ʈ���� ���� �� �� �ִ� ��ü�� ī���Դϴ�.#6. ���������� ������ī�� �ְ� ���� �ݴϴ�.",	"���� ��� 300g (150*2)#�ɼұ� �Ѳ���#���尡�� �Ѳ���#������ī �� 50g��#���� 150g (1��)#��� 70g (1/4��)#���� 200g (1��)#�Ŀ��� 30ml (2ū��)#�� 665ml (3�� ��)#����ī�� 60g",	"�������#�ұ�#���尡��#������ī#����#���#����#�Ŀ���#����ī��",	"https://www.youtube.com/watch?v=wDXCxlcr3hY&t=8s",	2);
		f[1]=new Food(2,	"�ʰ��� ��ġ�",	"1. ���Ŀ� ���ߴ� �ۼ� ��� �غ��մϴ�. #2. ���� ���� �Ҷ߹��� �ְ� ����� ����, ��� ������ ������ϴ�. #3. ��� ������ ����� �췯���� ��ġ�� ���������� �ֽ��ϴ�. #4. ������ ��������� ���Ŀ� ���߸� �ֽ��ϴ�. #5. ���尡�縦 �ְ� �� �����ϴ�. ���� ���尡��� ��� ���尡�縦 �ݾ� ���� ������ ���� �����ϴ�. #6. ������� �������� �ְ� �� ���� �ݴϴ�. ",	"1. ������� 120g#2. �Ҷ߹� 380ml (�� 2��)#3. �ڸ� ��ġ 150g#4. �������� 30g (2ū��)#5. ���� 30g #6. û����� 10g#7. ȫ���� 10g#8. ��� ���尡�� 30g (2ū��)#9. ���� ���尡�� 30g (2ū��)#10. ������ 15ml (1ū��)#11. ������ 15g (1ū��)",	"�������#�Ҷ߹�#��ġ#����#����#����#���尡��#������#������",	"https://www.youtube.com/watch?v=DnQ09ZZCjCs&t=245s",	1);
		f[2]=new Food(3,	"�ҹ�� �����",	"1. ���Ĵ� �ۼ� ���, �������� �߰� ���� �غ��մϴ�. #2. �ͽ̺��� �ް��� ������, ������ �ְ� �� �����ϴ�. #3. ��ᰡ �� ���̸� ���� �ְ� �ٽ� �� �� �� �����ݴϴ�. #4. �ҹ�⿡ �ް����� �ְ� �߾�ҷ� �����մϴ�. #5. �ް��� �ҹ�� �ٴڰ� �����ڸ��� ������� �ʵ���, ���������� �ٴ��� �ܾ�� �����ݴϴ�. #6. �ް��� ���۸����ϰ� ������ ���ĸ� �ְ� �����ϴ�. #7. ����� �´� �ٸ� �ҹ�⸦ ������ �Ѳ�ó�� ���� ��ҷ� �����ϴ�. #8. ����, ���⸧, ���� �ް��� ���� ������� �ѷ� �������մϴ�.",	"1. �ް� 6�� 324g#2. ������ 1ū�� (15g)#3. ���� 1������ (5g) #4. �� 1/3�� (60ml)#5. ���⸧ 1ū�� (15ml)#6. ���� 1������ (5g)#7. ���� 40g",	"�ް�,������,����,���⸧,����,����",	"https://www.youtube.com/watch?v=_H64Kz7Mgz4",	2);
		
		new RecipeInterface(f[0].name,f[0].recipe,f[0].ingredient,f[0].quantitative);
		MainFrame mainFrame = new MainFrame();
	}
}
