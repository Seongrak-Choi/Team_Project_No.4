import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class RecipeInterface extends JFrame{
	
	

	
	public RecipeInterface(Food food) {
		setTitle("백바구니");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		//setResizable(false); //프레임 크기 고정
		Container c = getContentPane();
		c.setLayout(null);
		Food chosenFood = food;
		
		

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
		c.add(recommendBtn);
		
		JButton reportBtn = new JButton("신 고"); //신고 버튼
		reportBtn.setSize(80,30);
		reportBtn.setLocation(580, 520);
			
		reportBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
					ReportFrame report = new ReportFrame(food);
			}
		});;
		c.add(reportBtn);
		
		
		JButton backBtn = new JButton("뒤로 가기"); //신고 버튼
		backBtn.setSize(100,30);
		backBtn.setLocation(670, 520);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});;
		c.add(backBtn);
		
		
		JTextArea quantitativeList = new JTextArea(); //레시피가 담길 JTextArea
		quantitativeList.setLineWrap(true); // size를 벗어날 경우 자동 줄바꿈
		quantitativeList.setEditable(false);
		for(int i=0;i<quantitativeArray.length;i++)  //recipeArray 길이 만큼 JTextArea에 넣어준다.
			quantitativeList.append(quantitativeArray[i]+"\n\n");
	
		JScrollPane quantitativeScrollPane = new JScrollPane(quantitativeList); // 스크롤바가 달려있는 JScrollPane에 JTextArea recipeList를 달아준다.
		quantitativeScrollPane.setLocation(520,30); // JScrollPane sp의 위치를 설정한다.
		quantitativeScrollPane.setSize(250,240); // JScrollPane sp의 크기를 설정한다.
		c.add(quantitativeScrollPane);
		
					
		JTextArea recipeList = new JTextArea(); //레시피가 담길 JTextArea
		recipeList.setLineWrap(true); // size를 벗어날 경우 자동 줄바꿈
		recipeList.setEditable(false);
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
		c.add(ingredientScrollPane);
		
		JCheckBox[] ingredientBtn= new JCheckBox[ingredientArray.length]; 
		for(int i=0;i<ingredientArray.length;i++) {
			ingredientBtn[i]=new JCheckBox(ingredientArray[i]);
			ingredientBtn[i].setBorderPainted(true);
			ingredientPane.add(ingredientBtn[i]);
		}
		
		JButton basketAddBtn = new JButton("장바구니 추가");
		basketAddBtn.setLocation(650, 485);
		basketAddBtn.setSize(120,30);
		
		c.add(basketAddBtn);
	
	
	}
	
	

}