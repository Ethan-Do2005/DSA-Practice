class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for(int i =0; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                if(prefix.isEmpty()) return "";
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args){
        Solution s = new Solution();

        String test1 = s.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.print("Test 1" + test1);
    }
}