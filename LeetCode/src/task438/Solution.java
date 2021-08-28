package task438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        final List<Integer> result = new ArrayList<>();
        Map<Character, Integer> sCountMap = new HashMap<>();
        Map<Character, Integer> pCountMap = new HashMap<>();

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            sCountMap.put(sChars[i], sCountMap.getOrDefault(sChars[i], 0) + 1);
            pCountMap.put(pChars[i], pCountMap.getOrDefault(pChars[i], 0) + 1);
        }

        int count = 0;
        for (char ch: pCountMap.keySet()) {
            count += Math.abs(sCountMap.getOrDefault(ch, 0) - pCountMap.getOrDefault(ch, 0));
        }

        System.err.println(count);
        for (int i = p.length(), start = 0; i < s.length(); i++, start++) {
            if (count == 0) {
                result.add(start);
            }
            sCountMap.put(sChars[start], sCountMap.get(sChars[start]) - 1);
            sCountMap.put(sChars[i], sCountMap.getOrDefault(sChars[i], 0) + 1);
            count += sCountMap.getOrDefault(sChars[i], 0) - pCountMap.getOrDefault(sChars[i], 0);
            System.err.println(count);
            System.err.println(s.substring(start + 1, i + 1));
        }

        if (count == 0) {
            result.add(s.length() - p.length());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}
