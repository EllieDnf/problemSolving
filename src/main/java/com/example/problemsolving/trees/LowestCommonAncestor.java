package com.example.problemsolving.trees;

public class LowestCommonAncestor {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }
            if (Math.max(p.val, q.val) < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (Math.min(p.val, q.val) > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
