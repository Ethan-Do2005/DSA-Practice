class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder();

        for(char digit : num.toCharArray()){
            while(k > 0 && result.length() > 0 && result.charAt(result.length() - 1) > digit){
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(digit);
        }

        //Ascending part
        while(k > 0){
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }

        return (result.isEmpty()) ? "0" : result.toString();
    }
}