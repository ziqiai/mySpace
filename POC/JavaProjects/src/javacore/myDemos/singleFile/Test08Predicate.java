package javacore.myDemos.singleFile;

import java.util.function.Predicate;

public class Test08Predicate {
    // 定义一个方法 参数传递String字符串和一个Predicate接口
    // 使用predicate接口中的test方法对字符串进行判断 并返回结果
    public static boolean checkString(String s, Predicate<String> p) {
        return p.test(s);
    }

    public static void main(String[] args) {
        String s = "abcde";
        // 检查字符串长度
        /*boolean res = checkString(s, (String str)->{
           return str.length()>5;
        });*/
        boolean res = checkString(s, str->str.length()>5);
        System.out.println(res);
    }
}
