package lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ahmad on 06/10/15.
 */
public class ExecuteAround {

    public static void main(String[] args) throws IOException {

        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lambdas/data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor brp) throws IOException {
        // The Common Part
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lambdas/data.txt"))) {
            //The specific part (behavior) parameterized with the BufferedReaderProcessor interface
            return brp.process(br);
        }
    }

}