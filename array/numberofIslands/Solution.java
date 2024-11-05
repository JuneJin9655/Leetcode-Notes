package array.numberofIslands;
/*
For this problem, we need to use DFS. First, we build a main function to traverse the 2D matrix until
we find a '1'. When we find a '1', we increment numIslands and then call the DFS function to change
all connected '1's to '0's. Once DFS exits, we return to the main function to continue searching
for any remaining '1's.;
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int numIsland = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
