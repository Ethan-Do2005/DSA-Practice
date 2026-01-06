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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        result.add(root.val);

        //If root is leaf => done 
        if(isLeaf(root)) return result;

        //Checking for left boundary
        addLeftBoundary(root.left, result);

        //add into result
        addLeaves(root, result);

        //Checking for right boundary
        addRightBoundary(root.right, result);

        return result;

    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result){
        while(node != null){
            if(!isLeaf(node)){
                result.add(node.val);
            }

            if(node.left != null){
                node = node.left;
            }else{
                node = node.right;
            }
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result){
        if(node == null) return;

        if(isLeaf(node)){
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(TreeNode node, List<Integer> result){
        //Bcs rightBoundary go from bot to top so we need reverse step
        List<Integer> temp = new ArrayList<>();

        while(node != null){
            if(!isLeaf(node)){
                temp.add(node.val);
            }
            
            if(node.right != null){
                node = node.right;
            }else{
                node = node.left;
            }
        }

        for(int i = temp.size() - 1; i >= 0; i--){
            result.add(temp.get(i));
        }
    }

}