package task151;

class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = split.length - 1; i > -1; i--) {
            if (!split[i].equals("")) {
                result.append(split[i]);
                result.append(" ");
            }
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }
}
