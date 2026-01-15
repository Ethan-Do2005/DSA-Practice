class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
/*
Range length
1 --> 10^5
Those will be upper or lowercase 
=> lowercase

Approach A

Using HashMap
ace cea
Method
[26]

[1,0,1,0,1,0,0,0,]

*/