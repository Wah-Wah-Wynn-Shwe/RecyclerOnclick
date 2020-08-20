package com.example.jsonretro.Model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    public String id;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;



    public String getID(){
        return id;

    }
    public void setId(String id){
        this.id=id ;
    }


    public String getName(){
        return name;

    }
    public void setName(String name)
    {
        this.name=name ;
    }




    public String getUsername(){
        return username;

    }
    public void setUsername(String username){

        this.username=username ;
    }

}
