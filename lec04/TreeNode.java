package lec04;

public class TreeNode {
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    int priority;
    String letter;

    TreeNode(String letter, int priority, TreeNode parent) {
        this.letter = letter;
        this.priority = priority;
        this.parent = parent;
    }

    TreeNode(TreeNode parent) {
        this.parent = parent;
    }

    TreeNode() {
    }
}