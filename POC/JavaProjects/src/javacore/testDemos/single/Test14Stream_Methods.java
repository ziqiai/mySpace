package javacore.testDemos.single;

import java.util.stream.Stream;

/*
* map方法: 将流中的元素映射到另一个流中(参数是Function接口) - Intermediate Operation
*       <R> Stream<R> map(Function<? super T, ? extends R> mapper);
*
* count方法: 用于统计流中元素的个数 - Terminal Operation
*       long count();
*
* limit方法: 对流进行截取,取用前几个 - Intermediate Operation
*       Stream<T> limit(long maxSize); //仅当集合长度大于参数时进行截取;否则不进行操作
*
* skip方法: 跳过前几个元素,取用后几个 - Intermediate Operation
*       Stream<T> skip(long n); // 若流的长度大于n,跳过前n个;否则得到长度为0的空流
*
* 静态方法concat: 把流合并到一起
*       static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b);
* */
public class Test14Stream_Methods {
    public static void main(String[] args) {
        String[] strArr = {"1", "2", "3", "4", "500"};
        // 使用map方法
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
        // 使用limit方法
        Stream<String> stream3 = Stream.of(strArr);
        Stream<String> stream3out = stream3.limit(3);
        stream3out.forEach(s -> System.out.println(s));
        System.out.println("======================");
        // 使用skip方法
        Stream<String> stream4 = Stream.of(strArr);
        stream4.skip(3).forEach(s -> System.out.println(s));
        System.out.println("======================");
        // 使用concat方法
        Stream<String> stream5_1 = Stream.of(strArr);
        Stream<String> stream5_2 = Stream.of("aaa", "bbb", "ccc");
        Stream.concat(stream5_2, stream5_1).forEach(s -> System.out.println(s));

    }
}
