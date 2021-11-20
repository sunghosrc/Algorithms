class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList<>();
        
        visited[1] = true;
        q.offer(1);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for( int k = 0; k < size; k++ ){
                int curr = q.poll();
                for( int i = 1; i <= 6; i++ ){
                    int next = curr + i;
                    int[] p = numberToPoint(next,n);
                    if(board[p[0]][p[1]]>0){
                        next = board[p[0]][p[1]];
                    }
                    if(next==n*n)
                        return steps;
                    if(!visited[next]){
                        q.offer(next);
                        visited[next]=true;
                    }
                }
            }
            steps++;
        }
        return -1;
        
    }
    
    private int pointToNumber( int i, int j, int n ){
        return ( n - 1 - i ) % 2 == 0 ? 
                ( n - 1 - i ) / 2 * ( n * 2 ) + j + 1:
                ( n - 1 - i + 1 ) / 2 * ( n * 2 ) - j;
    }
    
    private int[] numberToPoint( int curr, int n ){
        curr--;
        int[] p = new int[2];
        p[0] = n - ( curr / n ) - 1;
        if( ( ( n - p[0] - 1 ) % 2 ) == 0 ){
            p[1] = curr % n;
        } else {
            p[1] = n - ( curr % n ) - 1;
        }
        return p;
    }
}
