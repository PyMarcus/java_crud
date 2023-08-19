import config.Config;
import database.*;
import model.User;
import java.util.concurrent.ThreadLocalRandom;

public class Main{
    public static void main(String[] args){
        Database db = new Database();
        //select
        for(User u :db.selectAllUsers()){
            Config.log("id: " + u.getId() + " name: " + u.getName() + " email: " + u.getEmail(), "info");
        }
        //insert
        int id = ThreadLocalRandom.current().nextInt(999999999);
        db.createUser(new User("fulano", "fulano@email.com", id));

        //update
        db.updateUser(new User("alterado", "alterado@email.com", 1));

        //delete
        db.deleteUser(1);
    }
}