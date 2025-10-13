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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            int[] level = new int[size];

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                int index;
                if(leftToRight){
                    index = i;
                }
                else{
                    index = size - 1 - i;
                }
                level[index] = curr.val;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }


            List<Integer> list = new ArrayList<>();
            for(int v : level) list.add(v);
            res.add(list);

            leftToRight = !leftToRight;
        }

        return res;

    }
}