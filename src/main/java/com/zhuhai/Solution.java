package com.zhuhai;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/7/7
 * Time: 17:22
 *
 * @author: hai
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (character == ')' && pop != '(') {
                    return false;
                }
                if (character == ']' && pop != '[') {
                    return false;
                }
                if (character == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }


}
