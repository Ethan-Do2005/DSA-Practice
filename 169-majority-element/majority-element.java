class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int index = nums[0];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(freq > max){
                max = freq;
                index = entry.getKey();
            }
        }

        return index;
    }
}