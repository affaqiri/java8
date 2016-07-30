package optional;

/**
 * Created by ahmad on 04/10/15.
 */
public class Insurance {

    /**
     * An insurance company must have a name.
     */
    private String name;

    public Insurance() {
    }

    public Insurance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}