class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int countZero = 0;
        int maxLen = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                countZero++;
            }

            while(countZero > k){
                if(nums[left] == 0){
                    countZero--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
/*
[1,1,1,0,0,0,1,1,1,1,0]

right and left

*/