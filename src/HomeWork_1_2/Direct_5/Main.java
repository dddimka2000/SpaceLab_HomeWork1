package HomeWork_1_2.Direct_5;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String expression="hello world";
        System.out.println(expression);
        SecretKeySpec secretKeySpec = new SecretKeySpec("ThisIsASecureKey".getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] bytes = cipher.doFinal(expression.getBytes());
        for (byte d : bytes) {
            System.out.print(d);
        }
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        byte[] bytes1= cipher.doFinal(bytes);
        System.out.println();
        for (byte d : bytes1) {
            System.out.print((char) d);
        }
    }
}
