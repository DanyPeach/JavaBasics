package com.by.hometasks.kkk;

public class BinaryTree {

    Node root;

    // Класс, представляющий узел дерева
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    // Метод, который находит высоту дерева
    public  void removeMiddleNode(BinaryTree tree) {
        int height = getHeight(tree.root);
        int targetLevel = height / 2;

        // Находим узел на уровне targetLevel, у которого высота левого поддерева равна высоте правого поддерева
        Node middleNode = findMiddleNode(tree.root, targetLevel);

        // Если узел не найден, ничего не делаем
        if (middleNode == null) {
            return;
        }

        // Удаляем узел
        deleteNode(tree, middleNode.key);

        // Выполняем прямой (левый) обход полученного дерева
        preOrderTraversal(tree.root);
    }

    // Метод для нахождения высоты дерева
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Метод для нахождения узла на уровне targetLevel, у которого высота левого поддерева равна высоте правого поддерева
    public Node findMiddleNode(Node node, int targetLevel) {
        if (node == null) {
            return null;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Если узел находится на уровне targetLevel и его левое поддерево и правое поддерево имеют одинаковую высоту
        if (leftHeight == rightHeight && targetLevel == leftHeight) {
            return node;
        }

        // Иначе ищем в левом и правом поддеревьях
        Node leftNode = findMiddleNode(node.left, targetLevel);
        if (leftNode != null) {
            return leftNode;
        }

        Node rightNode = findMiddleNode(node.right, targetLevel);
        if (rightNode != null) {
            return rightNode;
        }

        return null;
    }



    // Метод для удаления узла из дерева
    public void deleteNode(BinaryTree tree, int key) {
        tree.root = deleteNodeHelper(tree.root, key);
    }

    private Node deleteNodeHelper(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = deleteNodeHelper(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNodeHelper(root.right, key);
        } else { // found the node to delete
            // check if node is at the target height with equal left and right subtree heights
            int targetHeight = (height(root) / 2)-1;
            int currentHeight = 0;
            Node current = root;
            while (current != null) {
                int leftHeight = height(current.left);
                int rightHeight = height(current.right);
                int balanceFactor = leftHeight - rightHeight;
                if (currentHeight == targetHeight && balanceFactor == 0) {
                    // delete the node
                    if (current.left == null) {
                        return current.right;
                    } else if (current.right == null) {
                        return current.left;
                    } else {
                        Node minRight = findMin(current.right);
                        current.key = minRight.key;
                        current.right = deleteNodeHelper(current.right, minRight.key);
                    }
                    break;
                } else if (balanceFactor > 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
                currentHeight++;
            }
        }

        return root;
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

        // Пример использования
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(20);
        tree.root.left.left.left = new Node(3);
        tree.root.left.left.right = new Node(7);
        tree.root.left.right.left = new Node(2);
        tree.root.left.right.right = new Node(8);
        tree.root.right.right.right = new Node(30);
        tree.root.right.right.left = new Node(19);
        tree.root.right.left.left = new Node(11);
        tree.root.right.left.right = new Node(14);



        int targetHeight = tree.getHeight(tree.root) / 2;
        int[] sum = new int[1];
        int[] count = new int[1];

        tree.removeMiddleNode(tree);
        System.out.println("Высота дерева: " + tree.getHeight(tree.root)); // Выводит 3

    }
}
