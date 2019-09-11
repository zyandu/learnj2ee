package me.zy.lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class FirstDemo {
    public static void main(String[] args) {
        //空括号()表示没有参数
        // 实现了Runnable接口，该接口只有一个run方法，无参且返回类型为void
        Runnable noArguments = () -> System.out.println("Hello World.");

        //只有一个参数event，可省略参数的括号
        ActionListener oneArgument = event -> System.out.println("button clicked");

        //Lambda表达式主题不仅仅可以是一个表达式，也可以是一段代码块
        //代码块和普通方法遵循的规则别无二致，可以返回或抛异常退出
        //只有一行代码的Lambda表达式也可以使用大括号，明确从哪开始到哪结束
        Runnable multiStatement = () -> {
            System.out.println("Htllo");
            System.out.print(" World.");
        };

        //创建一个函数，用来计算两个数字相加的结果
        BinaryOperator<Long> add = (x,y) -> x + y;
        //上面Lambda表达式中参数类型都是由编译器推断得来的
        //有时最好可以显式声明参数类型，此时需要使用小括号将参数(一个或多个)括起来
        BinaryOperator<Long> addExplicit = (Long x,Long y) -> x + y;

    }
}
