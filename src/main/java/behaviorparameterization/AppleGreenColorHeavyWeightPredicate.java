package behaviorparameterization;

public class AppleGreenColorHeavyWeightPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        return "green".equals(apple.getColor()) && apple.getWeight() > 150;
    }

}
