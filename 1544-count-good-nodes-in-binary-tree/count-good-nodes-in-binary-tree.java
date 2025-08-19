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
    public int goodNodes(TreeNode root) {
        return countNode(root, root.val);
    }
    public int countNode(TreeNode node, int max){
        int count = 0;
        if(node == null){
            return 0;
        }
        if(node.val >= max){
            count = 1;
        }
        int nextMax = Math.max(node.val, max);
        count += countNode(node.left, nextMax);
        count += countNode(node.right, nextMax);

        return count;
    }
}