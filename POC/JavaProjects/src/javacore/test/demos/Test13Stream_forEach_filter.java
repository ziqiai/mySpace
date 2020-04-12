package javacore.test.demos;

import java.util.stream.Stream;

/*
 * Stream流中的终结(Terminal Operation)方法 forEach
 *   逐一处理,常用来进行遍历
 *   void forEach(Consumer<? super T> action);
 *   接收一个Consumer接口函数,会将每一个流元素交给该函数进行处理
 *
 * Stream流中的延迟(Intermediate Operation)方法 filter:
 *   将一个流转换成另一个子集流
 *   Stream<T> filter(Predicate<? super T> predicate);
 *   该接口接收一个Predicate函数式接口参数(可以是一个Lambda或方法引用)作为筛选条件,对数据进行过滤
 *
 * */
public class Test13Stream_forEach_filter {
    public static void main(String[] args) {
        // 获取流 <- 数组
        String[] arr = {"aa", "bbb", "cccc", "adddd"};
        Stream<String> stream1 = Stream.of(arr);
        Stream<String> stream2 = Stream.of(arr);
        // 遍历
        stream1.forEach(str -> System.out.println(str));
        System.out.println("=====================");
        // 过滤 并且遍历打出
        // 注意此时不能再使用stream1了 因为它已经调用了终结方法!!!
        Stream<String> streamOut = stream2.filter((String s) -> {return s.startsWith("a");});
        streamOut.forEach(str -> System.out.println(str)); // 同样这里不能用stream2了
        // 连写:
        // stream2.filter(s -> s.startsWith("a")).forEach(str -> System.out.println(str));
    }
}
