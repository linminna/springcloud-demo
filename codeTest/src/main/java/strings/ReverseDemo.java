package strings;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-04-12 09:01
 **/
public class ReverseDemo {
    public static void main(String[] args) {
        String s = "abc123";
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
        System.out.println("----------------");

        System.out.println("变换前: " + s);
        /*System.out.println("变换后: " + reverse1(s));
        System.out.println("变换后: " + reverse2(s));
        System.out.println("变换后: " + reverse3(s));*/
        System.out.println("变换后: " + reverse(s));
    }

    // StringBuffer
    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // toCharArray
    public static String reverse2(String str) {
        char[] chars = str.toCharArray();
        String reverse = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse += chars[i];
        }
        return reverse;
    }

    public static String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    // charAt
    public static String reverse3(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
