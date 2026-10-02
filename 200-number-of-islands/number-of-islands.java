class Solution {
    public int numIslands(char[][] grid) {
       int islands = 0;
       Queue<int[]> queue = new LinkedList<>();
       int[] dr = {-1,1,0,0};
       int[] dc = {0,0,-1,1};
       for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] =='1'){
                    islands++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        for(int d = 0; d < 4; d++){
                            int newrow = current[0] + dr[d];
                            int newcol = current[1] + dc[d];
                            if(newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol <grid[0].length && grid[newrow][newcol] == '1'){
                                grid[newrow][newcol] = '0';
                                queue.offer(new int[]{newrow, newcol});
                            }
                        }
                    }
                }
            }
        }
        return islands; 
    }
}