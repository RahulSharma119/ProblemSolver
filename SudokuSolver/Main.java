class Main {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
            {1,0,0,7,11,0,0,15,0,9,10,6,12,0,0,5},
            {0,15,0,0,0,13,7,0,2,1,12,0,0,0,4,0},
            {0,0,3,0,0,1,14,0,4,0,0,5,0,9,0,0},
            {4,0,0,10,5,0,0,6,0,3,13,0,11,0,0,1},
            {10,0,11,0,0,4,12,0,0,2,16,0,0,8,0,7},
            {0,6,0,8,15,0,0,1,10,0,0,7,13,0,14,0},
            {0,0,1,16,7,0,0,2,6,0,0,12,10,11,0,0},
            {14,0,15,0,0,10,6,0,0,13,3,0,0,12,0,4},
            {16,0,4,0,0,15,8,0,0,6,2,0,0,5,0,10},
            {0,0,2,6,1,0,0,5,13,0,0,8,9,4,0,0},
            {0,13,0,12,9,0,0,3,15,0,0,16,1,0,2,0},
            {11,0,8,0,0,6,16,0,0,5,9,0,0,13,0,12},
            {13,0,0,14,0,9,15,0,5,0,0,2,4,0,0,11},
            {0,0,6,0,4,0,0,10,0,16,7,0,0,1,0,0},
            {0,8,0,0,0,16,1,11,0,15,6,0,0,0,13,0},
            {2,0,0,4,12,8,5,0,14,0,0,3,15,0,0,9}
        };
        Solution.solveSudoku(mat);
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){
                System.out.print(mat[i][j]+", ");
            }
            System.out.println();
        }
        
    }
}
class Solution {
    static int[][] grid;
    static int n,box;
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        n = mat.length;
        box=(int)Math.sqrt(n);
        grid=mat;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    solve(i,j);
                    return;
                }
            }
        }
    }
    static boolean solve(int x, int y){
        int nx=-1,ny=-1;
        for(int i=x;i<n && nx==-1;i++){
            for(int j=((i==x)?(y+1):(0));j<n;j++){
                if(grid[i][j]==0){
                    nx=i;
                    ny=j;
                    break;
                }
            }
        }
        for(int num=1;num<=n;num++){
            grid[x][y]=num;
            if(check(x,y)){
                if(nx==-1) return true;
                if(solve(nx,ny)) return true;
            }
        }
        grid[x][y]=0;
        return false;
    }
    static boolean check(int x,int y){
        for(int i=0;i<n;i++){
            if(i!=y && grid[x][i] == grid[x][y]) return false;
        }
        for(int i=0;i<n;i++){
            if(i!=x && grid[i][y] == grid[x][y]) return false;
        }
        int sx=(x/box)*box;
        int sy=(y/box)*box;
        for(int i=0;i<box;i++){
            for(int j=0;j<box;j++){
                if((sx+i)==x &&(sy+j)==y) continue;
                if(grid[sx+i][sy+j] == grid[x][y]) return false;
            }
        }
        return true;
    }
}
