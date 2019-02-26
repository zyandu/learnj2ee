package me.zy.adapter;

public class CloudService {
    //AwsSdk awsSdk;
    //不再拘泥于AWS一种云，这里使用同一的接口类
    CloudSdk cloudSdk;
    public CloudService(String cloudStrategy) {
        this.cloudSdk = cloudSdk;
    }

    //处理具体的上传逻辑
    //原有代码
    //使用AWS流量比较贵，现在想切换到阿里云，同时保留原有逻辑不管
    //如果在下面代码中使用if else，非常不易扩展，也违反了开闭原则
    public void uploadFile(String fileName){
        //awsSdk.putObject(fileName);
        //这里使用同一接口的类来进行操作
        cloudSdk.putObject(fileName);
    }
}
