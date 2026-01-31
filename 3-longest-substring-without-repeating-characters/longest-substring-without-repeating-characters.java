class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int j = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }

            maxLen = Math.max(maxLen, i - j + 1);
            set.add(s.charAt(i));
        }

        return maxLen; 
    }
}
/*
Constrains
lowercase or Uppsecase 
=> both
Range length
0 to 5 * 10^4

My approach: HashSet + for loop
abcabcbb
i = 3; = a
j = 1
Set{ b,c,a}
*/