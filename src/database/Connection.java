package database;

import config.Config;

class Connection{
    private Settings set;

    protected Connection(){
        set = new Settings();
    }

    protected void connection(){
        System.out.println(set.getHost());
    }
}