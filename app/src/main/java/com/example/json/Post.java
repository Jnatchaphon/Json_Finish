package com.example.json;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Post {


    @SerializedName("actor")

    public JsonObject actor;

    public JsonObject getActor() {
        return actor;
    }

    public void setActor(JsonObject actor) {
        this.actor = actor;
    }
}
