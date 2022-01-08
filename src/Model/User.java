package Model;

public class User{
    public int user_id;
    public String user_name;
    public String email;
    public String password;
    public String phone;

    public User(int user_id, String user_name, String email, String password, String phone){
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.user_id = user_id;
    }

}