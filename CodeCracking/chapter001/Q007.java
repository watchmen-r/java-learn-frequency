package CodeCracking.chapter001;


// Difficult to implement, but there may be many similar questions..
public class Q007 {
    public int[][] matrixRotate() {
        int[][] input = { { 87, 54, 67 }, { 76, 92, 48 }, { 6, 9, 8 } };

        // To check the input data is correct format
        if (input.length == 0 || input.length != input[0].length) {
            return null;
        }

        for (int i = 0; i < input.length / 2; i++) {
            int first = i;
            int last = input.length - 1 - i;

            for (int j = first; j < last; j++) {

                int offset = j - first;
                int top = input[first][j];

                input[first][j] = input[last][first];

                input[last][first] = input[last][last - offset];

                input[last][last - offset] = input[j][last];

                input[j][last] = top;
            }
        }
        return input;
    }
}
