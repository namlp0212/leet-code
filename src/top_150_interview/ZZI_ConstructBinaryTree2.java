package top_150_interview;


public class ZZI_ConstructBinaryTree2 {
    // inorder: left => root => right
    // postorder: left => right => root
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost) {
        if (startIn <= endIn) {
            TreeNode root = new TreeNode();
            root.val = postorder[endPost];

            int rootIdxIn = startIn;
            for (int i = startIn; i <= endIn; i++) {
                if (inorder[i] == postorder[endPost]) {
                    rootIdxIn = i;
                    break;
                }
            }

            int leftNum = rootIdxIn - startIn;
            root.left = buildTree(inorder, postorder, startIn, rootIdxIn - 1, startPost, startPost + leftNum - 1);
            root.right = buildTree(inorder, postorder, rootIdxIn + 1, endIn, startPost + leftNum, endPost-1);

            return root;
        } else {
            return null;
        }

    }
}
