package com.rbhatt.twopointer;


public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }

        int digitsToRemove  = k;

        while (digitsToRemove > 0 && num.length() > 1) {

            boolean isDigitRemoved = false;
            for (int i = 1; i < num.length(); i++) {

                if (num.charAt(i-1) > num.charAt(i)) {
                    num = num.substring(0,i-1).concat(num.substring(i,num.length()));
                    isDigitRemoved = true;
                    break;
                }
            }

            if (!isDigitRemoved) {
                num = num.substring(0,num.length()-1);
            }
            digitsToRemove -= 1;
        }

        //remove leading zero
        while(num.length() != 1 && num.charAt(0) == '0') {
            num = num.substring(1);
        }

        return num;
    }

    public static void main(String[] args) {

        RemoveKDigits ob = new RemoveKDigits();

        System.out.println(ob.removeKdigits("1432219", 3));

        System.out.println(ob.removeKdigits("416352", 4));

        System.out.println(ob.removeKdigits("10200", 1));

        System.out.println(ob.removeKdigits("10", 2));

        System.out.println(ob.removeKdigits("112", 1));

        System.out.println(ob.removeKdigits("12", 1));

    }

}
