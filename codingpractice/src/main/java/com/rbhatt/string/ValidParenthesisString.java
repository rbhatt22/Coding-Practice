package com.rbhatt.string;

import java.util.Stack;
//String

//Leetcode question # 678
public class ValidParenthesisString {

    //This problem can be solved using two pointer. Hi and Lo.
    //Lo does + 1 if ( else -1
    //Hi does +1 if ( or * else -1

    //Below solution is using two stack. One keep track of ( and other *
    public boolean checkValidString(String s) {

        Stack<Integer> parenthesisStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == '(') {
                parenthesisStack.push(i);
            } else if (charArray[i] == ')') {
                if (parenthesisStack.empty() && asteriskStack.empty()) {
                    return false;
                } else if (parenthesisStack.empty() && !asteriskStack.empty()) {
                    asteriskStack.pop();
                } else if (!parenthesisStack.empty()) {
                    parenthesisStack.pop();
                }
            } else if (charArray[i] == '*') {
                asteriskStack.push(i);
            }
        }
        if (!parenthesisStack.empty() && asteriskStack.empty()) {
            return false;
        } else if (!parenthesisStack.empty() && !asteriskStack.empty()) {
            if (parenthesisStack.size() <= asteriskStack.size()) {

                while(!parenthesisStack.empty() && parenthesisStack.peek() < asteriskStack.peek()) {
                    parenthesisStack.pop();
                    asteriskStack.pop();
                }

                if (parenthesisStack.empty()) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        ValidParenthesisString ob = new ValidParenthesisString();

        System.out.println(ob.checkValidString("()"));//true

        System.out.println(ob.checkValidString("(*)"));//true

        System.out.println(ob.checkValidString("(*()"));//true

        System.out.println(ob.checkValidString("(*))"));//true

        System.out.println(ob.checkValidString("(()"));//false

        System.out.println(ob.checkValidString("())"));//false

        System.out.println(ob.checkValidString(")("));//false

        System.out.println(ob.checkValidString("**"));//true

        System.out.println(ob.checkValidString(""));//true

        System.out.println(ob.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));//false
    }

}
