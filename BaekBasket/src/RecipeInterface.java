import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class RecipeInterface extends JFrame{
	
	

	
	public RecipeInterface(Food food) {
		setTitle("백바구니");
		setSize(800,600);
		setVisible(true);
		//setResizable(false); //프레임 크기 고정
		Container c = getContentPane();
		c.setLayout(null);
		Food chosenFood = food;
		c.setBackground(Color.white);
		

		String[] recipeArray =chosenFood.getRecipe().split("#");
		String[] ingredientArray=chosenFood.getIngredient().split("#");
		String[] quantitativeArray=chosenFood.getQuanti().split("#");
		JLabel foodName = new JLabel(chosenFood.getName()); //요리의 이름을 출력하는 Label
		foodName.setLocation(20,1);
		foodName.setSize(100,30);
		c.add(foodName);
		
		
		JButton recommendBtn = new JButton("요리 추천"); //요리추천 버튼
		recommendBtn.setSize(100,30);
		recommendBtn.setLocation(470, 520);
		recommendBtn.setBackground(Color.WHITE);
		c.add(recommendBtn);
		
		JButton reportBtn = new JButton("신 고"); //신고 버튼
		reportBtn.setSize(80,30);
		reportBtn.setLocation(580, 520);
		reportBtn.setBackground(Color.WHITE);
			
		reportBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
					ReportFrame report = new ReportFrame(food);
			}
		});;
		c.add(reportBtn);
		
		
		JButton backBtn = new JButton("뒤로 가기"); //뒤로가기 버튼
		backBtn.setSize(100,30);
		backBtn.setLocation(670, 520);
		backBtn.setBackground(Color.WHITE);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});;
		c.add(backBtn);
		
		
		JTextArea quantitativeList = new JTextArea(); //레시피가 담길 JTextArea
		quantitativeList.setLineWrap(true); // size를 벗어날 경우 자동 줄바꿈
		quantitativeList.setEditable(false); // 사용자가 textarea를 수정 할 수 없게 설정.
		for(int i=0;i<quantitativeArray.length;i++)  //recipeArray 길이 만큼 JTextArea에 넣어준다.
			quantitativeList.append(quantitativeArray[i]+"\n\n");
	
		JScrollPane quantitativeScrollPane = new JScrollPane(quantitativeList); // 스크롤바가 달려있는 JScrollPane에 JTextArea recipeList를 달아준다.
		quantitativeScrollPane.setLocation(520,30); // JScrollPane sp의 위치를 설정한다.
		quantitativeScrollPane.setSize(250,240); // JScrollPane sp의 크기를 설정한다.
		c.add(quantitativeScrollPane);
		
					
		JTextArea recipeList = new JTextArea(); //레시피가 담길 JTextArea
		recipeList.setLineWrap(true); // size를 벗어날 경우 자동 줄바꿈
		recipeList.setEditable(false); //사용자가 textarea을 수정 할 수 없게 만듬.
		for(int i=0;i<recipeArray.length;i++)  //recipeArray 길이 만큼 JTextArea에 넣어준다.
			recipeList.append(recipeArray[i]+"\n\n");
	
		JScrollPane recipeScrollPane = new JScrollPane(recipeList); // 스크롤바가 달려있는 JScrollPane에 JTextArea recipeList를 달아준다.
		recipeScrollPane.setLocation(20,30); // JScrollPane sp의 위치를 설정한다.
		recipeScrollPane.setSize(480,240); // JScrollPane sp의 크기를 설정한다.
		c.add(recipeScrollPane);
		
		
		JPanel ingredientPane =new JPanel();    // 재료선택 할 수 있는 버튼이 달릴 panel
		ingredientPane.setSize(250,250);
		ingredientPane.setLocation(520,10);
		ingredientPane.setLayout(new GridLayout(ingredientArray.length,1));
		
		JScrollPane ingredientScrollPane = new JScrollPane(ingredientPane); //ingredientPane을 부착시킬 스크롤 팬
		ingredientScrollPane.setSize(250,200);
		ingredientScrollPane.setLocation(520, 280);
		ingredientScrollPane.setBackground(Color.white);
		c.add(ingredientScrollPane);
		
		JCheckBox[] ingredientBtn= new JCheckBox[ingredientArray.length];
		for(int i=0;i<ingredientArray.length;i++) {
			ingredientBtn[i]=new JCheckBox(ingredientArray[i]);
			ingredientBtn[i].setBorderPainted(true);
			ingredientBtn[i].setBackground(Color.pink);
			ingredientBtn[i].setForeground(Color.white);
			ingredientPane.add(ingredientBtn[i]);
		}
		
		JButton basketAddBtn = new JButton("장바구니에 추가");
		basketAddBtn.setLocation(650, 485);
		basketAddBtn.setSize(130,30);
		basketAddBtn.setBackground(Color.WHITE);
		basketAddBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				new ShoppingBasketFrame();
			}
		});;
		c.add(basketAddBtn);
	
	
	}
	public static void main(String[] args) {
		Food[] f = new Food[100];
		f[0]=new Food(1,	"목살스테이크카레 ",	"1.고기 사이의 힘줄을 끊어 주고 소금·후추로 밑간합니다. 밑간이 고르게 될 수 있도록 손으로 가볍게 고기를 두드려 줍니다.#2. 파프리카와 당근, 감자를 먹기 좋은 크기로 썰고 양파를 채썹니다. 단, 토핑 재료인 파프리카는 취향껏 바꿔도 좋은 선택 재료입니다.#3. 팬에 기름을 두르고, 목살이 진한 갈색이 될 때까지 강불에 굽습니다. 너무 익혔나 싶을 때까지 굽는 것이 포인트에요.#4. 채썬 양파를 넣고 중불로 줄인 뒤, 이후 당근과 감자, 물을 넣고 끓입니다.#5. 감자와 당근이 잘 익으면 카레 조각을 넣고 잘 젓습니다. 고형카레는 일반 마트에서 쉽게 볼 수 있는 고체형 카레입니다.#6. 마지막으로 파프리카를 넣고 섞어 줍니다.",	"돼지 목살 300g (150*2)#꽃소금 한꼬집#후춧가루 한꼬집#파프리카 각 50g씩#감자 150g (1개)#당근 70g (1/4개)#양파 200g (1개)#식용유 30ml (2큰술)#물 665ml (3컵 반)#고형카레 60g",	"돼지고기#소금#후춧가루#파프리카#감자#당근#양파#식용유#고형카레",	"https://www.youtube.com/watch?v=wDXCxlcr3hY&t=8s",	2);
		f[1]=new Food(2,	"초간단 김치찌개",	"1. 대파와 고추는 송송 썰어 준비합니다. #2. 냄비에 목살과 쌀뜨물을 넣고 충분히 끓여, 고기 육수를 우려냅니다. #3. 고기 육수가 충분히 우러나면 김치와 다진마늘을 넣습니다. #4. 국물이 끓어오르면 대파와 고추를 넣습니다. #5. 고춧가루를 넣고 잘 섞습니다. 굵은 고춧가루와 고운 고춧가루를 반씩 섞어 넣으면 더욱 좋습니다. #6. 국간장과 새우젓을 넣고 잘 저어 줍니다. ",	"1. 돼지고기 120g#2. 쌀뜨물 380ml (약 2컵)#3. 자른 김치 150g#4. 다진마늘 30g (2큰술)#5. 대파 30g #6. 청양고추 10g#7. 홍고추 10g#8. 고운 고춧가루 30g (2큰술)#9. 굵은 고춧가루 30g (2큰술)#10. 국간장 15ml (1큰술)#11. 새우젓 15g (1큰술)",	"돼지고기#쌀뜨물#김치#마늘#대파#고추#고춧가루#국간장#새우젓",	"https://www.youtube.com/watch?v=DnQ09ZZCjCs&t=245s",	1);
		f[2]=new Food(3,	"뚝배기 계란찜",	"1. 대파는 송송 썰고, 새우젓은 잘게 다져 준비합니다. #2. 믹싱볼에 달걀과 새우젓, 설탕을 넣고 잘 섞습니다. #3. 재료가 잘 섞이면 물을 넣고 다시 한 번 잘 저어줍니다. #4. 뚝배기에 달걀물을 넣고 중약불로 가열합니다. #5. 달걀이 뚝배기 바닥과 가장자리에 눌어붙지 않도록, 숟가락으로 바닥을 긁어가며 끓여줍니다. #6. 달걀이 몽글몽글하게 익으면 대파를 넣고 섞습니다. #7. 사이즈가 맞는 다른 뚝배기를 뒤집어 뚜껑처럼 덮어 약불로 익힙니다. #8. 대파, 참기름, 깨를 달걀찜 위에 고명으로 뿌려 마무리합니다.",	"1. 달걀 6개 324g#2. 새우젓 1큰술 (15g)#3. 설탕 1작은술 (5g) #4. 물 1/3컵 (60ml)#5. 참기름 1큰술 (15ml)#6. 참깨 1작은술 (5g)#7. 대파 40g",	"달걀#새우젓#설탕#참기름#참깨#대파",	"https://www.youtube.com/watch?v=_H64Kz7Mgz4",	2);
		new RecipeInterface(f[0]);
	}
	

}