// Time Complexity : O(n*n!) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    List<List<String>> output= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]='.';
            }        
        }
        
        backtracking(board,n,0);
        
        return output;
    }
    
    public void backtracking(char[][] board, int leftQueens, int row){
        
        if(leftQueens<=0){
            output.add(makeoutput(board));
            return;    
        }
        
        for(int col=0;col<board.length;col++){
            if(isValid(board, row, col)){
                board[row][col]='Q';
                backtracking(board, leftQueens-1, row+1);
                board[row][col]='.';   
            }
        } 
    }
    
    public List<String> makeoutput(char[][] board){
        List retlist = new ArrayList();
        for(int i=0;i<board.length;i++){
            String temp = "";
            for(int j=0;j<board[0].length;j++){
                temp+=board[i][j];
            }
            retlist.add(temp);
        }
        return retlist;
    }
    public boolean isValid(char[][] board, int row, int col){
        
        int r=row;
        int c=col;
        
        while(r>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
        }
        
         r=row;
         c=col;
        
        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;c--;
        }
        
         r=row;
         c=col;
        
        while(r>=0 && c<board.length){
            if (board[r][c]=='Q'){
                return false;
            }
            r--;c++;
        }
        return true;
    }
}