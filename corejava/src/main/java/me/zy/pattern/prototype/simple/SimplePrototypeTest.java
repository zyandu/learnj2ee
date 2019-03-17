package me.zy.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class SimplePrototypeTest {
    public static void main(String[] args) {
        SimpleConcreatePrototype scp = new SimpleConcreatePrototype();
        scp.setName("lisi");
        scp.setAge(19);

        List list = new ArrayList<String>();
        list.add("cdd");
        scp.setPlaces(list);
        System.out.println(scp);

        Client c = new Client(scp);
        SimpleConcreatePrototype scpPrototype = c.startClone();
        System.out.println(scpPrototype);

        System.out.println(scp == scpPrototype);
        System.out.println(scp.getPlaces() == scpPrototype.getPlaces());

    }
}
