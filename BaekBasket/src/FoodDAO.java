import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodDAO {
   String[] ingredientArray;
   Food[] foodArray;

   public FoodDAO() {
      ingredientArray = new String[50];
      foodArray = new Food[100];
   }

   public Food[] foodInfo() {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      int n = 0;

      try {
         String dbURL = "jdbc:mysql://3.34.90.107:3306/db";
         String dbID = "jdbcuser";
         String dbPassword = "dltmdqja@2";
         Class.forName("com.mysql.jdbc.Driver");
         String sql = "select * from food";
         conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            int categoryNo = rs.getInt("categoryNo");
            int id = rs.getInt("id");
            String recipe = rs.getString("recipe");
            String link = rs.getString("link");
            String name = rs.getString("name");
            String quantity = rs.getString("quanti");
            String ingredient = rs.getString("ingredient");
            foodArray[n] = new Food(id, name, recipe, quantity, ingredient, link, categoryNo);
  
            n++;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      try {
         if (conn != null)
            conn.close();
         if (pstmt != null)
            pstmt.close(); // 각각의 객체도 닫아줘야함
         if (rs != null)
            rs.close();// 각가의 객체도 닫아줘야함.
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return foodArray;
   }
}
