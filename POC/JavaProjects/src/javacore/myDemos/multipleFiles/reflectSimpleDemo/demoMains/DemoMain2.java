package javacore.myDemos.multipleFiles.reflectSimpleDemo.demoMains;

import javacore.myDemos.multipleFiles.reflectSimpleDemo.domain.Person;

import java.lang.reflect.Constructor;

public class DemoMain2 {
    public static void main(String[] args) throws Exception {
        // 0. 获取Person的Class对象:
        Class personClass = Person.class;

        // 1. Constructor相关方法获取构造方法
        /* 获取构造方法们:
         *      Constructor<?>[] getConstructors()
         *      Constructor<T> getConstructor(类<?>... parameterTypes)
         *      Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         *      Constructor<?>[] getDeclaredConstructors()
         * */
        Constructor constructor = personClass.getConstructor(String.class, int.class); // 注意写法,后加.class
        System.out.println(constructor);
        System.out.println("============================");

        // 2. 创建对象 -- T newInstance(Object... initargs)
        // Person person = (Person) constructor.newInstance("Aimer", 18);
        Object person = constructor.newInstance("Aimer", 18); // 注意这里的类型是Object,其他需要cast强转
        System.out.println(person);
        System.out.println("============================");

        // 如果使用空参数构造方法创建对象,操作可以简化: 使用Class对象的newInstance方法
        Object kong = personClass.newInstance();
        System.out.println(kong);

    }
}
