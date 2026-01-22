class Solution {
    public boolean canJump(int[] nums) {
        int finalPosition = nums.length -1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= finalPosition){
                finalPosition = i;
            }
        }

        return (finalPosition == 0);
    }
}

/*
My approach is: 
I will using greedy algorithms => get the best possible local and this will affect for global or the overall of the result
Last index
index   0 1 2 3 4
nums = [2,3,1,1,4]
last index = 3
final position = 4

3 + 1 = 4 
finalpost = 3
2 + 1 = 3
finalpost = 2
1 + 3 = 4 
finalpost = 1
if(index + nums[index] >= final position) => finalpost = i 
=> to next inedx

*/