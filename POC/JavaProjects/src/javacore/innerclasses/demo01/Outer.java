package javacore.innerclasses.demo01;

public class Outer {

    public void methodOuter() {
        int num = 10;
        System.out.println("外部方法执行");

        class Inner {

            public void methodInner() {
                System.out.println(num);
            }
        }

        Inner inner = new Inner();
        inner.methodInner();
    }
}
