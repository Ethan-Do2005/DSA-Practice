class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();

        backtrack(candidates, target, subset, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<Integer> subset, int i){
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0 || i >= candidates.length){
            return;
        }

        subset.add(candidates[i]);
        backtrack(candidates, target - candidates[i], subset, i);
        subset.remove(subset.size() -1);
        backtrack(candidates, target, subset, i+1);
    }
}
