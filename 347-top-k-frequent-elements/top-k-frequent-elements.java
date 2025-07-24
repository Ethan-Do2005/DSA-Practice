class Solution {
    public int[] topKFrequent(int[] nums, int k) {       
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int i=0; i<= nums.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            bucket[value].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && result.size() < k; i--){
            for(int num : bucket[i]){
                result.add(num);
                if(result.size() == k) break;
            }
        }

        int[] resArr = new int[k];
        for(int i =0; i<k;i++){
            resArr[i] = result.get(i);
        }

        return resArr;


    }
}
/*
Step 1: We will create a hashmap to count the freq of each value
Step 2: We will create a bucket array to store each element of HashMap freq
    + However, to avoid the conflict when if appear duplicate freq value
    => Create a list inside the arraylist
Step 3: We create a for loop to iterate each value as an [] lists
Step 4: We will assign each value and key in hashmap into the bucket array as
    + Value would be the index and Key would be the value inside [] lists
Step 5: we will reurn the highest value to smallest
    + To do that we need call an list the purpose on that is to recall and get out
    the list[] inside the bucket array

*/