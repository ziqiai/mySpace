package javacore.test.demos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test02DateFormat {

    public static void main(String[] args) throws Exception {
        method01();
        function();
    }

    public static void method01() {
        Date date = new Date(1234567890123L);
        System.out.println(date);
    }

    // 计算一个人出生了多少天...等等
    public static void function() throws Exception {
        System.out.println("输入出生日期，格式YYYY-MM-dd(请使用-分隔):");
        String birthdayStr = new Scanner(System.in).next();
        // 创建对象，确定日期格式
        SimpleDateFormat myDate = new SimpleDateFormat("yyyy-MM-dd");
        // 调用parse方法，将字符串转换成日期
        Date birthDay = myDate.parse(birthdayStr);
        // 获取今天日期
        Date today = new Date();
        // 计算出生了多少天
        long timeSpan = today.getTime() - birthDay.getTime();
        if (timeSpan < 0) {
            System.out.println("错误数据，还没出生");
        } else {
            System.out.println("你已经出生了: " + timeSpan / 1000 / 60 / 60 / 24 + " 天");
            System.out.println("你已经出生了: " + timeSpan / 1000 / 60 / 60 + " 小时");
        }
    }
}
