package Deutsche;
/*
There is a binary search tree.
It is required to develop a method getMaxDepth(BinaryNode root) which returns the maximum depth of the tree.
Существует двоичное дерево поиска.
Требуется разработать метод getMaxDepth (корень BinaryNode), который возвращает максимальную глубину дерева.
 */

import java.util.*;

class SimpleThree<T extends Comparable<T>> {
    private int sizeTree = 0;

    private class Node {
        final T value;
        Node left;
        Node right;

        public Node(T val) {
            value = val;
            left = null;
            right = null;
        }
    }

    private Node root;

    private Node appendNode(Node rootNode, T val) {
        if (rootNode == null)
            return new Node(val);
        else {
            int cmp = rootNode.value.compareTo(val);
            if (cmp > 0)
                rootNode.left = appendNode(rootNode.left, val);
            else if (cmp < 0)
                rootNode.right = appendNode(rootNode.right, val);
        }
        return rootNode;
    }

    private int getMaxDepth(SimpleThree<Integer> rootNode) {
        int tmpCount = 0;

        if (root.value == null) {
            return 0;
        } else {
            tmpCount = tmpCount + 1;
            int tmpCountleft = tmpCount;
            int tmpCountright = tmpCount;
            findSizeNode(root.left, tmpCountleft);
            findSizeNode(root.right, tmpCountright);
        }
        return this.sizeTree;
    }

    private int findSizeNode(Node rootNode, int tmpCount) {
        if (rootNode != null) {
            tmpCount = tmpCount + 1;
            findSizeNode(rootNode.left, tmpCount);
            findSizeNode(rootNode.right, tmpCount);
        }
        if (tmpCount > this.sizeTree) {
            this.sizeTree = tmpCount;
        }
        return this.sizeTree;
    }

    private void nodesToList(List<T> list, Node rootNode) {
        if (rootNode != null) {
            nodesToList(list, rootNode.left);
            list.add(rootNode.value);
            nodesToList(list, rootNode.right);
        }
    }

    public SimpleThree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void append(T val) {
        root = appendNode(root, val);
    }

    public List<T> toList() {
        List<T> list = new LinkedList<>();
        nodesToList(list, root);
        return list;
    }

    public static void main(String[] args) {
        SimpleThree<Integer> three = new SimpleThree<>();
        three.append(5);
        three.append(1);
        three.append(4);
        three.append(2);
        three.append(3);
        three.append(6);
        three.append(7);
        three.append(3);

        for (int i : three.toList())
            System.out.println(i);
        System.out.println("size = " + three.getMaxDepth(three));
    }
}