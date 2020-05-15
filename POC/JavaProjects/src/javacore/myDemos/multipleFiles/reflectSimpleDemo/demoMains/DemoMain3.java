package javacore.myDemos.multipleFiles.reflectSimpleDemo.demoMains;

import javacore.myDemos.multipleFiles.reflectSimpleDemo.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DemoMain3 {
    public static void main(String[] args) throws Exception {
        // 0. 获取Person的Class对象:
        Class personClass = Person.class;

        // 1. Method相关方法获取成员方法
        /* 获取成员方法们:
         *      Method[] getMethods()
         *      Method getMethod(String name, 类<?>... parameterTypes)
         *      Method[] getDeclaredMethods()
         *      Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         * */
        Method eatMethod = personClass.getMethod("eat");

        // 2. 执行方法对象 -- Object invoke(Object obj, Object... args)
        Person person = new Person();
        eatMethod.invoke(person);
        System.out.println("============================");

        // 执行带参数的成员方法
        Method eatMethod2 = personClass.getMethod("eat", String.class);
        eatMethod2.invoke(person, "steak");

        // 3. 获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) { // 这里的方法也可以使用method.setAccessible(true);强行反射
            System.out.println(method); // 会打印出包括自带隐藏的所有public方法
            String name = method.getName(); // 获取方法名称
            System.out.println("↑ name is -- " + name);
        }
        System.out.println("============================");

        // 4. 获取类名 -- String getName()
        String className = personClass.getName();
        System.out.println(className);
    }
}
