package me.zy.pattern.prototype.simple;

public class Client {
    private SimpleConcreatePrototype scp ;
    public Client(SimpleConcreatePrototype scp){
        this.scp = scp;
    }

    public SimpleConcreatePrototype startClone(){
        return (SimpleConcreatePrototype)scp.clone();
    }
}
