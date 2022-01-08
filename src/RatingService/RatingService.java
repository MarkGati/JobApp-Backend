package RatingService;

import java.sql.*;

public class RatingService {
    
    public static void post(Connection conn) throws SQLException{
        String sql = "insert into public.users (user_id, user_name, email, password, phone) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql); 
        statement.setInt(1, 2);
        statement.setString(2, "mgati");
        statement.setString(3, "gatimark123@gmail.com");
        statement.setString(4, "kekw");
        statement.setString(5, "0745067229");
        int rows = statement.executeUpdate();
        if (rows > 0){
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
        conn.close();
    }

    public static void getAll(Connection conn) throws SQLException{
        String sql = "insert into public.users (user_id, user_name, email, password, phone) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql); 
        statement.setInt(1, 2);
        statement.setString(2, "mgati");
        statement.setString(3, "gatimark123@gmail.com");
        statement.setString(4, "kekw");
        statement.setString(5, "0745067229");
        int rows = statement.executeUpdate();
        if (rows > 0){
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
        conn.close();
    }
    
    public static void get(Connection conn, int ratingID) throws SQLException{
        String sql = "select * from public.ratings where ratingID = "  + ratingID;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        
        while (result.next()){
            int id = result.getInt("ID");
            String firstname = result.getString("first_name");
        }

        conn.close();
    }
}
