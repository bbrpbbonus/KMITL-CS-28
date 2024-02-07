public class HW2_binaryTre_65050492 {
    public static void main(String[] args) {
        int[] data = { 12, 42, 32, 75, 16, 45, 39, 86, 23, 49 };

        BinaryTree tree = new BinaryTree();

        for (int value : data) {
            tree.insert(value);
        }

        int minValue = tree.findMin();
        int maxValue = tree.findMax();

        System.out.println("Minimum value in the Binary Tree: " + minValue);
        System.out.println("Maximum value in the Binary Tree: " + maxValue);
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public int findMin() {
        return findMinRec(root);
    }

    private int findMinRec(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE; // Return a large value for an empty tree
        }

        int minValue = root.data;
        int leftMin = findMinRec(root.left);
        int rightMin = findMinRec(root.right);

        if (leftMin < minValue) {
            minValue = leftMin;
        }
        if (rightMin < minValue) {
            minValue = rightMin;
        }

        return minValue;
    }

    public int findMax() {
        return findMaxRec(root);
    }

    private int findMaxRec(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE; // Return a small value for an empty tree
        }

        int maxValue = root.data;
        int leftMax = findMaxRec(root.left);
        int rightMax = findMaxRec(root.right);

        if (leftMax > maxValue) {
            maxValue = leftMax;
        }
        if (rightMax > maxValue) {
            maxValue = rightMax;
        }

        return maxValue;
    }
}