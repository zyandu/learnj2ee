package me.zy.springframe.web.servlet.v2;

import me.zy.springframe.strreotype.ZyAutoWired;
import me.zy.springframe.strreotype.ZyController;
import me.zy.springframe.strreotype.ZyRequestMapping;
import me.zy.springframe.strreotype.ZyService;
import me.zy.springframe.utils.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class ZyDispatcherServlet extends HttpServlet {
    private Properties contextConfig = new Properties();//保存配置文件
    private List<String> classNameList = new ArrayList<String>();//保存扫描到的所有的类名
    private Map<String,Object> iocContainer = new HashMap<String,Object>();//IOC容器，暂时不考虑并发安全问题
    private Map<String,Method> handlerMapping = new HashMap<String, Method>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception,Detail:"+Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String uri = req.getRequestURI();//绝对路径
        System.out.println("uri绝对路径是："+uri);

        String contextPath = req.getContextPath();//转换成相对路径
        uri = uri.replaceAll(contextPath,"").replaceAll("/+","/");
        System.out.println("转换之后的路径是："+uri);

        if(!this.handlerMapping.containsKey(uri)){
            resp.getWriter().write("404 Not Found.");
            return;
        }else{
            Method method = this.handlerMapping.get(uri);

            //通过反射拿到method所在的class,再拿到class name
            String beanName = method.getDeclaringClass().getSimpleName();
            Object obj = iocContainer.get(StringUtils.toFirstCharLowerCase(beanName));

            //这里供演示，所以写死
            //后面版本改成灵活获取
            Map<String,String[]> paramMap = req.getParameterMap();
            method.invoke(obj,new Object[]{req,resp,paramMap.get("name")[0]});

        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件（类路径下，下面的key配置在web.xml文件中servlet配置属性）
        doLoadconfig(config.getInitParameter("contextConfigLocation"));

        //2.扫描相关的类
        doScanner(contextConfig.getProperty("scanBasePackage"));

        //3.初始化扫描到的类，并且将他们放入到IOC容器中
        doInstance();

        //4.完成依赖注入
        doAutowired();

        //5.初始化HandlerMapping
        initHandlerMapping();

        //6.初始化完成，提供使用
        // doDispatch();
        System.out.println("初始化完成。。");

    }

    //加载配置文件
    private void doLoadconfig(String contextConfigLocation){
        System.out.println("doLoadconfig之contextConfigLocation~"+contextConfigLocation);

        //从类路径下找到Spring主配置文件所在的路径
        //并且以流形式读取到Properties对象中
        //相当于将配置文件读取到内存中
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);

        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null ){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //扫描类文件
    private void doScanner(String basePackageName){
        //me.zy.springframe.beans包名转换成文件路径名称
        URL url = this.getClass().getClassLoader()
            .getResource("/"+basePackageName.replaceAll("\\.","/"));
        File classpath = new File(url.getFile());
        for(File file:classpath.listFiles()){
            if(file.isDirectory()){
                doScanner(basePackageName+"."+file.getName());
            }else{
                if(!file.getName().endsWith(".class")){
                    continue;
                }

                String className = basePackageName+"."+file.getName().replace(".class","");
                classNameList.add(className);
            }

        }
    }

    //初始化
    private void doInstance(){
        //初始化，为DI做准备
        if(null == classNameList || classNameList.size() <=0){
            return;
        }

        try {
            for(String className:classNameList){
                Class<?> clazz = Class.forName(className);
                System.out.println("clazz.getName："+clazz.getName()+"~"+"clazz.getSimpleName："+clazz.getSimpleName());

                //加了注解的类才会被初始化
                //为了简化逻辑，只举例@ZyController和@ZyService，主要理解其思想
                if(clazz.isAnnotationPresent(ZyController.class)){
                    Object instance = clazz.newInstance();

                    //key:spring默认类名首字母小写
                    String beanName= clazz.getSimpleName();
                    String iocKey = StringUtils.toFirstCharLowerCase(beanName);
                    iocContainer.put(iocKey,instance);
                }else if(clazz.isAnnotationPresent(ZyService.class)){
                    //1.默认首字母小写（同ZyController逻辑）
                    String beanName = StringUtils.toFirstCharLowerCase(clazz.getSimpleName());
                    //2.自定义名称
                    ZyService service = clazz.getAnnotation(ZyService.class);
                    if(!StringUtils.isEmpty(service.value())){
                        beanName = service.value();
                    }
                    Object instance = clazz.newInstance();
                    iocContainer.put(beanName,instance);
                    //3.根据类型自动赋值
                    for(Class<?> i:clazz.getInterfaces()){
                        if(iocContainer.containsKey(i.getName())){
                            throw new RuntimeException("The name:"+i.getName()+" already be used.");
                        }

                        iocContainer.put(i.getName(),instance);
                    }
                }else{
                    continue;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doAutowired (){
        if(iocContainer.isEmpty()){
            return;
        }

        for(Map.Entry<String,Object> entry:iocContainer.entrySet()){
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for(Field field:fields){
                if(!field.isAnnotationPresent(ZyAutoWired.class)){
                    continue;
                }else{
                    ZyAutoWired zyAutoWired = field.getAnnotation(ZyAutoWired.class);
                    String beanName = zyAutoWired.value().trim();
                    //没有自定义名字，注：此处为判断首字母大小写
                    if("".equals(beanName)){
                        beanName = field.getType().getName();
                    }

                    try {
                        field.setAccessible(true);//强制访问
                        //用反射机制，动态给字段赋值
                        field.set(entry.getValue(),iocContainer.get(beanName));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //初始化url和method对应关系
    private void initHandlerMapping(){
        if(iocContainer.isEmpty()){return;}

        for (Map.Entry<String, Object> entry : iocContainer.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();//容器中实例
            if(!clazz.isAnnotationPresent(ZyController.class)){
                continue;
            }else{
                String baseUrl = "";
                if(clazz.isAnnotationPresent(ZyRequestMapping.class)){
                    ZyRequestMapping requestMapping = clazz.getAnnotation(ZyRequestMapping.class);
                    //注解在类上的url，完整请求路径为类上注释的路径+方法上注解的请求路径
                    baseUrl = requestMapping.value();
                }

                //首先获取所有的public方法
                for (Method method : clazz.getMethods()) {
                    if(method.isAnnotationPresent(ZyRequestMapping.class)){
                        ZyRequestMapping requestMapping = method.getAnnotation(ZyRequestMapping.class);
                        String url = (baseUrl + "/" + requestMapping.value())
                                .replaceAll("/+","/");//正则匹配，多个/或一个/替换成/
                        handlerMapping.put(url,method);
                    }
                }
            }
        }

    }

}
