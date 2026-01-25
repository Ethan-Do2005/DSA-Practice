class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i >= 0){
            int j = n - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        
        swapPart(nums, i + 1, n - 1);

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swapPart(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start,end);
            start++;
            end--;
        }
    }
}
/*
[1,4,6,5,3,2]

+Making pivot 
is 4
+ Swap 4 with 5 
+ Swap descending part to ascending part 

Time and Space O(n) O(1)
*/