package javacore.myDemos.multipleFiles.reflectSimpleDemo.domain;

public class Person {
    private String name;
    private int age;

    public String a;
    public String b;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String a, String b) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("eating...");
    }

    public void eat(String food) {
        System.out.println("eating " + food);
    }
}
