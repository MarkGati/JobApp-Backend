package RatingService;

import java.sql.*;
import java.util.ArrayList;

import Model.UserRating;
import ConnectionConfig.ConnectionConfig;

public class InternshipRatingService {

    public static UserRating post(UserRating rating) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConnectionConfig.jdbcURL, ConnectionConfig.username,
                    ConnectionConfig.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into public.user_ratings (user_id, rating_id, status) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, rating.rating_id);
        statement.setInt(2, rating.user_id);
        statement.setString(3, rating.status);

        int rows = statement.executeUpdate();
        if (rows > 0) {


        } else {
            rating = null;
        }
        connection.close();
        return rating;
    }

    public static ArrayList<UserRating> getAll() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConnectionConfig.jdbcURL, ConnectionConfig.username,
                    ConnectionConfig.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from public.ratings";
        PreparedStatement statement = connection.prepareStatement(sql);
        ;
        ResultSet result = statement.executeQuery();
        ArrayList<UserRating> selectedRatings = new ArrayList<>();

        while (result.next()) {
            selectedRatings.add(new UserRating(result.getInt("rating_id"), result.getInt("user_id"),
                    result.getString("status")));
        }
        connection.close();

        return selectedRatings;
    }

    public static UserRating get(int user_id, int rating_id) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ConnectionConfig.jdbcURL, ConnectionConfig.username,
                    ConnectionConfig.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from public.ratings where rating_id = " + rating_id;
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        Rating rating = null;

        while (result.next()) {

            rating = new Rating(result.getInt("rating_id"), result.getString("description"));
        }
        conn.close();

        return rating;
    }

    public static Rating delete(Connection conn, int rating_id) throws SQLException {
        String sql = "delete from public.ratings where user_id = " + rating_id;
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        Rating rating = null;

        while (result.next()) {
            rating = new Rating(result.getInt("rating_id"), result.getString("description"));
        }
        conn.close();

        return rating;
    }

    public static Rating update(Connection conn, Rating rating) throws Exception {
        String sql = "update from public.ratings where rating_id = " + rating.rating_id;
        sql += "set description = " + rating.description;

        PreparedStatement statement = conn.prepareStatement(sql);
        int rows = statement.executeUpdate();
        if (rows > 0) {
        } else {
            rating = null;
        }
        conn.close();

        return rating;
    }

}
