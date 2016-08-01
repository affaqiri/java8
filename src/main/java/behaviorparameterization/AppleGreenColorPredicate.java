package behaviorparameterization;

public class AppleGreenColorPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }

}
