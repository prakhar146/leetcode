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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "N";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val));
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        // System.out.println("arr -> " + Arrays.toString(arr));
        return deserializeHelper(arr, new MyInt(0));
    }
    
    TreeNode deserializeHelper(String[] arr, MyInt idx) {
        if(idx.v > arr.length) {
            return null;
        }
        String val = arr[idx.v];
        // System.out.println("idx -> " + idx.v + " val -> " + val);
        if(val.equals("N")) {
            return null;
        }
        // System.out.println("val -> " + val);
        TreeNode node = new TreeNode(Integer.parseInt(val));
        idx.v++;
        node.left = deserializeHelper(arr, idx);
        idx.v++;
        node.right = deserializeHelper(arr, idx);
        return node;
    }
    class MyInt {
        int v;
        MyInt(int v) {
            this.v = v;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));