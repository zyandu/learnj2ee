package me.zy.reflect;

import java.util.List;

public class PropertiesList {
    private String name;
    private List<Rmrk> rmrkList;
    private Hard hard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rmrk> getRmrkList() {
        return rmrkList;
    }

    public void setRmrkList(List<Rmrk> rmrkList) {
        this.rmrkList = rmrkList;
    }

    public Hard getHard() {
        return hard;
    }

    public void setHard(Hard hard) {
        this.hard = hard;
    }
}
