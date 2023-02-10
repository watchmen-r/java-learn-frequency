package CodeCracking.chapter001;

public class Q006 {
    public String compressString() {
        String input = "aabcccccaaa";

        String[] inputArr = input.split("");
        StringBuilder builder = new StringBuilder();

        // this problem is also difficult to use stream api...
        int count = 1;
        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i].equals(inputArr[i - 1])) {
                count++;
            } else {
                builder.append(inputArr[i - 1]).append(count);
                count = 1;
            }

            if (i == inputArr.length - 1) {
                builder.append(inputArr[i - 1]).append(count);
            }
        }
        return input.length() > builder.toString().length() ? builder.toString() : input;
    }
}
