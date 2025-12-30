class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int numFound = target - nums[i];

            if(map.containsKey(numFound)){
                return new int[]{map.get(numFound), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
/*
[2,7,11,15]
First index: 2
9 - 2 = 7
Push 2 (i index) into map
Second index:
if it satisfy 
=> i, get() 
*/