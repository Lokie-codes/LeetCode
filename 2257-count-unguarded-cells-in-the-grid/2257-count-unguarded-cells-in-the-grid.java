class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 0: empty, 1: guard, 2: wall, 3: guarded
        int[][] grid = new int[m][n];
        
        // Mark guards
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        
        // Mark walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        
        // For each guard, mark all cells they can see in 4 directions
        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];
            
            // Look right
            for (int j = c + 1; j < n; j++) {
                if (grid[r][j] == 1 || grid[r][j] == 2) break;
                grid[r][j] = 3;
            }
            
            // Look left
            for (int j = c - 1; j >= 0; j--) {
                if (grid[r][j] == 1 || grid[r][j] == 2) break;
                grid[r][j] = 3;
            }
            
            // Look down
            for (int i = r + 1; i < m; i++) {
                if (grid[i][c] == 1 || grid[i][c] == 2) break;
                grid[i][c] = 3;
            }
            
            // Look up
            for (int i = r - 1; i >= 0; i--) {
                if (grid[i][c] == 1 || grid[i][c] == 2) break;
                grid[i][c] = 3;
            }
        }
        
        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }
        
        return unguardedCount;
    }
}
