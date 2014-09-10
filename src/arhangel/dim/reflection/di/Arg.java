package arhangel.dim.reflection.di;

/**
 *
 */
public class Arg {
    enum ArgType {
        VAL,
        REF
    }

    private ArgType type;
    private String value;

    public Arg(ArgType type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArgType getType() {
        return type;
    }

    public void setType(ArgType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Arg{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
