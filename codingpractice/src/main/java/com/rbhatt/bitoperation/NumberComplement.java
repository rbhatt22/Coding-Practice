package com.rbhatt.bitoperation;

//Bit operation
//Leetcode question # 476
public class NumberComplement {

    public int findComplement(int num) {

        String binaryNum = Integer.toBinaryString(num);

        binaryNum = binaryNum.replace('0', '2').replace('1', '0').replace('2', '1');

        return Integer.parseInt(binaryNum, 2);

    }

    public static void main(String[] args) {

        NumberComplement ob = new NumberComplement();

        System.out.println(ob.findComplement(5));

        System.out.println(ob.findComplement(1));
    }

}
