class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0){
        return false;
        }
        // Step 1: Hashmap to store key-value pair
        Map<Integer, Integer> storage = new HashMap<>();

        // Step 2: Go through each index and check same value AND abs(i-j) <= ke
        // key = value
        // value = index 
        for(int i = 0; i < nums.length; i++){
        if(storage.containsKey(nums[i])){
            if(Math.abs(storage.get(nums[i]) - i) <= k){
            return true;
            }
        }

        storage.put(nums[i], i);
        }

        return false;
        }
}