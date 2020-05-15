package javacore.myDemos.singleFile;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
* 任务:
* 给定 String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马儿扎哈,男", "赵丽颖,女"};
* 通过Predicate接口 从中筛选出: 同时满足 1.女性 2.姓名为4个字
*
* 分析:
*   使用两个Predicate接口
*   使用and连接连个判断条件
* */
public class Test10Predicate_Test {
    // 定义方法,参数传递数组和两个Predicate接口,用于筛选过滤
    // 结果保存到ArrayList集合中返回
    public static ArrayList<String> filter(String[] arr, Predicate<String> p1, Predicate<String> p2) {
        // 用于存储结果
        ArrayList<String> res = new ArrayList<>();
        // 获取arr中的字符串
        for (String s : arr) {
            // test筛选条件 使用and合并
            // 这里返回的是一个boolean值 需要接收
            boolean b = p1.and(p2).test(s);
            if (b) { // 如果同时满足两个条件,添加进入结果集合
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马儿扎哈,男", "赵丽颖,女"};
        // 调用方法,具体定义筛选的两个条件
        // lambda表达式其实重写的是接口中的唯一的抽象方法 唯一! 所以可以直接简写
        ArrayList<String> res = filter(arr,
                str->str.split(",")[1].equals("女"),
                str->str.split(",")[0].length() == 4);

        for (String s : res) {
            System.out.println(s);
        }
    }
}
