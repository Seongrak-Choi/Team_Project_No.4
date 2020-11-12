import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CookListFrame extends JFrame {
	public CookListFrame() {

		Food[] f = new Food[100];
		f[0] = new Food(1, "��콺����ũī�� ",
				"1.��� ������ ������ ���� �ְ� �ұݡ����߷� �ذ��մϴ�. �ذ��� ���� �� �� �ֵ��� ������ ������ ��⸦ �ε�� �ݴϴ�.#2. ������ī�� ���, ���ڸ� �Ա� ���� ũ��� ��� ���ĸ� ä��ϴ�. ��, ���� ����� ������ī�� ���ⲯ �ٲ㵵 ���� ���� ����Դϴ�.#3. �ҿ� �⸧�� �θ���, ����� ���� ������ �� ������ ���ҿ� �����ϴ�. �ʹ� ������ ���� ������ ���� ���� ����Ʈ����.#4. ä�� ���ĸ� �ְ� �ߺҷ� ���� ��, ���� ��ٰ� ����, ���� �ְ� ���Դϴ�.#5. ���ڿ� ����� �� ������ ī�� ������ �ְ� �� �����ϴ�. ����ī���� �Ϲ� ��Ʈ���� ���� �� �� �ִ� ��ü�� ī���Դϴ�.#6. ���������� ������ī�� �ְ� ���� �ݴϴ�.",
				"���� ��� 300g (150*2)#�ɼұ� �Ѳ���#���尡�� �Ѳ���#������ī �� 50g��#���� 150g (1��)#��� 70g (1/4��)#���� 200g (1��)#�Ŀ��� 30ml (2ū��)#�� 665ml (3�� ��)#����ī�� 60g",
				"�������#�ұ�#���尡��#������ī#����#���#����#�Ŀ���#����ī��", "https://www.youtube.com/watch?v=wDXCxlcr3hY&t=8s", 2);
		f[1] = new Food(2, "�ʰ��� ��ġ�",
				"1. ���Ŀ� ���ߴ� �ۼ� ��� �غ��մϴ�. #2. ���� ���� �Ҷ߹��� �ְ� ����� ����, ��� ������ ������ϴ�. #3. ��� ������ ����� �췯���� ��ġ�� ���������� �ֽ��ϴ�. #4. ������ ��������� ���Ŀ� ���߸� �ֽ��ϴ�. #5. ���尡�縦 �ְ� �� �����ϴ�. ���� ���尡��� ��� ���尡�縦 �ݾ� ���� ������ ���� �����ϴ�. #6. ������� �������� �ְ� �� ���� �ݴϴ�. ",
				"1. ������� 120g#2. �Ҷ߹� 380ml (�� 2��)#3. �ڸ� ��ġ 150g#4. �������� 30g (2ū��)#5. ���� 30g #6. û����� 10g#7. ȫ���� 10g#8. ��� ���尡�� 30g (2ū��)#9. ���� ���尡�� 30g (2ū��)#10. ������ 15ml (1ū��)#11. ������ 15g (1ū��)",
				"�������#�Ҷ߹�#��ġ#����#����#����#���尡��#������#������", "https://www.youtube.com/watch?v=DnQ09ZZCjCs&t=245s", 1);
		f[2] = new Food(3, "�ҹ�� �����",
				"1. ���Ĵ� �ۼ� ���, �������� �߰� ���� �غ��մϴ�. #2. �ͽ̺��� �ް��� ������, ������ �ְ� �� �����ϴ�. #3. ��ᰡ �� ���̸� ���� �ְ� �ٽ� �� �� �� �����ݴϴ�. #4. �ҹ�⿡ �ް����� �ְ� �߾�ҷ� �����մϴ�. #5. �ް��� �ҹ�� �ٴڰ� �����ڸ��� ������� �ʵ���, ���������� �ٴ��� �ܾ�� �����ݴϴ�. #6. �ް��� ���۸����ϰ� ������ ���ĸ� �ְ� �����ϴ�. #7. ����� �´� �ٸ� �ҹ�⸦ ������ �Ѳ�ó�� ���� ��ҷ� �����ϴ�. #8. ����, ���⸧, ���� �ް��� ���� ������� �ѷ� �������մϴ�.",
				"1. �ް� 6�� 324g#2. ������ 1ū�� (15g)#3. ���� 1������ (5g) #4. �� 1/3�� (60ml)#5. ���⸧ 1ū�� (15ml)#6. ���� 1������ (5g)#7. ���� 40g",
				"�ް�,������,����,���⸧,����,����", "https://www.youtube.com/watch?v=_H64Kz7Mgz4", 2);

		JFrame frame = new JFrame("�丮 ����Ʈ ȭ��");
		frame.setLocation(0, 0);
		frame.setSize(800, 600);
		frame.setLayout(null);

		JPanel pFrame = new JPanel();
		pFrame.setLocation(0, 0);
		pFrame.setSize(800, 600);
		pFrame.setLayout(null);
		pFrame.setBackground(Color.WHITE);

		JButton bNightmeal = new JButton("�߽�&����");
		bNightmeal.setLocation(50, 20);
		bNightmeal.setSize(100, 30);
		pFrame.add(bNightmeal);
		bNightmeal.setBackground(Color.WHITE);

		JButton bSnack = new JButton("����");
		bSnack.setLocation(150, 20);
		bSnack.setSize(75, 30);
		pFrame.add(bSnack);
		bSnack.setBackground(Color.WHITE);

		JButton bKorean = new JButton("�ѽ�");
		bKorean.setLocation(225, 20);
		bKorean.setSize(75, 30);
		pFrame.add(bKorean);
		bKorean.setBackground(Color.WHITE);

		JButton bChinese = new JButton("�߽�");
		bChinese.setLocation(300, 20);
		bChinese.setSize(75, 30);
		pFrame.add(bChinese);
		bChinese.setBackground(Color.WHITE);

		JButton bWestern = new JButton("���");
		bWestern.setLocation(375, 20);
		bWestern.setSize(75, 30);
		pFrame.add(bWestern);
		bWestern.setBackground(Color.WHITE);

		JButton bSide = new JButton("����");
		bSide.setLocation(450, 20);
		bSide.setSize(75, 30);
		pFrame.add(bSide);
		bSide.setBackground(Color.WHITE);

		JButton bCanCook = new JButton("���� �� �ִ� �丮 Ȯ��");
		bCanCook.setLocation(380, 520);
		bCanCook.setSize(170, 30);
		pFrame.add(bCanCook);
		bCanCook.setBackground(Color.WHITE);

		JButton bBarsket = new JButton("��ٱ���");
		bBarsket.setLocation(550, 520);
		bBarsket.setSize(90, 30);
		pFrame.add(bBarsket);
		bBarsket.setBackground(Color.WHITE);

		JButton bCancel = new JButton("����");
		bCancel.setLocation(640, 520);
		bCancel.setSize(75, 30);
		pFrame.add(bCancel);
		bCancel.setBackground(Color.WHITE);

		JTextField tSearch = new JTextField("search");
		tSearch.setLocation(550, 20);
		tSearch.setSize(200, 30);
		pFrame.add(tSearch);
		tSearch.setBorder(new LineBorder(Color.BLACK));

		JPanel pCookList = new JPanel();
		pCookList.setLocation(50, 75);
		pCookList.setSize(665, 425);
		pCookList.setLayout(null);

		String[] cookList = { f[0].getName(), f[1].getName(), f[2].getName() };
		JList lCookList = new JList(cookList);
		lCookList.setLocation(0, 0);
		lCookList.setSize(665, 425);
		lCookList.setBorder(new LineBorder(Color.BLACK));
		lCookList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent evt) {
				RecipeInterface rI = new RecipeInterface(f[lCookList.getSelectedIndex()]);

			}
		});

		pCookList.add(lCookList);

		frame.add(pCookList);
		frame.add(pFrame);

		frame.setVisible(true);
	}

}