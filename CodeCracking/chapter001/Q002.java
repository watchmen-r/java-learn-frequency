package CodeCracking.chapter001;

import java.util.Arrays;
import java.util.Optional;

public class Q002 {
    public boolean checkPermutation() {
        String input1 = "qwerty";
        String input2 = "ytrewq";

        String[] inputArr1 = input1.split("");
        String[] inputArr2 = input2.split("");

        Optional<String> reduceValue1 = Arrays.stream(inputArr1).sorted().reduce((result, element) -> {
            return result + element;
        });
        Optional<String> reduceValue2 = Arrays.stream(inputArr2).sorted().reduce((result, element) -> {
            return result + element;
        });

        System.out.println(reduceValue1.get());

        return reduceValue1.get().equals(reduceValue2.get());
    }
}
