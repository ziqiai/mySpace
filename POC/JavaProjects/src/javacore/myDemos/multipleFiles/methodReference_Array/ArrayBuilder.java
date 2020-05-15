package javacore.myDemos.multipleFiles.methodReference_Array;

@FunctionalInterface
public interface ArrayBuilder {
    // 创建指定长度的int数组
    int[] buildArray(int length);
}
