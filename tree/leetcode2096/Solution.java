package tree.leetcode2096;

// self-recursion, false, return to last recursion
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        //storage
        StringBuilder pathToStart = new StringBuilder();
        //put the path from ica to startValue in pathToStart
        findPath(lca, startValue, pathToStart);

        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, destValue, pathToDest);

        String upMoves = "U".repeat(pathToStart.length());
        return upMoves + pathToDest.toString();
    }

    private TreeNode findLCA(TreeNode root, int p, int q){
        //return the met condition
        if(root == null || root.val == p || root.val == q) return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        //if left is not null, that means find a LCA, if left is null, go to check right;
        return left != null ? left : right;
    }

    private boolean findPath(TreeNode root, int target, StringBuilder path){
        if(root == null) return false;

        if(root.val == target) return true;

        path.append("L");
        if(findPath(root.left, target, path)){
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        if(findPath(root.right, target, path)){
            return true;
        }
        path.deleteCharAt(path.length() -1 );
        //left or right both can not find a target;
        return false;
    }
}