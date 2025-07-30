class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; int sum =0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return count;
    }
}
/*
Coming with the idea of using 
1.prefix 
2.Hashmap

[1,1,1] => [1,1] [1,1]
[0,1,2,3] => [1+1] [2]
[3,2,1,0]
Hashmap:(check value equal with sum - k)
0 - 2 => -2 (not satisfy) => 0: 1
1 - 2 => -1 (not satisfy) => 1: 1
2 - 2 => 0  (satisfy)     => 2: 1 
3 - 2 => 1  (not satisfy) => 3: 1

If is index equal to k => immediately count up it 
=> Bcs its index its sum will that index + 0 => sum: 1 

[1,2,3]
[0,1,3,6]
[6,3,1,0]
*/