class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        for(int i = 1; i < nums.length;i++){
            prefix[i]= nums[i-1] * prefix[i-1];
            System.out.print(prefix[i]);
        }
        System.out.println("next");

        suffix[nums.length-1] = 1;
        for(int i = nums.length-2; i >=0;i--){
            suffix[i]= nums[i+1] * suffix[i+1];
            System.out.print(suffix[i]);
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}
/*
[1,1,2,6]
[24,12,4,1]

[0,0,0,1]
suffix[3] = 1
 i = 4-2 = 2
 suffix[2] = nums[3] * prefix


[1,1,2,6]
[24,12,4,1]
*/
