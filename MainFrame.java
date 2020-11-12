package Team;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class MainFrame extends JFrame{
   public MainFrame() {
      Font f1;
      JFrame frame = new JFrame("백바구니"); //메인 frame
      frame.setLocation(0,0);
      frame.setSize(800,600);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel1 = new JPanel(); // 패널1
      panel1.setLocation(0,0);
      panel1.setSize(800,200);
      panel1.setLayout(null);
      panel1.setBackground(Color.ORANGE);

      JPanel panel2 = new JPanel(); // 패널2
      panel2.setLocation(0,200);
      panel2.setSize(800,400);
      panel2.setLayout(null);
      panel2.setBackground(Color.WHITE);

      f1 = new Font("돋움", Font.BOLD, 50);
      JLabel label = new JLabel("★백바구니"); // 제목 라벨
      label.setFont(f1);
      label.setLocation(270,50);
      label.setSize(300,50);

      JButton bSelectCook = new JButton("요리 선택하기"); //요리선택 버튼
      bSelectCook.setLocation(270,30);
      bSelectCook.setSize(250,50);
      bSelectCook.setBackground(Color.WHITE);
      
      bSelectCook.addActionListener(new ActionListener(){  // 요리선택 리스너
         public void actionPerformed(ActionEvent e){
            if(e.getSource()==bSelectCook) {
               CookListFrame cookListFrame = new CookListFrame();
               frame.setVisible(false);
            }
         }
      });;

      JButton bSelectIngredient = new JButton("재료 선택하기"); //재료선택 버튼
      bSelectIngredient.setLocation(270,115);
      bSelectIngredient.setSize(250,50);
      bSelectIngredient.setBackground(Color.WHITE);
      
      bSelectIngredient.addActionListener(new ActionListener(){  // 요리선택 리스너
          public void actionPerformed(ActionEvent e){
             if(e.getSource()==bSelectIngredient) {
                FoodSelectInterface foodSelectInterface = new FoodSelectInterface();
                frame.setVisible(false);
             }
          }
       });;

      JButton bBarsket = new JButton("장바구니 "); //종료 버튼
      bBarsket.setLocation(270,200);
      bBarsket.setSize(250,50);
      bBarsket.setBackground(Color.WHITE);
      
      JButton bCancel = new JButton("  종  료  "); //종료 버튼
      bCancel.setLocation(270,285);
      bCancel.setSize(250,50);
      bCancel.setBackground(Color.WHITE);
      
      bCancel.addActionListener(new ActionListener(){ //종료버튼 리스너
         public void actionPerformed(ActionEvent e){
            if(e.getSource()==bCancel) {
               System.exit(0);
            }
         }
      });;
      
      panel1.add(label);
      panel2.add(bSelectCook);
      panel2.add(bSelectIngredient);
      panel2.add(bBarsket);
      panel2.add(bCancel);

      frame.add(panel1);
      frame.add(panel2);
      frame.setVisible(true);
   }
   public static void main(String[] args) {
      MainFrame mainFrame = new MainFrame();
   }
}
