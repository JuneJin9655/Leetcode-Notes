package hashMap.leetcode314;
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

/*
For this problem, we use the queue's FIFO property and a HashMap to implement the BFS operation. Specifically,
we start by handling the root node, then process each node level by level, moving from left to right. For each node,
we use a pair to get its value and column. Then, we create a hash table with the column as the key and store the node
values in it, so we can easily retrieve the results later. Finally, we repeat this process for each node from left to
right.
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            map.putIfAbsent(column, new ArrayList<>());
            map.get(column).add(node.val);

            if(node.left != null){
                queue.offer(new Pair<>(node.left, column - 1));
            }

            if(node.right != null){
                queue.offer(new Pair<>(node.right, column + 1));
            }
        }
        for(List<Integer> col : map.values()){
            result.add(col);
        }

        return result;
    }
    private static class Pair<K, V> {
        private K key;
        private V value;

        // 构造函数初始化键值对
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // 获取键
        public K getKey() { return key; }

        // 获取值
        public V getValue() { return value; }
    }
}
