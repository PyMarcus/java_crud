package database;

public class Database{
    private Connection conn_read;

    public Database(){
        conn_read = new Connection();
        conn_read.connection();
    }

}

