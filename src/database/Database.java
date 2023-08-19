package database;

import config.Config;
import model.User;
import java.sql.*;
import java.util.Vector;

public class Database{
    private Connection conn_read;
    private Connection conn_write;

    public Database(){
        ConnectionDatabase conn = new ConnectionDatabase();
        this.conn_read = conn.connection();
        Config.log("Create only read connection", "info");

        this.conn_write = conn.connection();
        Config.log("Create write connection", "info");
    }

    public Vector<User> selectAllUsers(){

        Vector<User> users = new Vector<>();

        final String SQL = "SELECT * FROM users;";
        Config.log(SQL, "info");
        try {
            Statement statement = this.conn_read.createStatement();
            ResultSet result = statement.executeQuery(SQL);

            while (result.next()){
                User user = new User(
                        result.getString("name"),
                        result.getString("email"),
                        result.getInt("id")
                );

                users.add(user);
            }

            Config.log("Items fetched: " + users.size(), "info");
            statement.close();
            this.conn_read.close();
            return users;
        } catch (SQLException e) {
            Config.log(e.toString(), "danger");
            return null;
        }
    }

    public boolean createUser(User user){
        final String SQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
        try{
            PreparedStatement statement = this.conn_write.prepareStatement(SQL);
            // parameters
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());

            int affected = statement.executeUpdate();
            if(affected > 0){
                Config.log("Created!", "info");
            }else{
                Config.log("Fail to create!", "info");
            }

            statement.close();
        }
        catch (SQLException e){
            Config.log(e.toString(), "danger");
        }
        return false;
    }

    public boolean updateUser(User user){
        final String SQL = "UPDATE users set name=?, email=? WHERE id=?;";
        try{
            PreparedStatement statement = this.conn_write.prepareStatement(SQL);
            // parameters
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());

            int affected = statement.executeUpdate();
            if(affected > 0){
                Config.log("Updated!", "info");
            }else{
                Config.log("Fail to updated!", "info");
            }

            statement.close();
        }
        catch (SQLException e){
            Config.log(e.toString(), "danger");
        }
        return false;
    }

    public boolean deleteUser(int id){
        final String SQL = "DELETE FROM users  WHERE id=?;";
        try{
            PreparedStatement statement = this.conn_write.prepareStatement(SQL);
            // parameters
            statement.setInt(1, id);

            int affected = statement.executeUpdate();
            if(affected > 0){
                Config.log("REMOVED!", "info");
            }else{
                Config.log("Fail to remove!", "info");
            }

            statement.close();
        }
        catch (SQLException e){
            Config.log(e.toString(), "danger");
        }
        return false;
    }
}

