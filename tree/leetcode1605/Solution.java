package tree.leetcode1605;
//It’s like two people on different paths—one pauses or restarts,
//so the other eventually catches up, and they meet at the same spot, the lowest common ancestor.
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;

        while(a != b){
            a = ( a == null ) ? q : a.parent;
            b = ( b == null ) ? p : b.parent;
        }

        return a;
    }
}
