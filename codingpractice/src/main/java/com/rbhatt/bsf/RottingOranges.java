package com.rbhatt.bsf;

//BSF

import java.util.*;

//Leetocode question # 994
public class RottingOranges {

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Position) obj).x && this.y == ((Position) obj).y;
        }
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        //variable to track if any new orange got affecting during this minute.
        //If no new orange got rotten than we can come out of the loop
        boolean noNewOrangeToRott = false;

        List<Position> orangesToRot;
        List<Position> visited = new ArrayList<>();

        int result = 0;

        while (!noNewOrangeToRott) {

            noNewOrangeToRott = true;
            orangesToRot = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    Position p = new Position(i,j);

                    if (!visited.contains(p)) {

                        if (grid[i][j] == 2) {

                            visited.add(p);
                            //rott adjacent oranges

                            //rott right orange
                            if (j + 1 < m && grid[i][j+1] == 1) {
                                //grid[i][j+1] = 2;
                                orangesToRot.add(new Position(i, j+1));
                                noNewOrangeToRott = false;
                            }

                            //rott left orange
                            if (j - 1 >= 0 && grid[i][j-1] == 1) {
                                //grid[i][j-1] = 2;
                                orangesToRot.add(new Position(i, j-1));
                                noNewOrangeToRott = false;
                            }

                            //rott top orange
                            if (i - 1 >= 0 && grid[i-1][j] == 1) {
                                //grid[i-1][j] = 2;
                                orangesToRot.add(new Position(i-1, j));
                                noNewOrangeToRott = false;
                            }

                            //rott below orange
                            if (i + 1 < n && grid[i+1][j] == 1) {
                                //grid[i+1][j] = 2;
                                orangesToRot.add(new Position(i+1, j));
                                noNewOrangeToRott = false;
                            }

                        }

                    }
                }
            }

            //Rot all adjacent oranges which were marked for rotting
            for (Position p : orangesToRot) {
                grid[p.x][p.y] = 2;
            }

            if (!noNewOrangeToRott) {
                result++;
            }

        }

        //check if any orange left fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    return -1;
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {

        RottingOranges ob = new RottingOranges();

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(ob.orangesRotting(grid));

        int[][] grid1 = {{1,2,0},{0,1,0},{0,1,1}};

        System.out.println(ob.orangesRotting(grid1));

        int[][] grid2 = {{2,1,1}, {0,1,1}, {1,0,1}};

        System.out.println(ob.orangesRotting(grid2));

        int[][] grid3 = {{0,2}};

        System.out.println(ob.orangesRotting(grid3));

    }

}
