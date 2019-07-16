package com.zhuhai;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/15
 * Time: 20:55
 *
 * @author: hai
 */
public class BST2<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;
    private int size;

    public BST2() {
        this.root = null;
        this.size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根节点的二叉树中插入元素e
     *
     * @param node
     * @param e
     * @return 插入新节点后二叉树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看二叉树中是否含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    public void preOrder() {
        preOrder(root);
    }


    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 前序遍历以node为根的二叉树
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历以node为根的二叉树
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历以node为根的二叉树
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 前序遍历非递归实现
     * 使用栈的方式
     */
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    /**
     * 二叉树层序遍历（广度优先遍历）
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST2<Integer> bst = new BST2<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        //System.out.println(bst);
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
    }
}
