package work.icql.java.datastructure.old.impl;


import work.icql.java.datastructure.old.Queue;
import work.icql.java.datastructure.old.Stack;
import work.icql.java.datastructure.old.Tree;

/**
 * @author icql
 * @version 1.0
 * @date 2019/1/7 9:28
 * @Title ThreadedBinaryTree
 * @Description 线索二叉树（特殊的二叉链表 实现）
 */
public class ThreadedBinaryTree<T> implements Tree<T> {
    private Node<T> root;

    public ThreadedBinaryTree(T t) {
        root = new Node(t, null, Tag.PTR, null, Tag.PTR);
    }

    //内部类：结点线索标志
    private static enum Tag {
        CHILD, PTR
    }

    //内部类：左右孩子
    public static enum ChildTag {
        LEFT, RIGHT
    }

    //内部类：结点
    public static class Node<T> {
        T data;
        Node<T> left;
        Tag ltag;
        Node<T> right;
        Tag rtag;

        public Node(T item, Node<T> left, Tag ltag, Node<T> right, Tag rtag) {
            this.data = item;
            this.left = left;
            this.ltag = ltag;
            this.right = right;
            this.rtag = rtag;
        }
    }

    /**
     * 获取根结点
     *
     * @return
     */
    public Node<T> getRoot() {
        return this.root;
    }

    /**
     * 增加结点
     *
     * @param parent
     * @param childTag
     * @param t
     * @return
     */
    public Node<T> add(Node<T> parent, ChildTag childTag, T t) {
        if (parent == null || t == null) {
            return null;
        }
        Node<T> node = new Node<T>(t, null, Tag.PTR, null, Tag.PTR);
        if (childTag == ChildTag.LEFT && parent.ltag == Tag.PTR) {
            parent.left = node;
            parent.ltag = Tag.CHILD;
        } else if (childTag == ChildTag.RIGHT && parent.rtag == Tag.PTR) {
            parent.right = node;
            parent.rtag = Tag.CHILD;
        } else {
            return null;
        }
        return node;
    }

    /**
     * 前序遍历：根-左-右，递归的方式
     *
     * @param root
     */
    public void preOrder(Node<T> root) {
        if (null != root) {
            System.out.print(root.data + "\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 前序遍历：根-左-右，非递归的方式
     *
     * @param root
     */
    public void preOrderNonRecursive(Node<T> root) {
        Stack<Node<T>> stack = new SingleLinkedStack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.data + "\t");
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            root = root.right;
        }
    }

    /**
     * 中序遍历：左-中-右，采用递归的方式
     *
     * @param root
     */
    public void inOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "\t");
            inOrder(root.right);
        }
    }

    /**
     * 中序遍历：左-中-右，采用非递归的方式
     *
     * @param root
     */
    public void inOrderNonRecursive(Node<T> root) {
        Stack<Node<T>> stack = new SingleLinkedStack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            System.out.print(root.data + "\t");
            root = root.right;
        }
    }

    /**
     * 后序遍历：左-右-根，采用递归的方式
     *
     * @param root
     */
    public void postOrder(Node<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "\t");
        }
    }

    /**
     * 后序遍历采用非递归的方式
     *
     * @param root
     */
    public void postOrderNonRecursive(Node<T> root) {

    }

    /**
     * 层序遍历：根-左-右，一层一层
     *
     * @param root
     */
    public void levelOrder(Node<T> root) {
        Node<T> temp;
        Queue<Node<T>> queue = new SingleLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            System.out.print(temp.data + "\t");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}
