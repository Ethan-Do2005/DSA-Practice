class Solution {
    public int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxCount = 0;

        for(int right = 0; right < str.length(); right++){
        while(set.contains(str.charAt(right))){
            set.remove(str.charAt(left));
            left++;
        }
        set.add(str.charAt(right));
        maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
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