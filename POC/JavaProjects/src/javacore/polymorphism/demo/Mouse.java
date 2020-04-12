package javacore.polymorphism.demo;

public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("打开Mouse");
    }

    @Override
    public void close() {
        System.out.println("关闭Mouse");
    }

    public void click() {
        System.out.println("Mouse点击");
    }
}
