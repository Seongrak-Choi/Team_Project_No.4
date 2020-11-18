import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class RecipeInterface extends JFrame{
	
	

	
	public RecipeInterface(Food food) {
		setTitle("��ٱ���");
		setSize(800,600);
		setVisible(true);
		//setResizable(false); //������ ũ�� ����
		Container c = getContentPane();
		c.setLayout(null);
		Food chosenFood = food;
		c.setBackground(Color.white);
		

		String[] recipeArray =chosenFood.getRecipe().split("#");
		String[] ingredientArray=chosenFood.getIngredient().split("#");
		String[] quantitativeArray=chosenFood.getQuanti().split("#");
		JLabel foodName = new JLabel(chosenFood.getName()); //�丮�� �̸��� ����ϴ� Label
		foodName.setLocation(20,1);
		foodName.setSize(100,30);
		c.add(foodName);
		
		
		JButton recommendBtn = new JButton("�丮 ��õ"); //�丮��õ ��ư
		recommendBtn.setSize(100,30);
		recommendBtn.setLocation(470, 520);
		recommendBtn.setBackground(Color.WHITE);
		c.add(recommendBtn);
		
		JButton reportBtn = new JButton("�� ��"); //�Ű� ��ư
		reportBtn.setSize(80,30);
		reportBtn.setLocation(580, 520);
		reportBtn.setBackground(Color.WHITE);
			
		reportBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
					ReportFrame report = new ReportFrame(food);
			}
		});;
		c.add(reportBtn);
		
		
		JButton backBtn = new JButton("�ڷ� ����"); //�ڷΰ��� ��ư
		backBtn.setSize(100,30);
		backBtn.setLocation(670, 520);
		backBtn.setBackground(Color.WHITE);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});;
		c.add(backBtn);
		
		
		JTextArea quantitativeList = new JTextArea(); //�����ǰ� ��� JTextArea
		quantitativeList.setLineWrap(true); // size�� ��� ��� �ڵ� �ٹٲ�
		quantitativeList.setEditable(false); // ����ڰ� textarea�� ���� �� �� ���� ����.
		for(int i=0;i<quantitativeArray.length;i++)  //recipeArray ���� ��ŭ JTextArea�� �־��ش�.
			quantitativeList.append(quantitativeArray[i]+"\n\n");
	
		JScrollPane quantitativeScrollPane = new JScrollPane(quantitativeList); // ��ũ�ѹٰ� �޷��ִ� JScrollPane�� JTextArea recipeList�� �޾��ش�.
		quantitativeScrollPane.setLocation(520,30); // JScrollPane sp�� ��ġ�� �����Ѵ�.
		quantitativeScrollPane.setSize(250,240); // JScrollPane sp�� ũ�⸦ �����Ѵ�.
		c.add(quantitativeScrollPane);
		
					
		JTextArea recipeList = new JTextArea(); //�����ǰ� ��� JTextArea
		recipeList.setLineWrap(true); // size�� ��� ��� �ڵ� �ٹٲ�
		recipeList.setEditable(false); //����ڰ� textarea�� ���� �� �� ���� ����.
		for(int i=0;i<recipeArray.length;i++)  //recipeArray ���� ��ŭ JTextArea�� �־��ش�.
			recipeList.append(recipeArray[i]+"\n\n");
	
		JScrollPane recipeScrollPane = new JScrollPane(recipeList); // ��ũ�ѹٰ� �޷��ִ� JScrollPane�� JTextArea recipeList�� �޾��ش�.
		recipeScrollPane.setLocation(20,30); // JScrollPane sp�� ��ġ�� �����Ѵ�.
		recipeScrollPane.setSize(480,240); // JScrollPane sp�� ũ�⸦ �����Ѵ�.
		c.add(recipeScrollPane);
		
		
		JPanel ingredientPane =new JPanel();    // ��ἱ�� �� �� �ִ� ��ư�� �޸� panel
		ingredientPane.setSize(250,250);
		ingredientPane.setLocation(520,10);
		ingredientPane.setLayout(new GridLayout(ingredientArray.length,1));
		
		JScrollPane ingredientScrollPane = new JScrollPane(ingredientPane); //ingredientPane�� ������ų ��ũ�� ��
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
		
		JButton basketAddBtn = new JButton("��ٱ��Ͽ� �߰�");
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
		f[0]=new Food(1,	"��콺����ũī�� ",	"1.��� ������ ������ ���� �ְ� �ұݡ����߷� �ذ��մϴ�. �ذ��� ���� �� �� �ֵ��� ������ ������ ��⸦ �ε�� �ݴϴ�.#2. ������ī�� ���, ���ڸ� �Ա� ���� ũ��� ��� ���ĸ� ä��ϴ�. ��, ���� ����� ������ī�� ���ⲯ �ٲ㵵 ���� ���� ����Դϴ�.#3. �ҿ� �⸧�� �θ���, ����� ���� ������ �� ������ ���ҿ� �����ϴ�. �ʹ� ������ ���� ������ ���� ���� ����Ʈ����.#4. ä�� ���ĸ� �ְ� �ߺҷ� ���� ��, ���� ��ٰ� ����, ���� �ְ� ���Դϴ�.#5. ���ڿ� ����� �� ������ ī�� ������ �ְ� �� �����ϴ�. ����ī���� �Ϲ� ��Ʈ���� ���� �� �� �ִ� ��ü�� ī���Դϴ�.#6. ���������� ������ī�� �ְ� ���� �ݴϴ�.",	"���� ��� 300g (150*2)#�ɼұ� �Ѳ���#���尡�� �Ѳ���#������ī �� 50g��#���� 150g (1��)#��� 70g (1/4��)#���� 200g (1��)#�Ŀ��� 30ml (2ū��)#�� 665ml (3�� ��)#����ī�� 60g",	"�������#�ұ�#���尡��#������ī#����#���#����#�Ŀ���#����ī��",	"https://www.youtube.com/watch?v=wDXCxlcr3hY&t=8s",	2);
		f[1]=new Food(2,	"�ʰ��� ��ġ�",	"1. ���Ŀ� ���ߴ� �ۼ� ��� �غ��մϴ�. #2. ���� ���� �Ҷ߹��� �ְ� ����� ����, ��� ������ ������ϴ�. #3. ��� ������ ����� �췯���� ��ġ�� ���������� �ֽ��ϴ�. #4. ������ ��������� ���Ŀ� ���߸� �ֽ��ϴ�. #5. ���尡�縦 �ְ� �� �����ϴ�. ���� ���尡��� ��� ���尡�縦 �ݾ� ���� ������ ���� �����ϴ�. #6. ������� �������� �ְ� �� ���� �ݴϴ�. ",	"1. ������� 120g#2. �Ҷ߹� 380ml (�� 2��)#3. �ڸ� ��ġ 150g#4. �������� 30g (2ū��)#5. ���� 30g #6. û����� 10g#7. ȫ���� 10g#8. ��� ���尡�� 30g (2ū��)#9. ���� ���尡�� 30g (2ū��)#10. ������ 15ml (1ū��)#11. ������ 15g (1ū��)",	"�������#�Ҷ߹�#��ġ#����#����#����#���尡��#������#������",	"https://www.youtube.com/watch?v=DnQ09ZZCjCs&t=245s",	1);
		f[2]=new Food(3,	"�ҹ�� �����",	"1. ���Ĵ� �ۼ� ���, �������� �߰� ���� �غ��մϴ�. #2. �ͽ̺��� �ް��� ������, ������ �ְ� �� �����ϴ�. #3. ��ᰡ �� ���̸� ���� �ְ� �ٽ� �� �� �� �����ݴϴ�. #4. �ҹ�⿡ �ް����� �ְ� �߾�ҷ� �����մϴ�. #5. �ް��� �ҹ�� �ٴڰ� �����ڸ��� ������� �ʵ���, ���������� �ٴ��� �ܾ�� �����ݴϴ�. #6. �ް��� ���۸����ϰ� ������ ���ĸ� �ְ� �����ϴ�. #7. ����� �´� �ٸ� �ҹ�⸦ ������ �Ѳ�ó�� ���� ��ҷ� �����ϴ�. #8. ����, ���⸧, ���� �ް��� ���� ������� �ѷ� �������մϴ�.",	"1. �ް� 6�� 324g#2. ������ 1ū�� (15g)#3. ���� 1������ (5g) #4. �� 1/3�� (60ml)#5. ���⸧ 1ū�� (15ml)#6. ���� 1������ (5g)#7. ���� 40g",	"�ް�#������#����#���⸧#����#����",	"https://www.youtube.com/watch?v=_H64Kz7Mgz4",	2);
		new RecipeInterface(f[0]);
	}
	

}