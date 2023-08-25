// package Sem3;

// public class Task1 {
//     public static void main(String[] args) {
//         LinkedList list = new LinkedList();
//         list.addFirst(1);
//         list.addFirst(2);
//         list.print();
//         list.addEnd(3);
//         list.print();
//         list.addEnd(4);
//         list.print();
//         // list.deleteFirst();
//         // list.print();
//         // list.removeEnd();
//         // list.print();

        
//     }
// }

class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    int color; // 0 - черный, 1 - красный

    public Node(int data) {
        this.data = data;
        this.color = 1; // Новые узлы всегда красные
    }
}

public class RedBlackTree {
    private Node root;
    private Node TNULL;

    // Конструктор
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = 0;
        root = TNULL;
    }

    // Левый малый поворот
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Правый малый поворот
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != TNULL) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    // Ваш код для смены цвета узлов
    private void swapColors(Node x, Node y) {
        int temp = x.color;
        x.color = y.color;
        y.color = temp;
    }

    // Вставка элемента в дерево
    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // Красный

        Node y = null;
        Node x = this.root;

        // Вставляем элемент как в бинарное дерево поиска
        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // Устанавливаем родителя для нового узла
        node.parent = y;

        // Вставляем узел как потомка родителя
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        // Выполняем балансировку дерева
        fixInsert(node);
    }

    // Ваш код для балансировки дерева после вставки
    private void fixInsert(Node k) {
        // Реализация балансировки после вставки
    }

    // Другие методы могут быть добавлены здесь

    public static void main(String[] args) {
        // Пример использования дерева
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(55);
        rbTree.insert(40);
        rbTree.insert(65);
        // Добавьте другие элементы и операции для демонстрации
    }
}

