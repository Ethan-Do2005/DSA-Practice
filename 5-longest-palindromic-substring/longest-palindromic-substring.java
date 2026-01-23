class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            
            int lenOdd = palindromicLen(s, i, i);
            int lenEven = palindromicLen(s, i, i+1);

            maxLen = Math.max(lenOdd, lenEven);
            if(maxLen > end - start){
                start = i - (maxLen-1)/2;
                end = i + maxLen/2;
            }
        }

        return s.substring(start,end +1);        
    }

    private int palindromicLen(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
}
/*
01234
babad
aba
maxLen = 3
i = 2
 start = 2 - (3-1)/2 = 1
 end = 2 + 3/2 = 3
Range s length
1 to 1000
s just consist of only digits and English letters

My approach for this one 

substring is even 
substring is odd

even
abba
odd 
aba
*/