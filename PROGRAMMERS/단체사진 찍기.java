import java.util.*;

class Solution {
    static final int FRIENDS_LENGTH = 8;
    static final char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public int solution(int n, String[] data) {
        int[] indices = new int[26];
        char[] pattern = new char[FRIENDS_LENGTH];
        boolean[] used = new boolean[26];
        return findMatchedPatterns(0,pattern,indices,used,data);
    }

    private int findMatchedPatterns(int idx,char[] pattern,int[] indices, boolean[] used, String[] data){
        if( idx >= FRIENDS_LENGTH ){
            // System.out.println(new String(pattern));
            if( match(data,indices) ){
                return 1;
            } else {
                return 0;
            }
        }

        int sum = 0;
        for(int i = 0; i < FRIENDS_LENGTH; i++){
            if(!used[friends[i]-'A']){
                used[friends[i]-'A'] = true;
                pattern[idx] = friends[i];
                indices[friends[i]-'A']=idx;
                sum += findMatchedPatterns(idx+1,pattern,indices,used,data);
                used[friends[i]-'A'] = false;
            }
        }
        return sum;
    }

    private boolean match(String[] data, int[] indices){
        for( String rule : data ){
            char f1 = rule.charAt(0);
            char f2 = rule.charAt(2);
            char op = rule.charAt(3);
            int dis = rule.charAt(4)-'0'+1;

            int a = indices[f1-'A'];
            int b = indices[f2-'A'];
            int c = Math.abs(a-b);
            if( op == '=' ){
                if(c != dis)
                    return false;
            } else if( op == '<' ){
                if(c >= dis)
                    return false;
            } else {
                if(c <= dis)
                    return false;
            }
        }
        return true;
    }

    //pattern's character's indices
}
