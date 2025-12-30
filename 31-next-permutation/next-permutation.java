class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        
        //Step 1
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        //Step 2
        if(i >= 0){
            int j = n - 1;
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }

        swapDescending(nums, i+1, n-1);    
    }

    private void swap(int[] nums, int i, int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swapDescending(int[] nums,int start,int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
/*
1.Finding the number outside number the descending part
2. Find an bigger number than outside number in descending part to swap
3. swap biggest and smallest number in descending part 

 0 1 2 3 4 5 6 7 8 9
[1,5,2,4,7,6,5,4,2,1]

*/