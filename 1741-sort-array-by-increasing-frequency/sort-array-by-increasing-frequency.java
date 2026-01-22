class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        Collections.sort(list, (a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if(freqA != freqB){
                return freqA - freqB;
            }else{
                return b - a;
            }
        });

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
/*
what is the range length of nums
from 1 to 100

My approach for this using HashMap and List
HashMap: count the freq num in nums
List: sorted order

nums = [1,1,2,2,2,3]
HashMap{1:2, 2:3, 3:1}

List {1,1,2,2,2,3}
Collections.sort
Same frequency of two index
    => Compare by list value
1 (freq 2)
1 1 => 0 => it will order two
1 2 => 3 - 2 => it still same 
2 2 => 
2 2 
2 3 => 3 2
list {1,1,2,2,3,2}
2, 3 => 3 2 
list {1,1,2,3,2,2}
list {3,1,1,2,2,2}
*/