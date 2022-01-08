import java.sql.*;


public class App {

    static String jdbcURL = "jdbc:postgresql://abul.db.elephantsql.com/hpdwloxg";
    static String username = "hpdwloxg";
    static String password = "OfWBJdYcHeJLn367ZIDamnxc0cTamCmy";
    public static void main(String[] args) throws Exception {
        checkDriver();
        Connection conn = connect();
        post(conn);
    }

    public static void checkDriver(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Driver err !");
        }
    }

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

    public static void login(){


    }

    public static Connection connect(){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected !");
            return connection;
        } catch (SQLException e){
            System.out.println("Error !");
            e.printStackTrace();
        }   ;
        return null;
    }
}
