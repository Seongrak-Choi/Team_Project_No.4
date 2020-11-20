import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class FoodSelectInterface extends JFrame {
   // private Image backgroundImage = new
   // ImageIcon("src/image/image.png").getImage();
   JCheckBox[] box;
   String[] ingredientArray;
   int count;
   int sum;

   public FoodSelectInterface(Food[] food) {
      JFrame frame = new JFrame();
      JPanel panel = new JPanel() {
         // 배경이미지와 밑 라인을 그리기 위한 paintComponent()메소드
      };

      Food[] fff = food;
      sum = 0;
      count = 0;

      panel.setLayout(null);
      panel.setBackground(Color.white);

      frame.add(panel);

      // 검색버튼
      JButton btn1 = new JButton("검색");
      btn1.setLayout(null);
      btn1.setSize(60, 20);
      btn1.setLocation(660, 230);
      btn1.setBackground(Color.white);
      panel.add(btn1);

      btn1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn1) {
               JOptionPane.showMessageDialog(panel, "다양한 재료들을 선택하고 다시 시도해주세요.", "알맞은 요리가 없습니다.",
                     JOptionPane.INFORMATION_MESSAGE, null);
            }
         }
      });
      ;

      // 뒤로가기 버튼
      JButton btn2 = new JButton("뒤로가기");
      btn2.setLayout(null);
      btn2.setSize(86, 20);
      btn2.setLocation(635, 500);
      btn2.setBackground(Color.white);
      panel.add(btn2);

      btn2.addActionListener(new ActionListener() { // 요리선택 리스너
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn2) {
               new MainFrame(food);
               frame.setVisible(false);
            }
         }
      });
      ;

      // 재료선택 테이블 구성

      box = new JCheckBox[10000];
      for (int i = 0; i <= 8; i++) {
         ingredientArray = fff[i].getIngredient().split("#");
         for (int j = 0; j <= ingredientArray.length; j++) {
            box[sum + j] = new JCheckBox(ingredientArray[j]);
            panel.add(box[i]);
            count++;
         }
         sum += count;
      }
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(20, 20, 700, 200);
      panel.add(scrollPane, "Center");


      JPanel ingredientPane = new JPanel(); // 재료선택 할 수 있는 버튼이 달릴 panel
      ingredientPane.setSize(250, 250);
      // ingredientPane.setLocation(520,10);
      ingredientPane.setLayout(new GridLayout(ingredientArray.length, 1));

      // 재료선택 테이블에 스크롤 달기

      // 영상 테이블 리스트
      JList list = new JList();
      list.setBounds(20, 290, 700, 200);
      JScrollPane sp = new JScrollPane(list);
      sp.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
      panel.add(sp, "Center");

      frame.setTitle("백바구니");
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setSize(800, 600);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}