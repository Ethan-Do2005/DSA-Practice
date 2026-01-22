class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){

            int oddLen = palindromicLen(s, i, i);

            int evenLen = palindromicLen(s, i, i+1);

            maxLen = Math.max(oddLen, evenLen);

            if(maxLen > end - start){
                start = i - (maxLen-1)/2;
                end = i + maxLen/2;
            }
        }

        return s.substring(start, end + 1); 
    }

    private int palindromicLen(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}