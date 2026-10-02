class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;

        // Find rotten oranges and count fresh oranges
        for(int i = 0; i < grid.length; i++) {

            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }

                if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // No fresh oranges
        if(freshCount == 0) {
            return 0;
        }

        int minutes = 0;

        // UP, DOWN, LEFT, RIGHT
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {

                int[] current = queue.poll();

                for(int d = 0; d < 4; d++) {

                    int newRow = current[0] + dr[d];
                    int newCol = current[1] + dc[d];

                    if(newRow >= 0 && newRow < grid.length &&
                       newCol >= 0 && newCol < grid[0].length &&
                       grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        freshCount--;

                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }

            if(!queue.isEmpty()) {
                minutes++;
            }
        }

        // All fresh oranges became rotten
        if(freshCount == 0) {
            return minutes;
        }

        // Some fresh oranges were unreachable
        return -1;
    }
}