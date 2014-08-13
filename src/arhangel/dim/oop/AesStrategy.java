package arhangel.dim.oop;

/**
 * Created on 13/08/14.
 */
public class AesStrategy implements Strategy {
    @Override
    public String algorithm(String str) {
        return "AES crypt";
    }
}
