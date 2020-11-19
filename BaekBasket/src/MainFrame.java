package Team;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class MainFrame extends JFrame{
	public static int index;
	public static int snack;
	public static int soup;
	public static int side;
	public static int rice;
	public static int etc;
	public static String[] basketArray = new String[50];
	public static int basketIndex=0;
	public MainFrame(Food[] food) {
		Food[] f=food;
		Font f1;
		JFrame frame = new JFrame("백바구니"); // 각종 컴포넌트 추가
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

		f1 = new Font("돋움", Font.BOLD, 50);
		JLabel label = new JLabel("★백바구니");
		label.setFont(f1);
		label.setLocation(270,50);
		label.setSize(300,50);

		JButton bSelectCook = new JButton("요리 선택하기");
		bSelectCook.setLocation(270,30);
		bSelectCook.setSize(250,50);
		bSelectCook.setBackground(Color.WHITE);

		bSelectCook.addActionListener(new ActionListener(){ // CookListFrame 생성
			public void actionPerformed(ActionEvent e){
				new CookListFrame(f);
			}
		});;

		JButton bSelectIngredient = new JButton("재료 선택하기");
		bSelectIngredient.setLocation(270,115);
		bSelectIngredient.setSize(250,50);
		bSelectIngredient.setBackground(Color.WHITE);

		bSelectIngredient.addActionListener(new ActionListener(){ // FoodSelectInterface 생성
			public void actionPerformed(ActionEvent e){
			 
			}
		});;

		JButton bBasket = new JButton("장바구니 "); 
		bBasket.setLocation(270,200);
		bBasket.setSize(250,50);
		bBasket.setBackground(Color.WHITE);
		bBasket.addActionListener(new ActionListener(){  // 시스템 종료
			public void actionPerformed(ActionEvent e){
				new ShoppingBasketFrame(basketArray);
			}
		});;

		JButton bCancel = new JButton("  종  료  ");
		bCancel.setLocation(270,285);
		bCancel.setSize(250,50);
		bCancel.setBackground(Color.WHITE);
		
		bCancel.addActionListener(new ActionListener(){  // 시스템 종료
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});;

		panel1.add(label);
		panel2.add(bSelectCook);
		panel2.add(bSelectIngredient);
		panel2.add(bBasket);
		panel2.add(bCancel);

		frame.add(panel1);
		frame.add(panel2);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Food[] f = new Food[100]; // 여기에 추가하면 자동으로 추가 됩니다. 0=간식, 1=찌개&국, 2=반찬, 3=밥, 4=기타 
		f[0]=new Food(0,	"목살스테이크카레",	"1.고기 사이의 힘줄을 끊어 주고 소금·후추로 밑간합니다. 밑간이 고르게 될 수 있도록 손으로 가볍게 고기를 두드려 줍니다.#2. 파프리카와 당근, 감자를 먹기 좋은 크기로 썰고 양파를 채썹니다. 단, 토핑 재료인 파프리카는 취향껏 바꿔도 좋은 선택 재료입니다.#3. 팬에 기름을 두르고, 목살이 진한 갈색이 될 때까지 강불에 굽습니다. 너무 익혔나 싶을 때까지 굽는 것이 포인트에요.#4. 채썬 양파를 넣고 중불로 줄인 뒤, 이후 당근과 감자, 물을 넣고 끓입니다.#5. 감자와 당근이 잘 익으면 카레 조각을 넣고 잘 젓습니다. 고형카레는 일반 마트에서 쉽게 볼 수 있는 고체형 카레입니다.#6. 마지막으로 파프리카를 넣고 섞어 줍니다.",	"돼지 목살 300g (150*2)#꽃소금 한꼬집#후춧가루 한꼬집#파프리카 각 50g씩#감자 150g (1개)#당근 70g (1/4개)#양파 200g (1개)#식용유 30ml (2큰술)#물 665ml (3컵 반)#고형카레 60g",	"돼지고기#소금#후춧가루#파프리카#감자#당근#양파#식용유#고형카레",	"https://www.youtube.com/watch?v=wDXCxlcr3hY&t=8s",	2);
		f[1]=new Food(1,	"초간단 김치찌개",	"1. 대파와 고추는 송송 썰어 준비합니다. #2. 냄비에 목살과 쌀뜨물을 넣고 충분히 끓여, 고기 육수를 우려냅니다. #3. 고기 육수가 충분히 우러나면 김치와 다진마늘을 넣습니다. #4. 국물이 끓어오르면 대파와 고추를 넣습니다. #5. 고춧가루를 넣고 잘 섞습니다. 굵은 고춧가루와 고운 고춧가루를 반씩 섞어 넣으면 더욱 좋습니다. #6. 국간장과 새우젓을 넣고 잘 저어 줍니다. ",	"1. 돼지고기 120g#2. 쌀뜨물 380ml (약 2컵)#3. 자른 김치 150g#4. 다진마늘 30g (2큰술)#5. 대파 30g #6. 청양고추 10g#7. 홍고추 10g#8. 고운 고춧가루 30g (2큰술)#9. 굵은 고춧가루 30g (2큰술)#10. 국간장 15ml (1큰술)#11. 새우젓 15g (1큰술)",	"돼지고기#쌀뜨물#김치#마늘#대파#고추#고춧가루#국간장#새우젓",	"https://www.youtube.com/watch?v=DnQ09ZZCjCs&t=245s",	1);
		f[2]=new Food(2,	"뚝배기 계란찜",	"1. 대파는 송송 썰고, 새우젓은 잘게 다져 준비합니다. #2. 믹싱볼에 달걀과 새우젓, 설탕을 넣고 잘 섞습니다. #3. 재료가 잘 섞이면 물을 넣고 다시 한 번 잘 저어줍니다. #4. 뚝배기에 달걀물을 넣고 중약불로 가열합니다. #5. 달걀이 뚝배기 바닥과 가장자리에 눌어붙지 않도록, 숟가락으로 바닥을 긁어가며 끓여줍니다. #6. 달걀이 몽글몽글하게 익으면 대파를 넣고 섞습니다. #7. 사이즈가 맞는 다른 뚝배기를 뒤집어 뚜껑처럼 덮어 약불로 익힙니다. #8. 대파, 참기름, 깨를 달걀찜 위에 고명으로 뿌려 마무리합니다.",	"1. 달걀 6개 324g#2. 새우젓 1큰술 (15g)#3. 설탕 1작은술 (5g) #4. 물 1/3컵 (60ml)#5. 참기름 1큰술 (15ml)#6. 참깨 1작은술 (5g)#7. 대파 40g",	"달걀#새우젓#설탕#참기름#참깨#대파",	"https://www.youtube.com/watch?v=_H64Kz7Mgz4",	2);
		f[3]=new Food(3,   "닭백숙",   "<닭백숙 만들기〉#1단계: 닭 손질#- 닭날개 끝부분을 잘라준다.#- 닭의 가슴살 부분을 반으로 갈라준다.#- 닭의 꽁지 부분의 기름을 제거한다.#- 닭의 내장 부분을 흐르는 물에 충분히 씻어준다.#(내장 부분에 손가락을 넣어서 내장을 제거해준다.)#2단계: 닭백숙 끓이기#- 냄비에 물 3L를 넣고 손질한 닭을 넣어준다.#- 대파 2뿌리, 양파 2개를 넣어준다.#- 마늘 10알, 생강 1톨을 넣어준다.#- 약 30분~45분간 삶아준다. (냄비의 크기와 화력에 따라 조리시간은 가감한다.)#- 삶는 중간에 닭을 뒤집어준다.#- 완성 접시에 삶은 닭을 담는다.#- 완성된 육수는 체에 밭쳐 채소를 걸러낸다.#- 부추와 대파는 10cm 길이로 잘라 육수에 데쳐낸다.#- 데쳐낸 부추를 완성 접시에 담은 닭 위에 올려준다.#- 뜨거운 육수를 닭백숙에 뿌려준다.#- 양념장 또는 소금, 후추를 곁들인다.#〈양념장 만들기〉#1. 볼에 굵은고춧가루를 담고 뜨거운 물을 넣고 섞어준다.(이때 고춧가루와 뜨거운 물의 비율은 1:1로한다.)#2. 종지에 불린 고춧가루 1큰술을 넣어준다.#3. 다진마늘 1/2작은술을 넣어준다.#4. 연겨자 1/3작은술을 넣어준다.#5. 다진대파 1/2작은술을 넣어준다.#6. 진간장 2큰술을 넣어준다.#7. 식초 1큰술을 넣어준다.#8. 설탕 1/2작은술을 넣어준다.","닭 1마리 #대파 2뿌리#부추 1줌#마늘 10개#생강 1톨#양파 2개#물 3L#소금#후추#*양념장*#굵은고춧가루 1큰술(15g)#뜨거운물(육수) 1큰술(15ml)#다진 마늘 1/2작은술(3g)#다진 대파 1/2작은술(3g)#연겨자 1/3작은술(2g)#진간장 2큰술(30ml)#식초 1큰술(15ml)#설탕 1/2작은술(3g)","닭#대파#부추#마늘#생강#양파#소금#후추#*양념장*#굵은고춧가루#다진 마늘#다진 대파#연겨자#진간장#식초#설탕","https://www.youtube.com/watch?v=_H64Kz7Mgz4",   1);
		f[4]=new Food(4,   "김치밥",   "1단계: 김치볶음 만들기#- 불을 끈 상태에서 프라이팬에 식용유 1큰술을 넣어준다.#- 대파 1/2컵을 넣어준다.#- 불을 켜고 대파를 튀기듯이 볶아준다.#- 자른 김치 1/3컵을 넣고 볶아준다.#- 진간장 1큰술을 넣어준다. (이때 달궈져 있는 상태에서 진간장을 넣어 기름에 튀겨지면서 눌게 한다.)#- 황설탕 1작은술을 눌린 기름 위에 넣어준다.#- 재료를 고루 섞어 볶아준다.#- 고운 고춧가루 1큰술을 넣고 섞어준다. (온도가 높으면 고운고춧가루가 탈 수 있으니 주의한다.)#2단계: 김치밥 만들기#- 믹싱 볼에 김치 베이스 전량, 밥 200g을 넣고 비벼준다.#- 불을 끈 상태에서 프라이팬에 비빈 김치밥을 넣고 주걱을 이용해서 넓게 펴준다.#- 약불로 불을 켜고 모짜렐라 치즈 1/2컵을 올려준다.  (옥수수콘을 넣으면 식감을 더할 수 있다.)#- 뚜껑을 덮고 약 3분간 치즈를 녹여준다.#- 완성 접시에 김치밥을 반으로 접어 담아준다.#- 옥수수콘 1/2컵, 김가루 1/2컵, 깨 1꼬집을 곁들인다.","식용유 1큰술(12ml)#김치 1/3컵(80g)#대파 1/2컵(15g)#고운고춧가루 1큰술(5g)#진간장 1큰술(10ml)#황설탕 1작은술(3g)#밥 1공기(200g)#김가루 1/2컵(3g)#모짜렐라 1/2컵(50g)#옥수수콘 1/2컵(30g)#깨 1꼬집(1g)",   "식용유#김치#대파#고춧가루#진간장#황설탕#밥#김가루#모짜렐라#옥수수콘 #깨","https://www.youtube.com/watch?v=R6IT_f0XPT8",   3);
		// f[5]~f[8]은 테스트용으로 그냥 추가함
		f[5]=new Food(5,   "라면땅",   "1단계: 김치볶음 만들기#- 불을 끈 상태에서 프라이팬에 식용유 1큰술을 넣어준다.#- 대파 1/2컵을 넣어준다.#- 불을 켜고 대파를 튀기듯이 볶아준다.#- 자른 김치 1/3컵을 넣고 볶아준다.#- 진간장 1큰술을 넣어준다. (이때 달궈져 있는 상태에서 진간장을 넣어 기름에 튀겨지면서 눌게 한다.)#- 황설탕 1작은술을 눌린 기름 위에 넣어준다.#- 재료를 고루 섞어 볶아준다.#- 고운 고춧가루 1큰술을 넣고 섞어준다. (온도가 높으면 고운고춧가루가 탈 수 있으니 주의한다.)#2단계: 김치밥 만들기#- 믹싱 볼에 김치 베이스 전량, 밥 200g을 넣고 비벼준다.#- 불을 끈 상태에서 프라이팬에 비빈 김치밥을 넣고 주걱을 이용해서 넓게 펴준다.#- 약불로 불을 켜고 모짜렐라 치즈 1/2컵을 올려준다.  (옥수수콘을 넣으면 식감을 더할 수 있다.)#- 뚜껑을 덮고 약 3분간 치즈를 녹여준다.#- 완성 접시에 김치밥을 반으로 접어 담아준다.#- 옥수수콘 1/2컵, 김가루 1/2컵, 깨 1꼬집을 곁들인다.","식용유 1큰술(12ml)#김치 1/3컵(80g)#대파 1/2컵(15g)#고운고춧가루 1큰술(5g)#진간장 1큰술(10ml)#황설탕 1작은술(3g)#밥 1공기(200g)#김가루 1/2컵(3g)#모짜렐라 1/2컵(50g)#옥수수콘 1/2컵(30g)#깨 1꼬집(1g)",   "식용유#김치#대파#고춧가루#진간장#황설탕#밥#김가루#모짜렐라#옥수수콘 #깨","https://www.youtube.com/watch?v=R6IT_f0XPT8",   0);
		f[6]=new Food(6,   "우동",   "1단계: 김치볶음 만들기#- 불을 끈 상태에서 프라이팬에 식용유 1큰술을 넣어준다.#- 대파 1/2컵을 넣어준다.#- 불을 켜고 대파를 튀기듯이 볶아준다.#- 자른 김치 1/3컵을 넣고 볶아준다.#- 진간장 1큰술을 넣어준다. (이때 달궈져 있는 상태에서 진간장을 넣어 기름에 튀겨지면서 눌게 한다.)#- 황설탕 1작은술을 눌린 기름 위에 넣어준다.#- 재료를 고루 섞어 볶아준다.#- 고운 고춧가루 1큰술을 넣고 섞어준다. (온도가 높으면 고운고춧가루가 탈 수 있으니 주의한다.)#2단계: 김치밥 만들기#- 믹싱 볼에 김치 베이스 전량, 밥 200g을 넣고 비벼준다.#- 불을 끈 상태에서 프라이팬에 비빈 김치밥을 넣고 주걱을 이용해서 넓게 펴준다.#- 약불로 불을 켜고 모짜렐라 치즈 1/2컵을 올려준다.  (옥수수콘을 넣으면 식감을 더할 수 있다.)#- 뚜껑을 덮고 약 3분간 치즈를 녹여준다.#- 완성 접시에 김치밥을 반으로 접어 담아준다.#- 옥수수콘 1/2컵, 김가루 1/2컵, 깨 1꼬집을 곁들인다.","식용유 1큰술(12ml)#김치 1/3컵(80g)#대파 1/2컵(15g)#고운고춧가루 1큰술(5g)#진간장 1큰술(10ml)#황설탕 1작은술(3g)#밥 1공기(200g)#김가루 1/2컵(3g)#모짜렐라 1/2컵(50g)#옥수수콘 1/2컵(30g)#깨 1꼬집(1g)",   "식용유#김치#대파#고춧가루#진간장#황설탕#밥#김가루#모짜렐라#옥수수콘 #깨","https://www.youtube.com/watch?v=R6IT_f0XPT8",   4);
		f[7]=new Food(7,   "피카츄",   "1단계: 김치볶음 만들기#- 불을 끈 상태에서 프라이팬에 식용유 1큰술을 넣어준다.#- 대파 1/2컵을 넣어준다.#- 불을 켜고 대파를 튀기듯이 볶아준다.#- 자른 김치 1/3컵을 넣고 볶아준다.#- 진간장 1큰술을 넣어준다. (이때 달궈져 있는 상태에서 진간장을 넣어 기름에 튀겨지면서 눌게 한다.)#- 황설탕 1작은술을 눌린 기름 위에 넣어준다.#- 재료를 고루 섞어 볶아준다.#- 고운 고춧가루 1큰술을 넣고 섞어준다. (온도가 높으면 고운고춧가루가 탈 수 있으니 주의한다.)#2단계: 김치밥 만들기#- 믹싱 볼에 김치 베이스 전량, 밥 200g을 넣고 비벼준다.#- 불을 끈 상태에서 프라이팬에 비빈 김치밥을 넣고 주걱을 이용해서 넓게 펴준다.#- 약불로 불을 켜고 모짜렐라 치즈 1/2컵을 올려준다.  (옥수수콘을 넣으면 식감을 더할 수 있다.)#- 뚜껑을 덮고 약 3분간 치즈를 녹여준다.#- 완성 접시에 김치밥을 반으로 접어 담아준다.#- 옥수수콘 1/2컵, 김가루 1/2컵, 깨 1꼬집을 곁들인다.","식용유 1큰술(12ml)#김치 1/3컵(80g)#대파 1/2컵(15g)#고운고춧가루 1큰술(5g)#진간장 1큰술(10ml)#황설탕 1작은술(3g)#밥 1공기(200g)#김가루 1/2컵(3g)#모짜렐라 1/2컵(50g)#옥수수콘 1/2컵(30g)#깨 1꼬집(1g)",   "식용유#김치#대파#고춧가루#진간장#황설탕#밥#김가루#모짜렐라#옥수수콘 #깨","https://www.youtube.com/watch?v=R6IT_f0XPT8",   0);
		f[8]=new Food(8,   "한우",   "1단계: 김치볶음 만들기#- 불을 끈 상태에서 프라이팬에 식용유 1큰술을 넣어준다.#- 대파 1/2컵을 넣어준다.#- 불을 켜고 대파를 튀기듯이 볶아준다.#- 자른 김치 1/3컵을 넣고 볶아준다.#- 진간장 1큰술을 넣어준다. (이때 달궈져 있는 상태에서 진간장을 넣어 기름에 튀겨지면서 눌게 한다.)#- 황설탕 1작은술을 눌린 기름 위에 넣어준다.#- 재료를 고루 섞어 볶아준다.#- 고운 고춧가루 1큰술을 넣고 섞어준다. (온도가 높으면 고운고춧가루가 탈 수 있으니 주의한다.)#2단계: 김치밥 만들기#- 믹싱 볼에 김치 베이스 전량, 밥 200g을 넣고 비벼준다.#- 불을 끈 상태에서 프라이팬에 비빈 김치밥을 넣고 주걱을 이용해서 넓게 펴준다.#- 약불로 불을 켜고 모짜렐라 치즈 1/2컵을 올려준다.  (옥수수콘을 넣으면 식감을 더할 수 있다.)#- 뚜껑을 덮고 약 3분간 치즈를 녹여준다.#- 완성 접시에 김치밥을 반으로 접어 담아준다.#- 옥수수콘 1/2컵, 김가루 1/2컵, 깨 1꼬집을 곁들인다.","식용유 1큰술(12ml)#김치 1/3컵(80g)#대파 1/2컵(15g)#고운고춧가루 1큰술(5g)#진간장 1큰술(10ml)#황설탕 1작은술(3g)#밥 1공기(200g)#김가루 1/2컵(3g)#모짜렐라 1/2컵(50g)#옥수수콘 1/2컵(30g)#깨 1꼬집(1g)",   "식용유#김치#대파#고춧가루#진간장#황설탕#밥#김가루#모짜렐라#옥수수콘 #깨","https://www.youtube.com/watch?v=R6IT_f0XPT8",   0);
		
		for(int i=0;i<f.length;i++) // 카테고리별 분류작업
			if(f[i]!=null) {
				index++;
				if(f[i].categoryNo==0)
					snack++;
				else if(f[i].categoryNo==1)
					soup++;
				else if(f[i].categoryNo==2)
					side++;
				else if(f[i].categoryNo==3)
					rice++;
				else if(f[i].categoryNo==4)
					etc++;
			}
			else
				break; // 모두 검색하고 닫기
		MainFrame mainFrame = new MainFrame(f);
	}
}
