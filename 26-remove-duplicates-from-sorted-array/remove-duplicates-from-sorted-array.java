class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1;

        for(int right = 1; right < nums.length; right++){
            if(nums[right - 1] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }
}


/*
Tie complexity 0(n)
int new array arr
int i = 0; j = 0
for i loop
    if(nums[i] != nums[j]){
        
    }
    else if (nums[i] == nums[j]){
        nums[i] = 
    }

[0,0,1,1,1,1,2,3,3,4,4,4,4]

i = 2;
for
j=3
1 != 0
nums[1] = nums[2];
*/