package me.zy.pattern.adapter;

import java.util.HashMap;
import java.util.Map;

public class CloudFactory {

    //这里可以用配置文件来获取
    //演示代码，没使用spring，用jdk代码实现
    static Map<String,CloudSdk> map = new HashMap<String, CloudSdk>();
    static {
        map.put("AWS",new AwsSdkAdapter(new AwsSdk()));
        map.put("Ali",new AliSdkAdapter(new AliSdk()));
    }

    public static CloudSdk getSdk(String cloudStrategy){
        return map.get(cloudStrategy);
    }
}
