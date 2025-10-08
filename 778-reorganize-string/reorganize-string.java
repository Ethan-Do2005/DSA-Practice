class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        int maxCount = 0;
        int maxIndex = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > maxCount){
                maxCount = count[i];
                maxIndex = i;
            }
        }

        if(maxCount > (n+1) / 2) return "";

        char[] ans = new char[n];
        int index = 0;
        while(count[maxIndex]-- > 0){
            ans[index] = (char)('a' + maxIndex);
            index += 2;
        }

        for(int i = 0; i < 26; i++){
            while(count[i]-- > 0){
                if(index >= n) index = 1;
                ans[index] = (char)('a' + i);
                index += 2;
            }
        }

        return new String(ans);
        

        
    }
}
/*
My idea: 
Step 1: count freq

Step 2:Find the maxCount and maxIndex in count[]

Step 3: put biggest character in rearrange way

Step 4: put other character in
*/