package behaviorparameterization;

/**
 * Created by ahmad on 06/10/15.
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }

}