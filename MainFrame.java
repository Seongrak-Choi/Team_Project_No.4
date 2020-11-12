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
      JFrame frame = new JFrame("��ٱ���"); //���� frame
      frame.setLocation(0,0);
      frame.setSize(800,600);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel1 = new JPanel(); // �г�1
      panel1.setLocation(0,0);
      panel1.setSize(800,200);
      panel1.setLayout(null);
      panel1.setBackground(Color.ORANGE);

      JPanel panel2 = new JPanel(); // �г�2
      panel2.setLocation(0,200);
      panel2.setSize(800,400);
      panel2.setLayout(null);
      panel2.setBackground(Color.WHITE);

      f1 = new Font("����", Font.BOLD, 50);
      JLabel label = new JLabel("�ڹ�ٱ���"); // ���� ��
      label.setFont(f1);
      label.setLocation(270,50);
      label.setSize(300,50);

      JButton bSelectCook = new JButton("�丮 �����ϱ�"); //�丮���� ��ư
      bSelectCook.setLocation(270,30);
      bSelectCook.setSize(250,50);
      bSelectCook.setBackground(Color.WHITE);
      
      bSelectCook.addActionListener(new ActionListener(){  // �丮���� ������
         public void actionPerformed(ActionEvent e){
            if(e.getSource()==bSelectCook) {
               CookListFrame cookListFrame = new CookListFrame();
               frame.setVisible(false);
            }
         }
      });;

      JButton bSelectIngredient = new JButton("��� �����ϱ�"); //��ἱ�� ��ư
      bSelectIngredient.setLocation(270,115);
      bSelectIngredient.setSize(250,50);
      bSelectIngredient.setBackground(Color.WHITE);
      
      bSelectIngredient.addActionListener(new ActionListener(){  // �丮���� ������
          public void actionPerformed(ActionEvent e){
             if(e.getSource()==bSelectIngredient) {
                FoodSelectInterface foodSelectInterface = new FoodSelectInterface();
                frame.setVisible(false);
             }
          }
       });;

      JButton bBarsket = new JButton("��ٱ��� "); //���� ��ư
      bBarsket.setLocation(270,200);
      bBarsket.setSize(250,50);
      bBarsket.setBackground(Color.WHITE);
      
      JButton bCancel = new JButton("  ��  ��  "); //���� ��ư
      bCancel.setLocation(270,285);
      bCancel.setSize(250,50);
      bCancel.setBackground(Color.WHITE);
      
      bCancel.addActionListener(new ActionListener(){ //�����ư ������
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
