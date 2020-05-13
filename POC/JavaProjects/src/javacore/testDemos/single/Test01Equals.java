package javacore.testDemos.single;

import java.util.Objects;

public class Test01Equals { // Object类和Objects类 equals()方法相关

    public static void main(String[] args) {

//        String s1 = "abc";
        String s1 = null;
        String s2 = "abc";

//        boolean b1 = s1.equals(s2);
//        System.out.println(b1); // 空指针异常

        boolean b2 = Objects.equals(s1, s2);
        System.out.println(b2);
    }
}
