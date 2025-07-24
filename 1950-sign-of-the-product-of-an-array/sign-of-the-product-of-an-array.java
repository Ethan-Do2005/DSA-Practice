class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;

        for(int num : nums ){
            if(num == 0) return 0;
            if (num < 0) sign = -sign;
        }

        return sign;
    }
}
/*
Create a signFunct(x)
with if x > 0 return 1 
    else if x < 0 return -1
    else return 0;
*/