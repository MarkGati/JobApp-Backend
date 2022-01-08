package UserService;
import java.sql.*;
import java.util.ArrayList;

import Model.User;


public class UserService{

    public static User post(Connection conn, User user) throws SQLException{
        String sql = "insert into public.users (user_id, user_name, email, password, phone) values (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql); 

        statement.setInt(1, user.user_id);
        statement.setString(2, user.user_name);
        statement.setString(3, user.email);
        statement.setString(4, user.password);
        statement.setString(5, user.phone);

        int rows = statement.executeUpdate();
        if (rows > 0){
            
        } else {
            user = null;
        }
        conn.close();
        return user;
    }

    public static ArrayList<User> getAll(Connection conn) throws SQLException{
        String sql = "select * from public.users";
        PreparedStatement statement = conn.prepareStatement(sql); ;
        ResultSet result = statement.executeQuery();
        ArrayList<User> selectedUsers = new ArrayList<>();

        while (result.next()){
            selectedUsers.add(new User(result.getInt("user_id"), result.getString("user_name"),result.getString("email"), result.getString("password"), result.getString("phone")));
        }
        conn.close();
        return selectedUsers;
    }
    
    public static User get(Connection conn, int ratingID) throws SQLException{
        String sql = "select * from public.users where user_id = "  + ratingID;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        User user = null;

        while (result.next()){

            user = new User(result.getInt("user_id"), result.getString("user_name"),result.getString("email"), result.getString("password"), result.getString("phone"));
        }
        conn.close();

        return user;
    }

    public static User delete(Connection conn, int ratingID) throws SQLException{
        String sql = "delete from public.users where user_id = "  + ratingID;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        User user = null;

        while (result.next()){
            user = new User(result.getInt("user_id"), result.getString("user_name"),result.getString("email"), result.getString("password"), result.getString("phone"));
        }
        conn.close();

        return user;
    }

    public static User update(Connection conn, User user) throws Exception{
        String sql = "update from public.users where user_id = "  + user.user_id;
        sql += "set user_name = " + user.user_name;
        sql += "set password = " + user.password;
        sql += "set email = " + user.email;
        sql += "set phone = " + user.phone;
        
        PreparedStatement statement = conn.prepareStatement(sql); 
        int rows = statement.executeUpdate();
        if (rows > 0){
        } else {
            user = null;
        }
        conn.close();

        return user;
    }
}