package com.rbhatt.string;

//String


public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {

        String s = "";
        String t = "";

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '#') {
                if (i != 0 && s.length() > 0) {
                    s = s.substring(0, s.length() - 1);
                }

            } else {
                s = s.concat(S.substring(i, i + 1));
            }

        }

        for (int i = 0; i < T.length(); i++) {

            if (T.charAt(i) == '#') {
                if (i != 0 && t.length() > 0) {
                    t = t.substring(0, t.length() - 1);
                }

            } else {
                t = t.concat(T.substring(i, i + 1));
            }

        }

        return s.equals(t);
    }

    public static void main(String[] args) {

        BackspaceStringCompare ob = new BackspaceStringCompare();

        System.out.println(ob.backspaceCompare("ab#c", "ad#c"));

        System.out.println(ob.backspaceCompare("ab##", "c#d#"));

        System.out.println(ob.backspaceCompare("a##c", "#a#c"));

        System.out.println(ob.backspaceCompare("a#c", "b"));

    }
}
