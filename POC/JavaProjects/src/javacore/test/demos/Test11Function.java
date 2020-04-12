package javacore.test.demos;

import java.util.function.Function;

public class Test11Function {
    // 定义方法,参数传递一个字符串类型的整数,以及一个Function接口
    // 使用Function接口中的apply方法,将字符串类型的整数转换为Integer类型的整数
    public static void change(String s, Function<String, Integer> fun) {
        // 得到的是Function<T,R>中的R类型的结果: 将 T -> R
        Integer i = fun.apply(s); // 此处若直接用int类型,为"自当拆箱" Integer->int
        System.out.println(i);
    }

    public static void main(String[] args) {
        change("110", str->Integer.parseInt(str));
    }
}
