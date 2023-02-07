package CodeCracking.chapter001;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q004 {
    public boolean permutationPalindrome() {
        String input = "Tact Coa";
        Optional<String> optLowCase = Arrays.stream(input.split(" ")).map(charString -> charString.toUpperCase())
                .reduce((result, element) -> {
                    return result + element;
                });

        Map<String, List<String>> map = Arrays.stream(optLowCase.get().split(""))
                .collect(Collectors.groupingBy(s -> s));
        // we can get this map like this '{A=[A, A], C=[C, C], T=[T, T], O=[O]}'
        System.out.println(map);
        
        // if the odd number is lower 2, the input is permutaion palindrome
        return map.entrySet().stream().filter(entry -> (entry.getValue().size() % 2 == 1)).count() < 2;
    }
}
