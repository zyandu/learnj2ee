package me.zy.adapter;

public class AwsSdkAdapter implements CloudSdk {
    //注入AwsSdk
    AwsSdk awsSdk;

    public AwsSdkAdapter(AwsSdk awsSdk) {
        this.awsSdk = awsSdk;
    }

    @Override
    public void putObject(String fileName) {
        awsSdk.putObject(fileName);
    }
}
