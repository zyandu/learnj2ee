package me.zy.pattern.prototype.simple;

import java.util.List;

public class SimpleConcreatePrototype implements SimplePrototype {
    private int age;
    private String name ;
    private List<String> places;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlaces() {
        return places;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }

    @Override
    public SimplePrototype clone() {
        SimpleConcreatePrototype scp = new SimpleConcreatePrototype();
        scp.setAge(this.age);
        scp.setName(this.name);
        scp.setPlaces(this.places);
        return scp;
    }
}
