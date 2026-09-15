import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLength = words[0].length();
        int wordCount = words.length;
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int start = 0; start < wordLength; start++) {
            int left = start;
            int count = 0;
            HashMap<String, Integer> seen = new HashMap<>();
            for (int right = start; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);
                if (!wordMap.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wordLength;
                    continue;
                }
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;
                while (seen.get(word) > wordMap.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
                if (count == wordCount) {
                    ans.add(left);
                    String leftWord = s.substring(left, left + wordLength);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
            }
        }
        return ans;
    }
}