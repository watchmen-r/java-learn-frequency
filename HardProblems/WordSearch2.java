import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {
    }
}

class WordSearch2 {
    char[][] _board = null;
    List<String> _result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // construct the trie(トライ木)
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            // store words in Trie
            node.word = word;
        }

        _board = board;

        // start backtracking
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return _result;
    }

    void backtracking(int row, int col, TrieNode parent) {
        Character letter = _board[row][col];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null) {
            _result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the exploration
        _board[row][col] = '#'';

        int[] rowOffset = { -1, 0, 1, 0 };
        int[] colOffset = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= _board.length || newCol < 0
                    || newCol >= _board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(_board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        // End of exploration, restore the original letter in the board
        _board[row][col] = letter;

        if(currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}