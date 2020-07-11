package com.example.json;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("type")

    public String type;


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


}
