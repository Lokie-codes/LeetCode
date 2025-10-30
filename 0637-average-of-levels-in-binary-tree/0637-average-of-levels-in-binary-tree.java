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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int qSize = q.size();
            double avg = 0;
            for(int i=0; i<qSize; i++) {
                TreeNode node = q.poll();
                avg += node.val;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            avg /= qSize;
            res.add(avg);
        }
        return res;
    }
}