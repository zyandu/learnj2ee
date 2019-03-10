#### 单例模式适用场景
* 确保任何情况下只有一个单例：CEO、部门经理，提供一个全局访问点
* 常见单例类：ServletContext、ServletConfig、ApplicationContext、DBPool
#### 单例模式常见写法
* 饿汉式单例：在单例类首次加载时就创建实例
    * 浪费内存空间，不管用不用
    * 
```java
public class hungryStaticSingletion{
    public static final hungryStaticSingletion hungrySS= new hungryStaticSingletion（）；
    private hungryStaticSingletion(){}
    
    public hungryStaticSingletion getHungryStaticSingletion(){
        return hungrySS;
    }
}
```