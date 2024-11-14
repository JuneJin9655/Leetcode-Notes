package tree.leetcode98;

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if(prev != null && curr.val <= prev) return false;
            prev = curr.val;

            curr = curr.right;
        }
        return true;
    }
}