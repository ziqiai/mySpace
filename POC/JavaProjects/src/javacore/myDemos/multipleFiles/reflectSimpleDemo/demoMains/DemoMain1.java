package javacore.myDemos.multipleFiles.reflectSimpleDemo.demoMains;

import javacore.myDemos.multipleFiles.reflectSimpleDemo.domain.Person;

import java.lang.reflect.Field;

public class DemoMain1 {
    public static void main(String[] args) throws Exception {
        // 0. 获取Person的Class对象,有如下三种方法:

        // 法一
        Class personClass = Person.class;
        // 法二
        // Class personClass = Class.forName("javacore.myDemos.multipleFiles.reflectSimpleDemo.domain.Person");
        // 法三
        // Person person = new Person();
        // Class personClass = person.getClass();


        // 1. Field相关方法获取成员变量

        /* 获取成员变量们:
         *      Field[] getFields()  获取所有public修饰的成员变量
         *      Field getField(String name)  获取指定名称的 public修饰的成员变量
         *      Field[] getDeclaredFields()  获取所有的成员变量,不考虑修饰符
         *      Field getDeclaredField(String name)
         * */
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("============================");

        // 1.1 获取指定名称的public修饰的成员变量a
        Field aaa = personClass.getField("a"); // 这里不是Field[]类型

        // 1.1.1 获取成员变量a的值 -- Object get(Object obj)
        Person p = new Person();
        Object value = aaa.get(p); // 默认初始化为null
        System.out.println(value);

        // 1.1.2 设置a的值 -- void set(Object obj, Object value)
        aaa.set(p, "Aimer");
        System.out.println(p);
        System.out.println("============================");

        // 1.1.3 访问非public的成员变量,忽略访问权限修饰符的安全检查 -- setAccessible(true): 暴力反射
        Field bbb = personClass.getDeclaredField("name");
        bbb.setAccessible(true); // 暴力反射
        Object value2 = bbb.get(p);
        System.out.println(value2);
    }
}
