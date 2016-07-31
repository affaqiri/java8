package optional;

import java.util.Optional;

public class Person {

    /**
     * A person might or might not own a car.
     */
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

}