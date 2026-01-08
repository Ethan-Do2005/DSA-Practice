class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0; 
        int left = 0;
        int countingZero = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                countingZero++;
            }

            while(countingZero > k){
                if(nums[left] == 0){
                    countingZero--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}