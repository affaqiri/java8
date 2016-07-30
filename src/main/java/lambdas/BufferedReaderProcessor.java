package lambdas;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ahmad on 06/10/15.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader br) throws IOException;

}