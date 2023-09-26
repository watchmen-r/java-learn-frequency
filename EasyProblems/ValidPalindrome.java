class Solution {
    public boolean isPalindrome(String s) {
        char[] cArr = s.toCharArray();
        var builder = new StringBuilder();
        for (char c: cArr) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        String exludedString = builder.toString();
        String lower = exludedString.toLowerCase();
        
        for (int i = 0; i < lower.length() / 2; i++) {
            if (lower.charAt(i) != lower.charAt(lower.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
