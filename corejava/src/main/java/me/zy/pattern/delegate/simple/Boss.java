package me.zy.pattern.delegate.simple;

public class Boss {

    public void command(Leader leader,String command){
        leader.doing(command);
    }
}

