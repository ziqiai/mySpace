package javacore.testDemos.multipleFiles.MethodReference_Array;

public class DemoMain {
    // 定义方法,参数传递length和接口,方法内部创建指定长度的数组并返回
    public static int[] createArray(int length, ArrayBuilder ab) {
        return ab.buildArray(length);
    }

    public static void main(String[] args) {
        // 调用createArray方法,传递长度和Lambda表达式
        int[] arr1 = createArray(10, (len) -> {
           return new int[len];
        });
        System.out.println(arr1.length);
        // 简化Lambda:
        int[] arr2 = createArray(10, len -> new int[len]);
        System.out.println(arr2.length);
        // 方法引用: -- "<T>[]::new" 格式
        int[] arr3 = createArray(10, int[]::new);
        System.out.println(arr3.length);
    }
}
