package lec04;

import java.util.Iterator;
import java.util.Map;

public class Huffman {
    public Huffman() {
    }

    public static TreeNode encodeText(Map<String, Integer> lettersFrequencies) {
        PriorityQueue queue = new PriorityQueue();
        Iterator var2 = lettersFrequencies.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry<String, Integer> key_value = (Map.Entry)var2.next();
            queue.insert((String)key_value.getKey(), (Integer)key_value.getValue());
        }

        TreeNode newRoot;
        TreeNode root;
        for(root = null; !queue.isEmpty(); root = newRoot) {
            QueueElement min = queue.extractMin();
            newRoot = new TreeNode();
            TreeNode left = new TreeNode(min.getLetter(), min.getPriority(), newRoot);
            TreeNode right = null;
            min = queue.extractMin();
            if (root != null) {
                right = root;
            } else if (min != null) {
                right = new TreeNode(min.getLetter(), min.getPriority(), newRoot);
            }

            if (right != null && left.letter.length() > right.letter.length()) {
                TreeNode tmp = right;
                right = left;
                left = tmp;
            }

            newRoot.left = left;
            newRoot.right = right;
            String var10001 = left.letter;
            newRoot.letter = var10001 + (right != null ? right.letter : "");
            newRoot.priority = left.priority + (right != null ? right.priority : 0);
            if (!queue.isEmpty()) {
                queue.insert(newRoot.letter, newRoot.priority);
            }
        }

        return root;
    }

    public static void fillDictionary(TreeNode root, Map<String, String> dictionary, String code) {
        if (root.left == null && root.right == null) {
            dictionary.put(root.letter, code);
        }

        StringBuilder stringBuilder;
        if (root.left != null) {
            stringBuilder = new StringBuilder(code);
            stringBuilder.append("0");
            fillDictionary(root.left, dictionary, stringBuilder.toString());
        }

        if (root.right != null) {
            stringBuilder = new StringBuilder(code);
            stringBuilder.append("1");
            fillDictionary(root.right, dictionary, stringBuilder.toString());
        }

    }
}

