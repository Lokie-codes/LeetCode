/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string using level-order traversal (BFS)
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node != null) {
                result.add(String.valueOf(node.val));
                // Add both children to queue (even if null)
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add("#");
            }
        }
        
        return String.join(",", result);
    }

    // Decodes your encoded data to tree using BFS
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            // Process left child
            if (!values[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.left);
            }
            index++;
            
            // Process right child
            if (!values[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.right);
            }
            index++;
        }
        
        return root;
    }
}