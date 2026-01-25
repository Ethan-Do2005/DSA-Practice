class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for(String str : strs){
            while(str.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
/*
Time O(S) : s is sum of all character 
Space O(1)
*/