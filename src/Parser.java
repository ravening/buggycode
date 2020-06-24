import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Parser
 */
public class Parser {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/r.venkatesh/apilog.log";

        Stream<String> stream = Files.lines(Paths.get(fileName));
        stream.forEach(line -> {
            String[] words = line.split(" ");
            System.out.println(words[12]);
        });
        stream.close();
    }
}