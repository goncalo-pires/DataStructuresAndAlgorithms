package DataStructures;

import Utils.TreeNode;

import java.util.*;

public class MyBinarySearchTree {

    private TreeNode root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value, null, null);
        if (this.root == null) {
            this.root = newNode;
        } else {
            TreeNode currentNode = this.root;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public TreeNode lookup(int value) {
        if (this.root != null) {
            TreeNode currentNode = this.root;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return currentNode;
                }
            }
        }
        return null;
    }

    public void delete(int value) {
        this.root = delete(this.root, value);
    }

    private TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minLeft = findMin(root.right);
                root.value = minLeft.value;
                root.right = delete(root.right, minLeft.value);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        TreeNode currentNode = root;
        while (root.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public boolean isValidBST3(TreeNode root, Integer prev) {
        if (root == null) return true;
        if (!isValidBST3(root.left, prev)) return false;
        if (prev != null && prev >= root.value) return false;
        prev = root.value;
        return isValidBST3(root.right, prev);
    }

    public boolean isValidBST2(TreeNode root) {
        ArrayList<Integer> orderedNodes = traverseInOrder(root, new ArrayList<>());
        for (int i=0; i<orderedNodes.size()-1; i++) {
            if (orderedNodes.get(i) >= orderedNodes.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode currentNode, long min, long max) {
        if (currentNode == null) return true;
        if (currentNode.value <= min || currentNode.value >= max) {
            return false;
        }
        return isValid(currentNode.left, min, currentNode.value) && isValid(currentNode.right, currentNode.value, max);
    }

    public void breathFirstSearch() {
        TreeNode currentNode = this.root;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            list.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        System.out.println("BFS: " + list);
    }

    public void deepFirstSearchPostOrder() {
        System.out.println("DFS postOrder: " + traversePostOrder(this.root, new ArrayList<>()));
    }

    private ArrayList<Integer> traversePostOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;
        traversePostOrder(root.left, list);
        traversePostOrder(root.right, list);
        list.add(root.value);
        return list;
    }

    public void deepFirstSearchPreOrder() {
        System.out.println("DFS preOrder: " + traversePreOrder(this.root, new ArrayList<>()));
    }

    private ArrayList<Integer> traversePreOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;
        list.add(root.value);
        traversePreOrder(root.left, list);
        traversePreOrder(root.right, list);
        return list;
    }

    public void deepFirstSearchInOrder() {
        System.out.println("DFS inOrder: " + traverseInOrder(this.root, new ArrayList<>()));
    }

    private ArrayList<Integer> traverseInOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;
        traverseInOrder(root.left, list);
        list.add(root.value);
        traverseInOrder(root.right, list);
        return list;
    }

    public void print(TreeNode node, String indent, boolean isLeft) {
        if (node == null) return;
        String connector = isLeft ? "┌── " : "└── ";
        System.out.println(indent + connector + node.value);
        String childIndent = indent + (isLeft ? "│   " : "    ");
        if (node.left != null) {
            print(node.left, childIndent, true);
        }
        if (node.right != null) {
            print(node.right, childIndent, false);
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree binarySearchTree = new MyBinarySearchTree();
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(170);
        binarySearchTree.insert(15);
        binarySearchTree.insert(1);
        binarySearchTree.print(binarySearchTree.root, "", true);

        binarySearchTree.breathFirstSearch();

        binarySearchTree.deepFirstSearchInOrder();
        binarySearchTree.deepFirstSearchPreOrder();
        binarySearchTree.deepFirstSearchPostOrder();

        System.out.println(binarySearchTree.isValidBST(binarySearchTree.root));
        System.out.println(binarySearchTree.isValidBST2(binarySearchTree.root));
        System.out.println(binarySearchTree.isValidBST3(binarySearchTree.root, null));



    }

}
