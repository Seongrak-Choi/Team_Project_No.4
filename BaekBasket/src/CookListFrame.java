import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CookListFrame extends JFrame {
   int index=MainFrame.index;
   JFrame frame = new JFrame("�丮 ����Ʈ ȭ��");
   JPanel pFrame = new JPanel();
   JButton bSnack = new JButton("����");
   JButton bSoup = new JButton("�&��");
   JButton bSide = new JButton("����");
   JButton bRice = new JButton("��");
   JButton bEtc = new JButton("��Ÿ");
   JButton bBack = new JButton("����");
   JTextField tSearch = new JTextField();
   JButton bSearch = new JButton("�˻�");
   JPanel pCookList = new JPanel();
   String[] snack = new String[MainFrame.snack];
   String[] soup = new String[MainFrame.soup];
   String[] side = new String[MainFrame.side];
   String[] rice = new String[MainFrame.rice];
   String[] etc =new String[MainFrame.etc];
   String[] cook = new String[index];
   JList lCookList = new JList(cook);
   String[] compare = new String[index];

   public CookListFrame(Food[] food) {
      Food[] f= food;
      frame.setLocation(0, 0);
      frame.setSize(800, 600);
      frame.setLayout(null);

      pFrame.setLocation(0, 0);
      pFrame.setSize(800, 600);
      pFrame.setLayout(null);
      pFrame.setBackground(Color.WHITE);

      bSnack.setLocation(50, 20);
      bSnack.setSize(100, 30);
      pFrame.add(bSnack);
      bSnack.setBackground(Color.WHITE);

      bSoup.setLocation(150, 20);
      bSoup.setSize(90, 30);
      pFrame.add(bSoup);
      bSoup.setBackground(Color.WHITE);

      bSide.setLocation(240, 20);
      bSide.setSize(75, 30);
      pFrame.add(bSide);
      bSide.setBackground(Color.WHITE);

      bRice.setLocation(315, 20);
      bRice.setSize(75, 30);
      pFrame.add(bRice);
      bRice.setBackground(Color.WHITE);

      bEtc.setLocation(390, 20);
      bEtc.setSize(75, 30);
      pFrame.add(bEtc);
      bEtc.setBackground(Color.WHITE);

      bBack.setLocation(690, 520);
      bBack.setSize(75, 30);
      pFrame.add(bBack);
      bBack.setBackground(Color.WHITE);      

      tSearch.setLocation(550, 20);
      tSearch.setSize(150,30);
      pFrame.add(tSearch);
      tSearch.setBorder(new LineBorder(Color.BLACK));

      bSearch.setLocation(710,20);
      bSearch.setSize(60,30);
      pFrame.add(bSearch);
      bSearch.setBackground(Color.WHITE);

      pCookList.setLocation(50, 75);
      pCookList.setSize(665, 425);
      pCookList.setLayout(null);
      pCookList.setVisible(true);

      int iSnack =0;
      int iSoup =0;
      int iSide =0;
      int iRice =0;
      int iEtc =0;
      for(int i=0;i<index;i++) {
         if(f[i].categoryNo==0) {
            snack[iSnack]=f[i].name;
            iSnack++;
         }
         else if(f[i].categoryNo==1) {
            soup[iSoup]=f[i].name;
            iSoup++;
         }
         else if(f[i].categoryNo==2) {
            side[iSide]=f[i].name;
            iSide++;
         }
         else if(f[i].categoryNo==3) {
            rice[iRice]=f[i].name;
            iRice++;
         }
         else if(f[i].categoryNo==4) {
            etc[iEtc]=f[i].name;
            iEtc++;
         }
      }
      for(int i=0;i<index;i++) {
         cook[i] = f[i].name;
      }

      for(int i=0;i<index;i++)
         compare[i]=cook[i];

      lCookList.setLocation(0, 0);
      lCookList.setSize(665, 425);
      lCookList.setBorder(new LineBorder(Color.BLACK));

      lCookList.addMouseListener(new MouseAdapter() {
         @Override public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2) {
               RecipeInterface recipeInterface = new RecipeInterface(f[lCookList.getSelectedIndex()]);
            }
         }});


      JScrollPane sb = new JScrollPane(lCookList);
      sb.setLocation(0,0);
      sb.setSize(665,425);
      pCookList.add(sb);

      bSnack.addActionListener(new EventHandler());
      bSoup.addActionListener(new EventHandler());
      bSide.addActionListener(new EventHandler());
      bRice.addActionListener(new EventHandler());
      bEtc.addActionListener(new EventHandler());
      bBack.addActionListener(new EventHandler());
      bSearch.addActionListener(new EventHandler());

      frame.add(pCookList);
      frame.add(pFrame);

      frame.setVisible(true);
   }
   class EventHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource()==bBack) 
            frame.dispose();
         else if(e.getSource()==bSnack) {
            lCookList.setListData(snack);
         }
         else if(e.getSource()==bSoup) 
            lCookList.setListData(soup);
         else if(e.getSource()==bSide) 
            lCookList.setListData(side);
         else if(e.getSource()==bRice) 
            lCookList.setListData(rice);
         else if(e.getSource()==bEtc) 
            lCookList.setListData(etc);
         else if(e.getSource()==bSearch) {
            String searchCook = tSearch.getText(); 
            String[] searchedCook = new String[index];

            for(int i=0;i<index;i++) // cook �ʱ�ȭ �۾�
               cook[i]=compare[i];

            int j=0;
            for(int i=0;i<index;i++) {
               if(cook[i].contains(searchCook)) {
                  searchedCook[j]=cook[i];
                  j++;
               }
            }
            lCookList.setListData(searchedCook);
         }
      }
   }
}

