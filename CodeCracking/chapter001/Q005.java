package CodeCracking.chapter001;

import java.util.Arrays;
import java.util.List;

public class Q005 {
    public boolean convertString() {
        String input1 = "pales";
        String input2 = "pale";

        if (input1.length() == input2.length()) {
            return checkOneEdit(input1, input2);
        } else if (input1.length() + 1 == input2.length()){
            return checkInsertChar(input2, input1);
        } else if (input1.length() - 1 == input2.length()) {
            return checkInsertChar(input1, input2);
        }
        return false;
    }

    private boolean checkOneEdit(String input1, String input2) {
        List<String> list1 = Arrays.asList(input1.split(""));
        List<String> list2 = Arrays.asList(input2.split(""));

        // can't use stream....
        boolean checkSecond = false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                if (checkSecond) {
                    return false;
                }
                checkSecond = true;
            }
        }
        return true;
    }

    private boolean checkInsertChar(String shortInput, String longInput) {
        String[] shortArr = shortInput.split("");
        List<String> longList = Arrays.asList(longInput.split(""));
        if (longList.size() - shortArr.length != 1) {
            return false;
        }
        return Arrays.stream(shortArr).allMatch(s -> longList.contains(s));
    }
}
