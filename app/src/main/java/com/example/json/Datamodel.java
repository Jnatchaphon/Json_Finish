package com.example.json;

public class Datamodel {
    Integer id;
    String display;
    String url;
    String login;
    String img;



    public Datamodel(Integer id, String login, String display, String url, String img){
        this.id = id;
        this.login = login;
        this.url = url;
        this.display = display;
        this.img = img;

    }

    public Integer getId() {
        return id;
    }

    public String getDisplay() {
        return display;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getImg() {
        return img;
    }
}
