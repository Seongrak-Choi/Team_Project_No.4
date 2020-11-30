import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CookWorldCup extends JFrame {
   JLabel leftName;
   JLabel rightName;
   JPanel pLeft;
   JPanel pRight;
   JFrame frame;
   int index;
   int count=0;
   ImageIcon[] images;
   JButton[] bImages;
   JButton temp;
   ImageIcon[] bImagesNext;
   int bImagesNextCount = 0;
   public ImageIcon icon4 = new ImageIcon("images/image4.png");

   
   public CookWorldCup(ImageIcon[] img){
      
        JPanel pFrame = new JPanel(){
            public void paintComponent(Graphics g) {
               g.drawImage(icon4.getImage(),0,0,800,600, null);
               setOpaque(false);
               super.paintComponent(g);
               g.drawRoundRect(190, 10, 400, 50, 20, 10);
               g.setColor(Color.BLACK);
               g.fillRoundRect(190, 10, 400, 50, 20, 10);
               g.drawRoundRect(352, 255, 75, 50, 20, 10);
               g.fillRoundRect(352, 255, 75, 50, 20, 10);
            }
         };
         
      if(img.length!=1) {
         bImages=new JButton[img.length];
         bImagesNext=new ImageIcon[(img.length)/2];
         images=img.clone();
         for(int i=0;i<img.length;i++) {
            bImages[i]=new JButton(images[i].toString(),images[i]);
         }
      
         index = img.length;
         Font f1;

         for(int i=0;i<index;i++) {
            int random=(int)(Math.random()*index);
            temp = new JButton();
            temp = bImages[random];
            bImages[random]=bImages[i]; 
            bImages[i] = temp;
         }
         
         
         frame = new JFrame("요리 이상형 월드컵");
         frame.setLocation(0, 0); // 
         frame.setSize(800, 600);
         frame.setLayout(null);
         frame.setVisible(true);

         pFrame.setLocation(0, 0);
         pFrame.setSize(800, 600);
         pFrame.setLayout(null);
         pFrame.setBackground(Color.WHITE);
         frame.add(pFrame);

         f1 = new Font("    ", Font.BOLD, 30);
         JLabel label = new JLabel("백종원 요리 이상형 월드컵");
         label.setForeground(Color.white);
         label.setFont(f1);
         label.setLocation(200,10);
         label.setSize(400,50);
         frame.add(label);

         JLabel vs = new JLabel("VS");
         vs.setForeground(Color.yellow);
         vs.setFont(f1);
         vs.setLocation(370,255);
         vs.setSize(75,50);
         frame.add(vs);
         
         JLabel rank = new JLabel(index + "강");
         rank.setForeground(Color.white);
         rank.setFont(f1);
         rank.setLocation(357,200);
         rank.setSize(75,50);
         frame.add(rank);

         for(int i=0;i<index;i++) {
            bImages[i].setLocation(0, 0);
            bImages[i].setSize(325, 400);
            bImages[i].addActionListener(new EventHandler());
         }

         pLeft = new JPanel();
         pLeft.setLocation(25, 75);
         pLeft.setSize(325, 400);
         pLeft.setLayout(null);
         frame.add(pLeft);

         pRight = new JPanel();
         pRight.setLocation(430, 75);
         pRight.setSize(325, 400);
         pRight.setLayout(null);
         pRight.setBackground(Color.ORANGE);
         frame.add(pRight);

         pLeft.add(bImages[0]);
         pRight.add(bImages[1]);

         leftName = new JLabel(bImages[count].getText());
         leftName.setLocation(105,472);
         leftName.setSize(250,50);
         leftName.setForeground(Color.white);
         leftName.setFont(new Font("돋움", Font.BOLD, 27));
         frame.add(leftName);

         rightName = new JLabel(bImages[count+1].getText());
         rightName.setLocation(500,472);
         rightName.setSize(250,50);
         rightName.setForeground(Color.white);
         rightName.setFont(new Font("돋움", Font.BOLD, 27));
         frame.add(rightName);

         JButton bBack = new JButton("뒤로");
         
         bBack.setLocation(690, 520);
         bBack.setSize(75, 30);
         pFrame.add(bBack);
         bBack.setBackground(Color.WHITE);

         bBack.addActionListener(new ActionListener(){ // CookListFrame     
            public void actionPerformed(ActionEvent e){
               frame.dispose();
            }
         });;

         frame.add(pFrame);
      }
      else {
         new VictoryCook(img[0]);
      }
   }

   class EventHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         JButton img=(JButton)e.getSource();
         if(img==bImages[count]) {
            bImagesNext[bImagesNextCount]=(ImageIcon) bImages[count].getIcon();
  
         }
         else if(img==bImages[count+1]) { 
            bImagesNext[bImagesNextCount]=(ImageIcon)bImages[count+1].getIcon();
         }
         pLeft.remove(bImages[count]);
         pRight.remove(bImages[count+1]);
         pLeft.setVisible(false);
         pRight.setVisible(false);
         count = count +2;
         if(count>=index) { 
            new CookWorldCup(bImagesNext);
            frame.dispose();
         }
         else {
         pLeft.setVisible(true);
         pRight.setVisible(true);
         pLeft.add(bImages[count]);
         pRight.add(bImages[count+1]);
         leftName.setText(bImages[count].getText());
         rightName.setText(bImages[count+1].getText());
         
         bImagesNextCount++;
         }
      }
   }      
}