package database;

import config.Config;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

class Settings {
        private String host;
        private String user;
        private String password;
        private String database;
        private int port;

    protected Settings(){
        try{
            Configurations setting = new Configurations();
            INIConfiguration iniConfig = setting.ini("database/credentials.ini");

            this.setHost(iniConfig.getString("developement.host"));
            this.setPassword(iniConfig.getString("developement.password"));
            this.setUser(iniConfig.getString("developement.user"));
            this.setDatabase(iniConfig.getString("developement.database"));
            this.setPort(iniConfig.getInt("developement.port"));

        }catch (Exception e){
            Config.log(e.toString(), "danger");
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
