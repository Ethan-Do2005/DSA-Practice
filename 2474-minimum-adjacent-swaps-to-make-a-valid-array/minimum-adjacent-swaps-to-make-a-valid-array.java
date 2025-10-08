class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int imin = 0;
        int imax = 0;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] < nums[imin]) imin = i;
        }

        for(int i = 0; i< nums.length; i++){
            if(nums[i] >= nums[imax]) imax = i;
        }

        int total = imin + (n - 1 - imax);
        if(imax < imin) total--;

        return total;
    }
}
/*
My idea:

total = step Min to leftmost + step Max to rightmost 
if(Max < Min) total - 1 // Check that min and min go through each other => duplicate step
return
*/