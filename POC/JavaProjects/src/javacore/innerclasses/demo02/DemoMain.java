package javacore.innerclasses.demo02;

public class DemoMain {

    public static void main(String[] args) {

        MyInterface obj = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类覆盖重写了抽象方法");
            }
        };

        obj.method();
    }
}
