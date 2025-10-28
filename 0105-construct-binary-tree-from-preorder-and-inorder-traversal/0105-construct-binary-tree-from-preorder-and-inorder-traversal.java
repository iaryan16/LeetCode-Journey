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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return create(preorder, inorder, 0, preorder.length-1);
    }

    public TreeNode create(int pre[], int in[], int l, int r) {
        
        if(l > r) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[preIdx]);
        int idx = search(pre[preIdx], l, r, in);
        preIdx++;
        root.left = create(pre, in, l, idx-1);
        root.right = create(pre, in, idx+1, r);

        return root;
    }

    public int search(int val, int l, int r, int in[]) {
        for(int i=l; i<=r; i++) {
            if(val == in[i]) {
                return i;
            }
        }
        return -1;
    }
}