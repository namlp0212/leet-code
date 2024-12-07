package top_150_interview;

public class ZZH_ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if (startPre <= endPre) {
            TreeNode root = new TreeNode();
            root.val = preorder[startPre];

            int rootIdxIn = startIn;
            for (int i = startIn; i <= endIn; i++) {
                if (inorder[i] == preorder[startPre]) {
                    rootIdxIn = i;
                    break;
                }
            }
            int numLeft = rootIdxIn - startIn;
            // init left
            root.left = buildTree(preorder, inorder, startPre+1, startPre + numLeft, startIn, rootIdxIn - 1);
            // init right
            root.right = buildTree(preorder, inorder, startPre + numLeft + 1, endPre, rootIdxIn + 1, endIn);
            return root;
        } else {
            return null;
        }
    }
}
