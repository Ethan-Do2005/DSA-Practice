class Solution {
    public int arraySign(int[] nums) {
        int sign = 1; // We created if it postive it flip into -1

        for(int num : nums){
            if(num == 0 ) return 0;
            else if( num < 0) sign = -sign; // flip -1 when freq is odd and flip into 1 when freq is even
        }
        return sign;
    }
}


