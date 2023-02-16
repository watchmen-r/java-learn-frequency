package CodeCracking.chapter001;

// This problem is difficult
public class Q009 {
    public boolean isRotate() {
        String input1 = "yhn";
        String input2 = "nhy";

        if (input1.length() == input2.length()) {
            String concatInput1 = input1 + input1;
            // This function is indicated by the question.
            // return isSubstring(concatInput1, input2);
        }
        return false;
    }
}
