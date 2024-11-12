package tree.easy.leetcode543;

class Solution {

    //自我递归
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node){
        if(node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
