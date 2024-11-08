package hashMap.leetcode840;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length - 2; i++){
            for(int j = 0; j < grid[0].length - 2; j++){
                if(isMagic(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagic(int[][] grid, int i, int j){
        boolean[] seen = new boolean[10];
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                int num = grid[i + x][j + y];
                if(num < 1 || num > 9 || seen[num]){
                    return false;
                }
                seen[num] = true;
            }
        }
        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];

        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int sum8 = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];

        return sum1 == 15 && sum2 == 15 && sum3 == 15 && sum4 == 15 && sum5 == 15
                && sum6 == 15 && sum7 == 15 && sum8 == 15;
    }
}