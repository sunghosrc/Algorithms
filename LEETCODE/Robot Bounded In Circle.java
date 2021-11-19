class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        char direction = 'U'; //u,d,l,r
        
        for(int i=0;i<instructions.length();i++){
            char s = instructions.charAt(i);
            // System.out.println(direction);
            if(s == 'L'){
                if( direction == 'U' ){
                    direction = 'L';
                } else if( direction == 'D' ){
                    direction = 'R';
                } else if( direction == 'L' ){
                    direction = 'D';
                } else {
                    direction = 'U';
                }
            } else if(s == 'R'){
                if( direction == 'U' ){
                    direction = 'R';
                } else if( direction == 'D' ){
                    direction = 'L';
                } else if( direction == 'L' ){
                    direction = 'U';
                } else {
                    direction = 'D';
                }
            } else {
                if( direction == 'U' ){
                    y++;
                } else if( direction == 'D' ){
                    y--;
                } else if( direction == 'L' ){
                    x--;
                } else {
                    x++;
                }
            }
        }
        // System.out.println("x: " + x + " y: " + y );
        return x == 0 && y == 0 || direction != 'U';
    }
}
