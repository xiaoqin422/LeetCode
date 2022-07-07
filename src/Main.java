import java.util.*;

/**
 * 类名: Main
 * 创建日期: 2022年05月19日 19:29
 *
 * @author: 秦笑笑
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            count += Math.abs(chars[i] - chars[i -1]) >= 25 ? 1 : Math.abs(chars[i] - chars[i -1]) ;
        }
        System.out.println(count);
    }

}