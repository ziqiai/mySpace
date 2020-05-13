package javacore.testDemos.multipleFiles.MethodReference_Constructor;

public class DemoMain {
    // 定义方法,参数中传递name和PersonBuilder接口,方法中通过姓名创建并打印对象
    public static void printName(String name, PersonBuilder pb) {
        Person person = pb.buildPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        // 主函数中调用printName方法,其参数是函数式接口,可传递Lambda
        printName("aimer", (String name) -> {
            return new Person(name);
        });
        // 简化:
        printName("loves", name -> new Person(name));
        // 方法引用: -- "类名称::new" 格式
        printName("banana fish", Person::new);
    }
}
