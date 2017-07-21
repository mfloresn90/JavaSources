package tokengeneration;

import java.security.SecureRandom;
import java.math.BigInteger;

public final class RandomString {

    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(80, random).toString(32);
    }
    
}
