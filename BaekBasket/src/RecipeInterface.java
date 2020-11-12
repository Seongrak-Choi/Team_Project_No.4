import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class RecipeInterface extends JFrame{
	
	

	
	public RecipeInterface(Food food) {
		setTitle("��ٱ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		//setResizable(false); //������ ũ�� ����
		Container c = getContentPane();
		c.setLayout(null);
		Food chosenFood = food;
		
		

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
		c.add(recommendBtn);
		
		JButton reportBtn = new JButton("�� ��"); //�Ű� ��ư
		reportBtn.setSize(80,30);
		reportBtn.setLocation(580, 520);
			
		reportBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
					ReportFrame report = new ReportFrame(food);
			}
		});;
		c.add(reportBtn);
		
		
		JButton backBtn = new JButton("�ڷ� ����"); //�Ű� ��ư
		backBtn.setSize(100,30);
		backBtn.setLocation(670, 520);
		backBtn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
					CookListFrame cL = new CookListFrame();
			}
		});;
		c.add(backBtn);
		
		
		JTextArea quantitativeList = new JTextArea(); //�����ǰ� ��� JTextArea
		quantitativeList.setLineWrap(true); // size�� ��� ��� �ڵ� �ٹٲ�
		quantitativeList.setEditable(false);
		for(int i=0;i<quantitativeArray.length;i++)  //recipeArray ���� ��ŭ JTextArea�� �־��ش�.
			quantitativeList.append(quantitativeArray[i]+"\n\n");
	
		JScrollPane quantitativeScrollPane = new JScrollPane(quantitativeList); // ��ũ�ѹٰ� �޷��ִ� JScrollPane�� JTextArea recipeList�� �޾��ش�.
		quantitativeScrollPane.setLocation(520,30); // JScrollPane sp�� ��ġ�� �����Ѵ�.
		quantitativeScrollPane.setSize(250,240); // JScrollPane sp�� ũ�⸦ �����Ѵ�.
		c.add(quantitativeScrollPane);
		
					
		JTextArea recipeList = new JTextArea(); //�����ǰ� ��� JTextArea
		recipeList.setLineWrap(true); // size�� ��� ��� �ڵ� �ٹٲ�
		recipeList.setEditable(false);
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
		c.add(ingredientScrollPane);
		
		JCheckBox[] ingredientBtn= new JCheckBox[ingredientArray.length]; 
		for(int i=0;i<ingredientArray.length;i++) {
			ingredientBtn[i]=new JCheckBox(ingredientArray[i]);
			ingredientBtn[i].setBorderPainted(true);
			ingredientPane.add(ingredientBtn[i]);
		}
		
		JButton basketAddBtn = new JButton("��ٱ��� �߰�");
		basketAddBtn.setLocation(650, 485);
		basketAddBtn.setSize(120,30);
		
		c.add(basketAddBtn);
	
	
	}
	
	

}