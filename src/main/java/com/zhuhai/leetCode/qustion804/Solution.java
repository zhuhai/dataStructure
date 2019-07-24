package com.zhuhai.leetCode.qustion804;

import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/24
 * Time: 16:27
 *
 * @author: zhuhai
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();

    }



}
