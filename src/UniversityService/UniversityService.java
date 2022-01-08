package UniversityService;

import java.sql.*;
import java.util.ArrayList;

import Model.University;

public class UniversityService {
    
    public static University post(Connection conn, University university) throws SQLException{
        String sql = "insert into public.universities (university_id, name) values (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql); 

        statement.setInt(1, university.university_id);
        statement.setString(2, university.name);

        int rows = statement.executeUpdate();
        if (rows > 0){
        } else {
            university = null;
        }
        conn.close();
        return university;
    }

    public static ArrayList<University> getAll(Connection conn) throws SQLException{
        String sql = "select * from public.universities";
        PreparedStatement statement = conn.prepareStatement(sql); ;
        ResultSet result = statement.executeQuery();
        ArrayList<University> selectedUniversities = new ArrayList<>();

        while (result.next()){
            selectedUniversities.add(new University(result.getInt("university_id"), result.getString("name")));
        }
        conn.close();
        return selectedUniversities;
    }
    
    public static University get(Connection conn, int university_id) throws SQLException{
        String sql = "select * from public.universities where university_id = "  + university_id;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        University rating = null;

        while (result.next()){

            rating = new University(result.getInt("university_id"), result.getString("name"));
        }
        conn.close();

        return rating;
    }

    public static University delete(Connection conn, int university_id) throws SQLException{
        String sql = "delete from public.universities where university_id = "  + university_id;
        PreparedStatement statement = conn.prepareStatement(sql); 
        ResultSet result = statement.executeQuery();
        University rating = null;

        while (result.next()){
            rating = new University(result.getInt("university_id"), result.getString("name"));
        }
        conn.close();

        return rating;
    }

    public static University update(Connection conn, University university) throws Exception{
        String sql = "update from public.universities where university_id = "  + university.university_id;
        sql += "set name = " + university.name;
        
        PreparedStatement statement = conn.prepareStatement(sql); 
        int rows = statement.executeUpdate();
        if (rows > 0){
        } else {
            university = null;
        }
        conn.close();

        return university;
    }
}
