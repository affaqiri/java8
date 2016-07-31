package optional;

import java.util.Optional;

public class Car {

    /**
     * A car might or might not be insured.
     */
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

}