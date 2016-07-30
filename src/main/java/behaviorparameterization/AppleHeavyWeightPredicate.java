package behaviorparameterization;

/**
 * Created by ahmad on 06/10/15.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {

    public boolean test(Apple apple) {

        return apple.getWeight() > 150;

    }

}