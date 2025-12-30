class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        //Checking Whitespace
        int i = 0;
        int n = s.length();

        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        
        if(i == n) return 0;

        //Checking Signedness
        int sign = 1;
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }

        //Checking conversion
        int result =0;
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int digit = s.charAt(i) - '0';

            if(result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}