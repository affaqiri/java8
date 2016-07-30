package defaultmethods;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ahmad on 07/10/15.
 */
public class Game {

    public static void main(String[] args) {

        List<Resizable> resizableShapes = Arrays.asList(new Square(), new Rectangle(), new Ellipse());
        Utils.paint(resizableShapes);

    }

}