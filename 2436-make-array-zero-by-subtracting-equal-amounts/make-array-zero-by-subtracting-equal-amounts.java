class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num != 0){
                set.add(num);
            }
        }

        return set.size();
    }
}
/*
Time complexity: O(n)
Space complexity: O(number > 0) or means O
*/