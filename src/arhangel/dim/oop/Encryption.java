package arhangel.dim.oop;

/**
 * Created on 13/08/14.
 */
public class Encryption {
    private Strategy strategy;

    public Encryption(Strategy strategy) {
        this.strategy = strategy;
    }

    public String encode(String str) {
        return strategy.algorithm(str);
    }
}
