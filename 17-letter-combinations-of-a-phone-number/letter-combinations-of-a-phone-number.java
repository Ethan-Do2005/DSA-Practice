class Solution {
    private final String[] phone = 
    {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.isEmpty()) return res;
        dfs(digits, new StringBuilder(), 0, res);
        return res;    
    }

    private void dfs(String digits, StringBuilder str, int i, List<String> res){
        if(i == digits.length()){
            res.add(str.toString());
            return;
        }

        for(char c: phone[digits.charAt(i) - '0'].toCharArray()){
            str.append(c);
            dfs(digits, str, i+1, res);
            str.deleteCharAt(str.length() - 1);
        }
    }
}