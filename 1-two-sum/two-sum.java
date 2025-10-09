class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int isTarget = target - nums[i];
            if(map.containsKey(isTarget)){
                return new int[]{map.get(isTarget), i};
            }
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}
/*
Using HashMap to store 
Take target - nums[i] compare HashMap

HashSet set

for(i in nums)
    int Istarget = target - nums[i]
    If condition Istarget contains in set
        return indeces
    add that pair into set
*/