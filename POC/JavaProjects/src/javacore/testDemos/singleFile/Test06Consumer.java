package javacore.testDemos.singleFile;

import java.util.function.Consumer;

public class Test06Consumer {
    // 定义一个方法 参数传递一个字符串姓名和一个Consumer接口 泛型使用String
    public static void method(String name, Consumer<String> con) {
        // 使用Consumer接口消费name
        con.accept(name);
    }

    public static void main(String[] args) {
        // 调用方法 传递姓名字符串 另一个参数是Consumer接口 可以传递Lambda表达式
        method("abcde", (String name)->{
            // 对传递的字符串进行消费
            System.out.println(name);

            // 字符串反转
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
