package com.Coding;

class NumberOfIslands {
    public static void main (String[] args) {
        int[][] map = { {1, 1, 1, 1, 0, 1},
                        {1, 1, 0, 1, 0, 1},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0} };
        System.out.println("Number of Islands -> " + countIslands(map));
    }

    private static int countIslands(int[][] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        else {
            int rows = arr.length;
            int cols = arr[0].length;

            boolean[][] visited = new boolean[rows][cols];
            int count = 0;

            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        checkNeighbours(arr, i, j, visited);
                        ++count;
                    }
                }
            }
            return count;
        }
    }

    // DFS Traversal of Graph to check neighbours
    private static void checkNeighbours(int[][] arr, int row, int col, boolean[][] visited) {
        if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] != 1 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        checkNeighbours(arr, row, col + 1, visited);
        checkNeighbours(arr, row, col - 1, visited);
        checkNeighbours(arr, row + 1, col, visited);
        checkNeighbours(arr, row - 1, col, visited);
    }

}
