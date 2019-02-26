package me.zy.adapter;

public class CloudController {
    CloudService cloudService ;

    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    /**
     * 将文件上传到云服务器上
     */
    public void storeFileToCloud(){
        cloudService.uploadFile("data.zip");
    }

    //测试适配器是否生效DEMO
    public static void main(String[] args) {
        CloudController cc = new CloudController(new CloudService("Ali"));
        cc.storeFileToCloud();
    }

}
