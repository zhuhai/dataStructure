package com.zhuhai;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/23
 * Time: 16:39
 *
 * @author: zhuhai
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;
    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile(BSTSet.class.getClassLoader().getResource("pride-and-prejudice.txt").getFile(), words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

    }

}
