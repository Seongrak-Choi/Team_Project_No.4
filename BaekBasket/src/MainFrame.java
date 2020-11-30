import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.swt.graphics.FontMetrics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;

public class MainFrame extends JFrame{
   public ImageIcon icon1 = new ImageIcon("images\\image1.png");
   public ImageIcon icon2 = new ImageIcon("images\\image2.png");
   public ImageIcon btnimg1 = new ImageIcon("images\\btnimg1.png");
   public ImageIcon btnimg2 = new ImageIcon("images\\btnimg2.png");
   public ImageIcon btnimg3 = new ImageIcon("images\\btnimg3.png");
   public ImageIcon btnimg4 = new ImageIcon("images\\btnimg4.png");
   public static int index;
   public static int snack;
   public static int soup;
   public static int side;
   public static int rice;
   public static int etc;
   public static String[] basketArray = new String[50];
   public static int basketIndex=0;
   public static Food[] f = new Food[100]; // 여기에 추가하면 자동으로 추가 됩니다. 0=간식, 1=찌개&국, 2=반찬, 3=밥, 4=기타 


   public MainFrame(Food[] food,ImageIcon[] img) {
      ImageIcon[] images=img;
      Food[] f=food;
      Font f1;
      JFrame frame = new JFrame(); // 각종 컴포넌트 추가
      frame.setLocation(0,0);
      frame.setSize(800,600);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel panel1 = new JPanel(){
         public void paintComponent(Graphics g) {
            g.drawImage(icon1.getImage(),0,0,800,200, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      panel1.setLocation(0,0);
      panel1.setSize(800,200);
      panel1.setLayout(null);
      panel1.setBackground(Color.ORANGE);

      JPanel panel2 = new JPanel(){
         public void paintComponent(Graphics g) {
            g.drawImage(icon2.getImage(),0,0,800,400, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      panel2.setLocation(0,200);
      panel2.setSize(800,400);
      panel2.setLayout(null);
      panel2.setBackground(Color.WHITE);

      JButton bSelectCook = new JButton("요리 선택하기",btnimg1);
      bSelectCook.setLocation(270,30);
      bSelectCook.setSize(250,50);
      
      JLabel la1 = new JLabel("                           요리 선택하기");
      la1.setLocation(400,30);
      la1.setSize(50,50);
    

      bSelectCook.addActionListener(new ActionListener(){ // CookListFrame 생성
         public void actionPerformed(ActionEvent e){
            new CookListFrame(f);
         }
      });;

      JButton bSelectIngredient = new JButton("요리 월드컵 16강",btnimg2);
      bSelectIngredient.setLocation(270,115);
      bSelectIngredient.setSize(250,50);
      bSelectIngredient.setBackground(Color.WHITE);
      
      JLabel la2 = new JLabel("                      요리 월드컵 16강");
      la2.setLocation(400,115);
      la2.setSize(50,50);

      bSelectIngredient.addActionListener(new ActionListener(){ // FoodSelectInterface 생성
         public void actionPerformed(ActionEvent e){
            new CookWorldCup(images);
         }
      });;

      JButton bBasket = new JButton("장바구니  ", btnimg3 ); 
      bBasket.setLocation(270,200);
      bBasket.setSize(250,50);
      bBasket.setBackground(Color.WHITE);
      bBasket.addActionListener(new ActionListener(){  // 시스템 종료
         public void actionPerformed(ActionEvent e){
            new ShoppingBasketFrame(basketArray);
         }
      });;
      
      JLabel la3 = new JLabel("                             장바구니");
      la3.setLocation(400,200);
      la3.setSize(50,50);

      JButton bCancel = new JButton("  종  료  ", btnimg4);
      bCancel.setLocation(270,285);
      bCancel.setSize(250,50);
      bCancel.setBackground(Color.WHITE);
      
      JLabel la4 = new JLabel("                                  종료");
      la4.setLocation(400,285);
      la4.setSize(50,50);

      bCancel.addActionListener(new ActionListener(){  // 시스템 종료
         public void actionPerformed(ActionEvent e){
            System.exit(0);
         }
      });;

      panel2.add(bSelectCook);
      panel2.add(bSelectIngredient);
      panel2.add(bBasket);
      panel2.add(bCancel);

      frame.add(panel1);
      frame.add(panel2);
      frame.setVisible(true);
      
      bSelectCook.add(la1);
      bSelectIngredient.add(la2);
      bBasket.add(la3);
      bCancel.add(la4);
      
   }
   
   public static void main(String[] args) {
      FoodDAO fd = new FoodDAO();
      f = fd.foodInfo();
      JButton[] bImages = new JButton[16];
      ImageIcon[] images = new ImageIcon[16];

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

            images[0] = new ImageIcon("images/감바스 알 아히요.jpg","감바스 알 아히요");
            images[1] = new ImageIcon("images/고기짬뽕라면.jpg","고기짬뽕라면");
            images[2] = new ImageIcon("images/기름떡볶이.jpg","기름떡볶이");
            images[3] = new ImageIcon("images/김치 수제비.jpg","김치 수제비");
            images[4] = new ImageIcon("images/닭갈비.jpg","닭갈비");
            images[5] = new ImageIcon("images/닭칼국수.jpg","닭칼국수");
            images[6] = new ImageIcon("images/돼지고기 김치찌개.jpg","돼지고기 김치찌개");
            images[7] = new ImageIcon("images/떡만둣국.jpg","떡만둣국");
            images[8] = new ImageIcon("images/베이컨크림파스타.jpg","베이컨크림파스타");
            images[9] = new ImageIcon("images/소갈비찜.jpg","소갈비찜");
            images[10] = new ImageIcon("images/소고기된장찌개.jpg","소고기된장찌개");
            images[11] = new ImageIcon("images/오므라이스.jpg","오므라이스");
            images[12] = new ImageIcon("images/족발덮밥.jpg","족발덮밥");
            images[13] = new ImageIcon("images/중국식 볶음밥.jpg","중국식 볶음밥");
            images[14] = new ImageIcon("images/참치함박스테이크.jpg","참치함박스테이크");
            images[15] = new ImageIcon("images/치킨스테이크.jpg","치킨스테이크");


            MainFrame mainFrame = new MainFrame(f,images);
   }

}