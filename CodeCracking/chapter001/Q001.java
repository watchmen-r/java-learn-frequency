package CodeCracking.chapter001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Q001 {
    public boolean checkDuplicate() {
        String input = "sdfaet";

        String[] arr = input.split("");

        HashSet<String> set = Arrays.stream(arr).collect(Collectors.toCollection(HashSet::new));

        if (arr.length == set.size()) {
            return true;
        } else {
            return false;
        }
    }
}
