package tokengeneration;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * This program generates a Cifrar key, retrieves its raw bytes, and then
 * reinstantiates a Cifrar key from the key bytes. The reinstantiated key is
 * used to initialize a Cifrar cipher for encryption and decryption.
 *
 * @author Kinemi Solutions
 */
public class Cifrar {

    /**
     * Turns array of bytes into string
     *
     * @param buf Array of bytes to convert to hex string
     * @return	Generated hex string
     */
    public static String asHex(byte[] buf) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    public static String cifraAES(String message) {
        String myKey = "7215ee9c7d9dc22i";
        String rsltAES = "";

        try {
            byte[] raw = myKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            // Instantiate the cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] encrypted = cipher.doFinal(message.getBytes());
            rsltAES = asHex(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsltAES;
    }

    public static String getMD5(String input) {
        String res = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(input.getBytes());
            byte[] md5 = algorithm.digest();
            String tmp = "";
            for (int i = 0; i < md5.length; i++) {
                tmp = (Integer.toHexString(0xFF & md5[i]));
                if (tmp.length() == 1) {
                    res += "0" + tmp;
                } else {
                    res += tmp;
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

}
