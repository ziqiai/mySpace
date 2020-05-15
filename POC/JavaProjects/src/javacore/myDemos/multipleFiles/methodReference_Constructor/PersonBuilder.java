package javacore.myDemos.multipleFiles.methodReference_Constructor;

@FunctionalInterface
public interface PersonBuilder {
    // 定义方法,根据传递的姓名创建Person对象
    Person buildPerson(String name);
}
