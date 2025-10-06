class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        String s1 = s.toLowerCase();
        String t1 = t.toLowerCase();

        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s1.charAt(i) - 'a']++;
            count[t1.charAt(i) - 'a']--;
        }

        for(int value : count){
            if(value != 0) return false;
        }
        return true;
    }
}
/*
counting logic
*/