class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            maxheap.offer(num);
        }

        int result = 0;
        while(k > 0){
            result = maxheap.poll();
            k--;
        }

        return result;
    }
}
/*
Step1: We will create a maxheap where to store each each array in sorted way
Step2: Maxheap will pop out until k = 0 and then return k;
*/