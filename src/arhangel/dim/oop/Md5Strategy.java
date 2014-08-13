package arhangel.dim.oop;

/**
 * Created on 13/08/14.
 */
public class Md5Strategy implements Strategy {
    @Override
    public String algorithm(String str) {
        return "MD5 crypt";
    }
}
