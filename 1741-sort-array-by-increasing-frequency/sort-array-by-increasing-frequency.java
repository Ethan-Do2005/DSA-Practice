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
                return b-a;
            }
        });

        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        } 

        return nums; 
    }
}
/*
Negative number 
Yes
range length of nums 
1 to 100

My approach
A: HashMap + List
{1:2, 2:3, 3:1}
{1,1,2,2,2,3}
*/