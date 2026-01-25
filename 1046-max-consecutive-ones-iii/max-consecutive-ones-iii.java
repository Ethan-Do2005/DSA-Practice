class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int countZero = 0;
        int maxLen = 0;

        while(r < nums.length){
            if(nums[r] == 0){
                countZero++;
            }

            while(countZero > k){
                if(nums[l] == 0){
                    countZero--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
/*

*/