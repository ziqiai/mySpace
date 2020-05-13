package javacore.testDemos.multipleFiles.MethodReference;

public class DemoMain {
    // 定义一个方法,参数传递PrintInterface接口,对字符串进行打印
    public static void printString(PrintInterface p) {
        p.print("HelloMethodReference");
    }

    public static void main(String[] args) {
        // 这里调用printString方法,其参数为函数式接口,可以传递Lambda表达式
        printString(s -> System.out.println(s)); // 使用Lambda表达式的方案

        /*
         * 分析:
         *       使用Lambda表达式时,实际上传递进去的代码就是一种解决方案: 用什么参数进行什么操作
         *       本例中Lambda表达式的目的是打印参数传递的字符串,实际上是把参数s传递给了System.out对象,调用out对象中的println方法
         *
         * 本例中的Lambda表达式可以优化的前提:
         *       1. System.out对象已经存在
         *       2. println方法已经存在
         *       所以可使用System.out方法直接引用(调用)println方法
         *
         * 解决冗余的Lambda应用场景:
         *       双冒号::为引用运算符,而它所在的表达式被称为方法引用
         *       如果Lambda要表达的"方案"已经存在于某个方法的实现中,则可通过双冒号来引用该方法,直接作为Lambda的替代
         * */
        printString(System.out::println); // 优化后的输出方案
    }
    // 方法引用 可以看作是Lambda的孪生兄弟,也可以依据"可推导即可省略"原则,无需指定参数类型,也无需指定的重载形式-->这些都将被自动推导
}
