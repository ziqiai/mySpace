package javacore.myDemos.singleFile;

import java.util.function.Function;

public class Test12FunctionAndThen {
    // 把String类型的整数转换成Integer类型的整数,并把结果加10
    // 把增加之后的Integer类型结果,转换回String类型
    /*
    * 分析: 需要两个Function接口参数fun1,fun2
    *   Integer i = fun1.apply(s) + 10;
    *   String str = fun2.apply(i);
    * 组合方式:
    *   String str = fun1.andThen(fun2).apply(s);
    *   fun1先调用apply方法,将字符串转换为Integer
    *   fun2再调用apply方法,将Integer转换为字符串
    * */
    public static void method(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String str = fun1.andThen(fun2).apply(s);
        System.out.println(str);
    }

    public static void main(String[] args) {
        String s = "111112";
        method(s, str->Integer.parseInt(str) + 10, i->Integer.toString(i));
    }
}
