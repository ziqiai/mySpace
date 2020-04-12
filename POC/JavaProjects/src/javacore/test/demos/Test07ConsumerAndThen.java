package javacore.test.demos;

import java.util.function.Consumer;

/*
* Consumer接口 默认方法andThen
* 作用:
*   需要两个或多个Consumer接口 可以将这些接口组合到一起 再进行消费
* 例如:
*   Consumer<String> con1;
*   Consumer<String> con2;
*   String s = "Hello";
*   con1.accept(s);
*   con2.accept(s);
*   //连接模式: con1.andThen(con2).accept(s); //谁在前面谁先消费
* */
public class Test07ConsumerAndThen {
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
        // con1.accept(s);
        // con2.accept(s);
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        method("Hello",
                (t)->{
                    System.out.println(t.toUpperCase());
                },
                (t)->{
                    System.out.println(t.toLowerCase());
                });
    }
}
