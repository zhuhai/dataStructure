package com.zhuhai;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/29
 * Time: 16:12
 *
 * @author: zhuhai
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private Node root;
    private int size;




    @Override
    public void put(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向以node为根的二叉树中插入元素（key，value）
     * @param node
     * @param key
     * @param value
     * @return 返回插入元素之后新的二叉树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        //向左子树添加节点
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
            //向又子树添加节点
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    /**
     * 返回以node为根节点的二叉树中，key所在的节点
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * 返回以node为根的二叉树中最小值所在的节点
     * @param node
     * @return
     */
    private Node minum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minum(node.left);
    }

    /**
     * 删除以node为根节点的二叉树中最小的节点
     * @param node
     * @return 返回删除节点后新的二叉树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }



    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(node, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            //待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树都不为空的情况
            //先找到待删除节点右子树中最小节点，用这个节点顶替待删除节点的位置
            Node successor = minum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }


    public static void main(String[] args) {

        BSTMap<String, String> map = new BSTMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        System.out.println(map.getSize());
        System.out.println(map.get("b"));
        System.out.println(map.remove("c"));

    }
}
