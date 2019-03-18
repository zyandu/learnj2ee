package me.zy.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {
    private static Map<String, IEmployee> map = new HashMap<String, IEmployee>();

    static {
        map.put("前端", new EmployeeA());
        map.put("后台", new EmployeeB());

    }

    @Override
    public void doing(String command) {
        map.get(command).doing(command);
    }
}