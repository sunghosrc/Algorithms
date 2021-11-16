class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        double y = Math.max(w,h);
        double x = Math.min(w,h);
        for( int i = 1; i <= x; i++ ){
            answer += Math.ceil((double)y*i/x)-Math.floor((double)y*(i-1)/x);
        }
        return (long)w*(long)h-answer;
    }
    //slope = w/h;
}
