package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args){

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] pos = new int[][]{{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{0,0});
                }
            }
        }
        return 0;
    }
}
