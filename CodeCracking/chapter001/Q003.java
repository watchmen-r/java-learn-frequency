package CodeCracking.chapter001;

import java.util.Arrays;
import java.util.Optional;

public class Q003 {
    public String urlfy() {
        String input = "Mr John  Smith  ";
        Optional<String> value = Arrays.stream(input.split(" ")).reduce((result, element) -> {
            return result + "%20" + element;
        });
        return value.get();
    }
}
