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
		f[0] = new Food(1, "목살스테이크카레 ",
				"1.고기 사이의 힘줄을 끊어 주고 소금·후추로 밑간합니다. 밑간이 고르게 될 수 있도록 손으로 가볍게 고기를 두드려 줍니다.#2. 파프리카와 당근, 감자를 먹기 좋은 크기로 썰고 양파를 채썹니다. 단, 토핑 재료인 파프리카는 취향껏 바꿔도 좋은 선택 재료입니다.#3. 팬에 기름을 두르고, 목살이 진한 갈색이 될 때까지 강불에 굽습니다. 너무 익혔나 싶을 때까지 굽는 것이 포인트에요.#4. 채썬 양파를 넣고 중불로 줄인 뒤, 이후 당근과 감자, 물을 넣고 끓입니다.#5. 감자와 당근이 잘 익으면 카레 조각을 넣고 잘 젓습니다. 고형카레는 일반 마트에서 쉽게 볼 수 있는 고체형 카레입니다.#6. 마지막으로 파프리카를 넣고 섞어 줍니다.",
				"돼지 목살 300g (150*2)#꽃소금 한꼬집#후춧가루 한꼬집#파프리카 각 50g씩#감자 150g (1개)#당근 70g (1/4개)#양파 200g (1개)#식용유 30ml (2큰술)#물 665ml (3컵 반)#고형카레 60g",
				"돼지고기#소금#후춧가루#파프리카#감자#당근#양파#식용유#고형카레", "https://www.youtube.com/watch?v=wDXCxlcr3hY&t=8s", 2);
		f[1] = new Food(2, "초간단 김치찌개",
				"1. 대파와 고추는 송송 썰어 준비합니다. #2. 냄비에 목살과 쌀뜨물을 넣고 충분히 끓여, 고기 육수를 우려냅니다. #3. 고기 육수가 충분히 우러나면 김치와 다진마늘을 넣습니다. #4. 국물이 끓어오르면 대파와 고추를 넣습니다. #5. 고춧가루를 넣고 잘 섞습니다. 굵은 고춧가루와 고운 고춧가루를 반씩 섞어 넣으면 더욱 좋습니다. #6. 국간장과 새우젓을 넣고 잘 저어 줍니다. ",
				"1. 돼지고기 120g#2. 쌀뜨물 380ml (약 2컵)#3. 자른 김치 150g#4. 다진마늘 30g (2큰술)#5. 대파 30g #6. 청양고추 10g#7. 홍고추 10g#8. 고운 고춧가루 30g (2큰술)#9. 굵은 고춧가루 30g (2큰술)#10. 국간장 15ml (1큰술)#11. 새우젓 15g (1큰술)",
				"돼지고기#쌀뜨물#김치#마늘#대파#고추#고춧가루#국간장#새우젓", "https://www.youtube.com/watch?v=DnQ09ZZCjCs&t=245s", 1);
		f[2] = new Food(3, "뚝배기 계란찜",
				"1. 대파는 송송 썰고, 새우젓은 잘게 다져 준비합니다. #2. 믹싱볼에 달걀과 새우젓, 설탕을 넣고 잘 섞습니다. #3. 재료가 잘 섞이면 물을 넣고 다시 한 번 잘 저어줍니다. #4. 뚝배기에 달걀물을 넣고 중약불로 가열합니다. #5. 달걀이 뚝배기 바닥과 가장자리에 눌어붙지 않도록, 숟가락으로 바닥을 긁어가며 끓여줍니다. #6. 달걀이 몽글몽글하게 익으면 대파를 넣고 섞습니다. #7. 사이즈가 맞는 다른 뚝배기를 뒤집어 뚜껑처럼 덮어 약불로 익힙니다. #8. 대파, 참기름, 깨를 달걀찜 위에 고명으로 뿌려 마무리합니다.",
				"1. 달걀 6개 324g#2. 새우젓 1큰술 (15g)#3. 설탕 1작은술 (5g) #4. 물 1/3컵 (60ml)#5. 참기름 1큰술 (15ml)#6. 참깨 1작은술 (5g)#7. 대파 40g",
				"달걀,새우젓,설탕,참기름,참깨,대파", "https://www.youtube.com/watch?v=_H64Kz7Mgz4", 2);

		JFrame frame = new JFrame("요리 리스트 화면");
		frame.setLocation(0, 0);
		frame.setSize(800, 600);
		frame.setLayout(null);

		JPanel pFrame = new JPanel();
		pFrame.setLocation(0, 0);
		pFrame.setSize(800, 600);
		pFrame.setLayout(null);
		pFrame.setBackground(Color.WHITE);

		JButton bNightmeal = new JButton("야식&안주");
		bNightmeal.setLocation(50, 20);
		bNightmeal.setSize(100, 30);
		pFrame.add(bNightmeal);
		bNightmeal.setBackground(Color.WHITE);

		JButton bSnack = new JButton("간식");
		bSnack.setLocation(150, 20);
		bSnack.setSize(75, 30);
		pFrame.add(bSnack);
		bSnack.setBackground(Color.WHITE);

		JButton bKorean = new JButton("한식");
		bKorean.setLocation(225, 20);
		bKorean.setSize(75, 30);
		pFrame.add(bKorean);
		bKorean.setBackground(Color.WHITE);

		JButton bChinese = new JButton("중식");
		bChinese.setLocation(300, 20);
		bChinese.setSize(75, 30);
		pFrame.add(bChinese);
		bChinese.setBackground(Color.WHITE);

		JButton bWestern = new JButton("양식");
		bWestern.setLocation(375, 20);
		bWestern.setSize(75, 30);
		pFrame.add(bWestern);
		bWestern.setBackground(Color.WHITE);

		JButton bSide = new JButton("반찬");
		bSide.setLocation(450, 20);
		bSide.setSize(75, 30);
		pFrame.add(bSide);
		bSide.setBackground(Color.WHITE);

		JButton bCanCook = new JButton("만들 수 있는 요리 확인");
		bCanCook.setLocation(380, 520);
		bCanCook.setSize(170, 30);
		pFrame.add(bCanCook);
		bCanCook.setBackground(Color.WHITE);

		JButton bBarsket = new JButton("장바구니");
		bBarsket.setLocation(550, 520);
		bBarsket.setSize(90, 30);
		pFrame.add(bBarsket);
		bBarsket.setBackground(Color.WHITE);

		JButton bCancel = new JButton("종료");
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