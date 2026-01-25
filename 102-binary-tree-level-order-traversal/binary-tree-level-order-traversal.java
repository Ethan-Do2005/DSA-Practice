/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, root, result);
        return result;
    }

    private void backtrack(int depth, TreeNode node, List<List<Integer>> result){
        if(node == null){
            return;
        }

        if(depth == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);

        backtrack(depth + 1, node.left, result);
        backtrack(depth + 1, node.right, result);
    }
}