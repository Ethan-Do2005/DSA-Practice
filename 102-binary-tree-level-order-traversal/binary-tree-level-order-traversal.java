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
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode node, int depthTree, List<List<Integer>> list){
        if(node == null){
            return;
        }
        if(list.size() == depthTree){
            //create another list inside list
            list.add(new ArrayList<>());
        }
        list.get(depthTree).add(node.val);
        dfs(node.left, depthTree + 1, list);
        dfs(node.right, depthTree + 1, list);

    }
}