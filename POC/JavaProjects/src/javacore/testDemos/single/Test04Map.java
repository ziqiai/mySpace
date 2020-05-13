package javacore.testDemos.single;

import java.util.HashMap;
import java.util.Scanner;

public class Test04Map { // 计算字符串中每个字符出现的次数
    public static void main(String[] args) {
        // 1. 使用Scanner获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a String: ");
        String str = sc.next();
        // 2. map集合，key是字符串中的字符，value是字符个数
        HashMap<Character, Integer> map = new HashMap<>();
        // 3. 遍历字符串，获取每一个字符
        for (char c : str.toCharArray()) {
            // 4. 获取到的字符用于比较，判断map集合中key是否存在
            if (map.containsKey(c)) {
                // 字符对应的key能找到，value值加一
                Integer value = map.get(c);
                value++;
                map.put(c, value);
            } else {
                // 找不到key，直接放进map中，初始value为1
                map.put(c, 1);
            }
        }
        // 5. 遍历map集合输出结果
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("[" + key + ", " + value + "]");
        }
    }
}
