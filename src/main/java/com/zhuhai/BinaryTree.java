package com.zhuhai;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/17
 * Time: 23:12
 *
 * @author: hai
 */
public class BinaryTree<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left;
        private Node right;

        private Node(E e) {
            this.e = e;
        }

        private void addNode(E e) {
            if (e.compareTo(this.e) < 0) {
                if (this.left == null) {
                    this.left = new Node(e);
                } else {
                    this.left.addNode(e);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(e);
                } else {
                    this.right.addNode(e);
                }
            }
        }

        /**
         * 先序遍历
         */
        private void preOrder() {
            System.out.println(this.e);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 中序遍历
         */
        private void inOrder() {
            if (this.left != null) {
                this.left.inOrder();
            }
            System.out.println(this.e);
            if (this.right != null) {
                this.right.inOrder();
            }
        }


    }

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            this.root = new Node(e);
        } else {
            this.root.addNode(e);
        }
        size++;
    }

    public void inOrder() {
        if (this.root == null) {
            return;
        }
        this.root.inOrder();
    }

    public void preOrder() {
        if (this.root == null) {
            return;
        }
        this.root.preOrder();
    }




    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            binaryTree.add(num);
        }
        binaryTree.inOrder();
        System.out.println();
        binaryTree.preOrder();
    }


}
