package optional;

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