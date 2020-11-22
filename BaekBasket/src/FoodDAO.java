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
			String dbURL = "jdbc:mysql://localhost:3306/team_project";
			String dbID = "baek";
			String dbPassword = "test123";
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "select * from ingredient";
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ingredientArray[n] = new String( rs.getString("name"));
				n++;
			}
			sql = "select * from food";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			n = 0;
			while (rs.next()) {
				int categoryNo = rs.getInt("categoryNo");
				int id = rs.getInt("id");
				String recipe = rs.getString("recipe");
				String link = rs.getString("link");
				String name = rs.getString("name");
				String quantity = rs.getString("quantity");
				String ingredient = rs.getString("ingredient");
				foodArray[n] = new Food(id,name,recipe,quantity,ingredient,link,categoryNo);
				System.out.println(foodArray[n].getName());
				System.out.println(foodArray[n].getId());
				System.out.println(foodArray[n].getCategoryNo());
			
				
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
			System.out.println("데이터베이스가 잘 종료되었다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodArray;
	}
}
