class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0 ){

            //Remove space
            while(i >= 0 && s.charAt(i) == ' ') i--;
            if(i < 0) break;

            // Mark
            int j = i;
            while(i >= 0 && s.charAt(i) != ' ') i--;

            // Create a space for new res
            if(res.length() > 0) res.append(' ');

            //Add string into new res
            res.append(s, i+1, j+1);
        }

        return res.toString();

    }
}