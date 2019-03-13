package me.zy.pattern.adapter;

public class AliSdkAdapter implements CloudSdk {
    AliSdk aliSdk;

    public AliSdkAdapter(AliSdk aliSdk) {
        this.aliSdk = aliSdk;
    }

    @Override
    public void putObject(String fileName) {
        //aliSdk去适配CloudSdk一个方法
        aliSdk.setBucket("my bucket");
        aliSdk.uploadFile(fileName);
    }
}
