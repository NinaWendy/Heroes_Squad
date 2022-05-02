package models;

import java.util.ArrayList;

public class Hero {
    private int id;
    private String name;
    private int age;
    private String squad;
    private String strength;
    private String weakness;
    private String description;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, int age, String squad, String strength, String weakness, String description) {
        this.name = name;
        this.age = age;
        this.squad = squad;
        this.strength = strength;
        this.weakness = weakness;
        this.description = description;
        instances.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void update(String name,int age,String squad,String strength, String weakness, String description) {
        this.name = name;
        this.age = age;
        this.squad = squad;
        this.strength = strength;
        this.weakness = weakness;
        this.description = description;
    }
}
