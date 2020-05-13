package javacore.testDemos.single;

import java.util.function.Supplier;

public class Test05Supplier {
    // 使用Supplier接口作为方法参数类型 通过Lambda表达式求出int数组中的最大值
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {100, 0, 50, 88, 90, -33};
        int res = getMax(()->{
            // get the Max
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("max is " + res);
    }
}
