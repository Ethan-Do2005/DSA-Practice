class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int product = 1;
        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }
}
/*
We will use the prefix and suffix currently 

nums = [1,2,3,4]

prefix = [1,1,2,6]

suffix = [24,12,4,1]


Output [24,12,8,6]

*/