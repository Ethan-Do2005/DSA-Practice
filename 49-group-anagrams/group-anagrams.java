class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26]; // from 'a' to 'z '
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }
}