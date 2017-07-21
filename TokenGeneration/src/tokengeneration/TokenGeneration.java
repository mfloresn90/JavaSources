package tokengeneration;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dark_
 */
public class TokenGeneration {

    private final SecureRandom random = new SecureRandom();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Object> payload = new HashMap<String, Object>();
        RandomString rs = new RandomString();

        payload.put("uid", "");
        payload.put("some", "");
        payload.put("data", "");
        
        String rString = rs.nextSessionId();

        TokenGenerator tokenGenerator = new TokenGenerator(rString);

        String token = tokenGenerator.createToken(payload);

        System.out.println("-------------------------------");
        System.out.println(token);
        System.out.println("-------------------------------");
        System.out.println(rString);
        
        if (1 == 1) {
            System.out.println("hola");
        }
        
        System.out.println(Cifrar.getMD5("admin123"));

    }

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

}
