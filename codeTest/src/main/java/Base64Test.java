import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2019-01-14 14:27
 **/
public class Base64Test {

    public static void main(String args[]) {
        try {
            String charset = "utf-8";
            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString("lmn?java8".getBytes(charset));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("原始字符串: " + new String(base64decodedBytes, charset));
            base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes(charset));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes(charset);
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
