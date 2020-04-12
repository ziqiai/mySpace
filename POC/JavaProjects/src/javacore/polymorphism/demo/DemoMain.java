package javacore.polymorphism.demo;

public class DemoMain {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.powerOn();
        // 向上转型
        USB usbMouse = new Mouse();
        computer.useDevice(usbMouse);

        Keyboard keyboard = new Keyboard();
        computer.useDevice(keyboard); // 这里也是向上转型
        // computer.useDevice(new Keyboard()); // 同样是向上转型

        computer.powerOff();
    }
}
