import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;



public class RecipeInterface extends JFrame{

   Food f;
   String[] recipeArray;
   String[] ingredientArray;
   String[] quantitativeArray;
   JCheckBox[] ingredientBtn;
   public ImageIcon icon3 = new ImageIcon("images/image3.png");
   

   public RecipeInterface(Food food) {
      
      f = food;
      setTitle(f.getName());
      setSize(800,600);
      setVisible(true);
      //setResizable(false); //프레임 크기 고정
      Container c = getContentPane();
      JPanel panel = new JPanel(){
         public void paintComponent(Graphics g) {
            g.drawImage(icon3.getImage(),0,0,800,600, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      
      c.add(panel);
      panel.setLayout(null);
      
      String link=f.getLink();
      panel.setBackground(Color.white);


      recipeArray =f.getRecipe().split("#");  //한줄의 string으로 된 레시피를 #마다 끊어서 string배열을 만들어준다. 
      ingredientArray=f.getIngredient().split("#"); //한줄의 string으로 된 재료를 #마다 끊어서 string배열을 만들어준다. 
      quantitativeArray=f.getQuanti().split("#"); //한줄의 string으로 된 정량을 #마다 끊어서 string배열을 만들어준다. 
      JLabel foodName = new JLabel("요리 레시피");
      JLabel quantitativeLa= new JLabel("재료 정량");
      
      foodName.setLocation(20,1);
      foodName.setSize(100,30);
      quantitativeLa.setSize(100,30);
      quantitativeLa.setLocation(20,270);
      
      panel.add(foodName);
      panel.add(quantitativeLa);
      

      JButton reportBtn = new JButton("신 고"); //신고 버튼
      reportBtn.setSize(80,30);
      reportBtn.setLocation(580, 520);
      reportBtn.setBackground(Color.WHITE);

      reportBtn.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e) {
            ReportFrame report = new ReportFrame(food);
         }
      });;
      panel.add(reportBtn);


      JButton backBtn = new JButton("뒤로 가기"); //뒤로가기 버튼
      backBtn.setSize(100,30);
      backBtn.setLocation(670, 520);
      backBtn.setBackground(Color.WHITE);
      backBtn.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });;
      panel.add(backBtn);
   
      JButton youtubeBtn = new JButton("유튜브 보러가기");
      youtubeBtn.setSize(130,30);
      youtubeBtn.setLocation(440,520);
      youtubeBtn.setBackground(Color.white);
      youtubeBtn.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            new YouTubeViewer(f.getLink());
         }
      });
      panel.add(youtubeBtn);
      
      JTextArea quantitativeList = new JTextArea(); //레시피가 담길 JTextArea
      quantitativeList.setLineWrap(true); // size를 벗어날 경우 자동 줄바꿈
      quantitativeList.setEditable(false); // 사용자가 textarea를 수정 할 수 없게 설정.
      for(int i=0;i<quantitativeArray.length;i++)  //recipeArray 길이 만큼 JTextArea에 넣어준다.
         quantitativeList.append(quantitativeArray[i]+"\n\n");

      JScrollPane quantitativeScrollPane = new JScrollPane(quantitativeList); // 스크롤바가 달려있는 JScrollPane에 JTextArea recipeList를 달아준다.
      quantitativeScrollPane.setLocation(20,300); // JScrollPane sp의 위치를 설정한다.
      quantitativeScrollPane.setSize(480,210); // JScrollPane sp의 크기를 설정한다.
      panel.add(quantitativeScrollPane);


      JTextArea recipeList = new JTextArea(); //레시피가 담길 JTextArea
      recipeList.setLineWrap(true); // size를 벗어날 경우 자동 줄바꿈
      recipeList.setEditable(false); //사용자가 textarea을 수정 할 수 없게 만듬.
      for(int i=0;i<recipeArray.length;i++)  //recipeArray 길이 만큼 JTextArea에 넣어준다.
         recipeList.append(recipeArray[i]+"\n\n");

      JScrollPane recipeScrollPane = new JScrollPane(recipeList); // 스크롤바가 달려있는 JScrollPane에 JTextArea recipeList를 달아준다.
      recipeScrollPane.setLocation(20,30); // JScrollPane sp의 위치를 설정한다.
      recipeScrollPane.setSize(480,240); // JScrollPane sp의 크기를 설정한다.
      panel.add(recipeScrollPane);


      JPanel ingredientPane =new JPanel();    // 재료선택 할 수 있는 버튼이 달릴 panel
      ingredientPane.setSize(250,250);
      //ingredientPane.setLocation(520,10);
      ingredientPane.setLayout(new GridLayout(ingredientArray.length,1));

      JScrollPane ingredientScrollPane = new JScrollPane(ingredientPane); //ingredientPane을 부착시킬 스크롤 팬
      ingredientScrollPane.setSize(250,250);
      ingredientScrollPane.setLocation(520, 30);
      ingredientScrollPane.setBackground(Color.white);
      panel.add(ingredientScrollPane);
      


      
      ingredientBtn= new JCheckBox[ingredientArray.length];
      for(int i=0;i<ingredientArray.length;i++) {
         ingredientBtn[i]=new JCheckBox(ingredientArray[i]);
         ingredientBtn[i].setBorderPainted(true);
         ingredientBtn[i].setBackground(Color.pink);
         ingredientBtn[i].setForeground(Color.white);
         ingredientPane.add(ingredientBtn[i]);
      }

      JButton basketAddBtn = new JButton("장바구니에 추가");
      basketAddBtn.setLocation(650, 290);
      basketAddBtn.setSize(130,30);
      basketAddBtn.setBackground(Color.WHITE);
      basketAddBtn.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            for(int i=0;i<ingredientArray.length;i++) {
               int check=0;
               if(ingredientBtn[i].isSelected()) {
                  for(int j=0;j<MainFrame.basketIndex;j++) {
                     if(MainFrame.basketArray[j].equals(ingredientArray[i])) {
                        System.out.println("선택하신 재료는 이미 장바구니에 있습니다.");
                        check=1;
                     }
                  }
                  if(check==0) {
                     MainFrame.basketArray[MainFrame.basketIndex]=ingredientArray[i];
                     MainFrame.basketIndex++;
                  }

               }
            }
            for(int i=0;i<ingredientArray.length;i++) {
               ingredientBtn[i].setSelected(false);
            }
            new ShoppingBasketFrame(ingredientArray);
         }
      });;
      panel.add(basketAddBtn);


   }
   
   
   public static JPanel getBrowserPanel() {
      JPanel webBrowserPanel = new JPanel(new GridLayout(1,1));
      JWebBrowser webBrowser = new JWebBrowser();
      webBrowserPanel.add(webBrowser);
      webBrowser.setBarsVisible(true);       
      webBrowser.navigate("https://www.youtube.com/watch?v=R6IT_f0XPT8");
      return webBrowserPanel;
   }

}