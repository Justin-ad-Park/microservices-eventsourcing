package commerce.cart.uuid;

import com.fasterxml.uuid.Generators;

public class TImeBasedUUID {
    public static String generateTimeBasedId() {
        return Generators.timeBasedGenerator().generate().toString();
    }

}
