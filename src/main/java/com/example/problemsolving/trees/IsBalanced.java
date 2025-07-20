package com.example.problemsolving.trees;

public class IsBalanced {
    public static void main(String[] args) {
        IsBalanced balancedBinaryTree= new IsBalanced();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

//        invertBinaryTree.invertTree(root);
        boolean res = balancedBinaryTree.isBalanced(root);
        System.out.println(res);
    }


    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node unbalanced

        return Math.max(leftHeight, rightHeight) + 1; // Return height if balanced
    }

    public boolean isBalancedBruteForce(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
