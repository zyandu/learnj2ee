package me.zy.adapter;

public class AliSdk{
    public void setBucket(String bucket){
        System.out.println("Ali oss Bucket:"+bucket);
    }

    public void uploadFile(String fileName){
        System.out.println("Ali oss upload:"+fileName);
    }
}
