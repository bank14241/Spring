package th.ac.kmutt.sit.MyFirstService.controller;

public class User{
    private int id;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}