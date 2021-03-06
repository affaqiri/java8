package optional;

import java.util.Optional;

public class OptionalUsage {

    public static void main(String[] args) {

        // Empty optional
        Optional<Car> emptyOptCar = Optional.empty();

        // Optional from a non-null value
        Car car = new Car();
        Optional<Car> nonNullOptCar = Optional.of(car);

        car = null;
        // Optional<Car> exceptionOptCar = Optional.of(car); //Immediate error in Of even before usage.

        // Optional from null
        Optional<Car> nullOptCar = Optional.ofNullable(car);

        Insurance insurance = new Insurance("GMF");

        // Getting the value of an optional with map
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> insuranceName = optInsurance.map(Insurance::getName);

    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person
                    .flatMap(Person::getCar)
                    .flatMap(Car::getInsurance)
                    .map(Insurance::getName)
                    .orElse("Unknown");

    }

}
