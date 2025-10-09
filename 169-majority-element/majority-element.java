class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0;
        int count = 0;

        for(int x : nums){
            if(count == 0){
                cand = x;
                count = 1;
            }else if(x == cand){
                count++;
            }else{
                count--;
            }
        }

        return cand;
    }
}