class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int targetedNum = target - num;

            if(map.containsKey(targetedNum)){
                return new int[]{map.get(targetedNum), i};
            }
            map.put(num, i);
        }

        return new int[]{};
    }
}
/*
Constraints
Range of this nums.length
2 to 10^4
Positive or negative number
=> Both from 10^5 to 10^5

My approach: HashMap and for loop
[2,7,11,15]
i = 0;
Map{1: 2}
9 - 2 = 7
i = 1;
Map{2: 1, 2: 7}
9 - 7 = 2

Reutn 0, 1
*/