package RatingService;

import java.sql.*;
import java.util.ArrayList;

import Model.Rating;

public class RatingService {
    
    public static Rating post(Connection conn, Rating rating) throws SQLException{
        String sql = "insert into public.ratings (rating_id, description) values (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql); 

        statement.setInt(1, rating.rating_id);
        statement.setString(2, rating.description);

        int rows = statement.executeUpdate();
        if (rows > 0){
        } else {
            rating = null;
        }
        conn.close();
        return rating;
    }

    public static ArrayList<Rating> getAll(Connection conn) throws SQLException{
        String sql = "select * from public.ratings";
        PreparedStatement statement = conn.prepareStatement(sql); ;
        ResultSet result = statement.executeQuery();
        ArrayList<Rating> selectedRatings = new ArrayList<>();

        while (result.next()){
            selectedRatings.add(new Rating(result.getInt("rating_id"), result.getString("description")));
        }
        conn.close();
        return selectedRatings;
    }
    
    public static Rating get(Connection conn, int rating_id) throws SQLException{
        String sql = "select * from public.ratings where rating_id = "  + rating_id;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        Rating rating = null;

        while (result.next()){

            rating = new Rating(result.getInt("rating_id"), result.getString("description"));
        }
        conn.close();

        return rating;
    }

    public static Rating delete(Connection conn, int rating_id) throws SQLException{
        String sql = "delete from public.ratings where user_id = "  + rating_id;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        Rating rating = null;

        while (result.next()){
            rating = new Rating(result.getInt("rating_id"), result.getString("description"));
        }
        conn.close();

        return rating;
    }

    public static Rating update(Connection conn, Rating rating) throws Exception{
        String sql = "update from public.ratings where rating_id = "  + rating.rating_id;
        sql += "set description = " + rating.description;
        
        PreparedStatement statement = conn.prepareStatement(sql); 
        int rows = statement.executeUpdate();
        if (rows > 0){
        } else {
            rating = null;
        }
        conn.close();

        return rating;
    }
}
