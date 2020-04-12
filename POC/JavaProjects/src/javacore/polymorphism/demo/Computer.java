package javacore.polymorphism.demo;

public class Computer {

    public void powerOn() {
        System.out.println("笔记本开机");
    }

    public void powerOff() {
        System.out.println("笔记本关机");
    }

    public void useDevice(USB usb) {
        usb.open();
        if (usb instanceof Mouse) { // 先判断，之后向下转型
            Mouse mouse = (Mouse) usb;
            mouse.click();
        } else if (usb instanceof Keyboard) { // 先判断，之后向下转型
            Keyboard keyboard = (Keyboard) usb;
            keyboard.type();
        }
        usb.close();
    }
}
