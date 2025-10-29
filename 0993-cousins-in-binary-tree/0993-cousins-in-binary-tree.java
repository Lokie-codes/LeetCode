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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                int left = node.left != null ? node.left.val : 0;
                int right = node.right != null ? node.right.val : 0;
                if((left == x && right == y) || left == y && right == x) return false;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                set.add(node.val);
            }
            if(set.contains(x) && set.contains(y)) {
                return true;
            }
        }
        return false;
    }
}