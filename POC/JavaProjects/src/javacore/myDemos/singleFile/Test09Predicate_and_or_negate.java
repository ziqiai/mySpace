package javacore.myDemos.singleFile;

import java.util.function.Predicate;

/*
* Predicate接口中的and方法:"与"
*   连接两个判断条件
*       e.g. 长度大于5且包含a
* Predicate接口中的or方法:"或"
*   连接两个判断条件
*       e.g. 长度大于5或者包含a
* Predicate接口中的negate方法:"非"
*   连接两个判断条件
*       e.g. 长度不能大于5且不能包含a*
* */
public class Test09Predicate_and_or_negate {
    // and逻辑
    public static boolean checkString1(String s, Predicate<String> p1, Predicate<String> p2) {
        //return p1.test(s) && p2.test(s);
        return p1.and(p2).test(s);
    }

    // or逻辑
    public static boolean checkString2(String s, Predicate<String> p1, Predicate<String> p2) {
        //return p1.test(s) || p2.test(s);
        return p1.or(p2).test(s);
    }

    // negate逻辑
    public static boolean checkString3(String s, Predicate<String> p) {
        //return !p.test(s);
        return p.negate().test(s);
    }


    public static void main(String[] args) {
        // 检查字符串 and
        String s1 = "abcdefg";
        boolean res1 = checkString1(s1,
                (String str)->{
                    return str.length()>5;
                },
                (String str)->{
                    return str.contains("a");
                });
        System.out.println(res1);

        // 检查字符串 or
        String s2 = "bbbbbb";
        boolean res2 = checkString2(s2, str->str.length()>5, str->str.contains("a"));
        System.out.println(res2);

        // 检查字符串 negate
        String s3 = "abc";
        boolean res3 = checkString3(s3, str->str.length()>5);
        System.out.println(res3);
    }
}
