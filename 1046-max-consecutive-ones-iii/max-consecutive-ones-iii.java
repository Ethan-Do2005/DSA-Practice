class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int countZero = 0;
        int maxLength = 0;

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

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
/*
[1,1,1,0,0,0,1,1,1,1,0]

[1,1,1,0,0,0]
left =0
right =0
countZero = 3
if(nums[right] == 0) => right++;
while(countZero > k){
    if(nums[left] == 0){
        countZero--;
    }
    left++;
}

maxLength= math.max(right-left + 1);
*/