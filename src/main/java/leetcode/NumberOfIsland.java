package leetcode;

import templates.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args){
        System.out.println(numIslands(
                new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1',}}
        ));
    }
    public static int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int answer = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] currentLocation = queue.poll();
                        int x = currentLocation[0];
                        int y = currentLocation[1];
                        if(x-1 >= 0&& !visited[x-1][y] && grid[x-1][y]=='1'){
                            queue.offer(new int[]{x-1,y});
                            visited[x-1][y] = true;
                        }
                        if(y-1 >= 0&& !visited[x][y-1] && grid[x][y-1]=='1'){
                            queue.offer(new int[]{x,y-1});
                            visited[x][y-1] = true;
                        }
                        if(x+1 < grid.length&& !visited[x+1][y] && grid[x+1][y]=='1'){
                            queue.offer(new int[]{x+1,y});
                            visited[x+1][y] = true;
                        }
                        if(y+1 < grid[0].length&& !visited[x][y+1] && grid[x][y+1]=='1'){
                            queue.offer(new int[]{x,y+1});
                            visited[x][y+1] = true;
                        }
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}

