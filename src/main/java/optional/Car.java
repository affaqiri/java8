package optional;

import java.util.Optional;

/**
 * Created by ahmad on 04/10/15.
 */
public class Car {

    /**
     * A car might or might not be insured.
     */
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

}