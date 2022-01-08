package Model;

public class UserRating {
    public int user_id;
    public int rating_id;
    public String status;

    public UserRating(int user_id, int rating_id, String status){
        this.user_id = user_id;
        this.rating_id = rating_id;
        this.status = status;
    }
}
