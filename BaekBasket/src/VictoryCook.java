import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VictoryCook extends JFrame{
   public ImageIcon icon5 = new ImageIcon("images/image5.png");
   private JLabel la=new JLabel();
   private JLabel victoryLa=new JLabel("우     승");
   
   public VictoryCook(ImageIcon img) {
      setSize(800,600);
      Font f1;
      f1 = new Font("돋움", Font.BOLD, 35);
      Font f2;
      f2 = new Font("돋움", Font.BOLD, 70);
      
      Container c = getContentPane();
      
      JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(icon5.getImage(),0,0,800,600, null);
                setOpaque(false);
                super.paintComponent(g);
                //g.drawRoundRect(300, 47, 200, 60, 20, 10);
               //g.setColor(Color.BLACK);
              // g.fillRoundRect(300, 47, 200, 60, 20, 10);
             }
          };
          c.add(panel);
          panel.setLayout(null);
      
      JButton btn =new JButton(img.toString(),img);
      btn.setSize(500,300);
      btn.setLocation(145,200);
      btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JButton btn=(JButton)e.getSource();
            for(int i=0;i<MainFrame.index;i++) {
               if(btn.getText().equals(MainFrame.f[i].getName())) {
                  new RecipeInterface(MainFrame.f[i]);
                  dispose();
               }
               
            }
            
         }
      });
      victoryLa.setFont(f2);
      victoryLa.setSize(300,100);
      victoryLa.setLocation(270,35);
      victoryLa.setForeground(Color.white);
      
      la.setFont(f1);
      la.setLocation(300,100);
      la.setSize(300,170);
      la.setText(img.toString());
      panel.add(la);
      panel.add(btn);
      panel.add(victoryLa);

      setVisible(true);

   }
}