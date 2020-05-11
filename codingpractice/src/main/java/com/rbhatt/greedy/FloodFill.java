package com.rbhatt.greedy;

import javafx.geometry.Pos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//dfs
//Leetcode question # 733
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];

        if (oldColor == newColor) {
            return image;
        }

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(sr, sc));

        while (!queue.isEmpty()) {

            Position p = queue.remove();
            image[p.x][p.y] = newColor;

            //check top
            if (p.x - 1 >= 0 && image[p.x - 1][p.y] == oldColor) {
                queue.add(new Position(p.x - 1, p.y));
            }
            //check bottom
            if (p.x + 1 < image.length && image[p.x + 1][p.y] == oldColor) {
                queue.add(new Position(p.x + 1, p.y));
            }
            //check left
            if (p.y - 1 >= 0 && image[p.x][p.y - 1] == oldColor) {
                queue.add(new Position(p.x, p.y - 1));
            }
            //check right
            if (p.y + 1 < image[0].length && image[p.x][p.y + 1] == oldColor) {
                queue.add(new Position(p.x, p.y + 1));
            }

        }

        return image;
    }

    class Position {

        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        FloodFill ob = new FloodFill();

        int[][] a = new int[3][3];

        a[0][0]=1;a[0][1]=1;a[0][2]=1;
        a[1][0]=1;a[1][1]=1;a[1][2]=0;
        a[2][0]=1;a[2][1]=0;a[2][2]=1;

        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));

        int[][] b = ob.floodFill(a,1,1,2);

        System.out.println(Arrays.toString(b[0]));
        System.out.println(Arrays.toString(b[1]));
        System.out.println(Arrays.toString(b[2]));

        int[][] c = new int[2][3];

        c[0][0]=0;c[0][1]=0;c[0][2]=0;
        c[1][0]=0;c[1][1]=1;c[1][2]=1;

        int[][] d = ob.floodFill(c,1,1,1);

        System.out.println(Arrays.toString(d[0]));
        System.out.println(Arrays.toString(d[1]));

    }

}
