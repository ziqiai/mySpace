package javacore.test.demos;

import java.util.stream.Stream;

/*
* map方法: 将流中的元素映射到另一个流中(参数是Function接口) - Intermediate Operation
*       <R> Stream<R> map(Function<? super T, ? extends R> mapper);
*
* count方法: 用于统计流中元素的个数 - Terminal Operation
*       long count();
*
* limit方法: 对流进行截取,取用前几个 - Intermediate Operation
*
* */
public class Test14Stream_Methods {
    public static void main(String[] args) {
        String[] strArr = {"1", "2", "3", "4", "50"};
        Stream<String> stream1 = Stream.of(strArr);
        // 使用map方法将字符串类型的数据,转换(映射)成为Integer类型的数据
        Stream<Integer> stream1int = stream1.map((String s) -> {
            return Integer.parseInt(s);
        });
        stream1int.forEach(s -> System.out.println(s));
        System.out.println("======================");
        // 使用count方法
        Stream<String> stream2 = Stream.of(strArr);
        System.out.println(stream2.count());
        System.out.println("======================");
    }
}
