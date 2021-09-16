import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort( people );
        int start   = 0, end = people.length - 1;
        while( start <= end )
        {
            if( start == end )
            {
                return answer + 1;
            }
                
            int fat     = people[ end ];
            int thin    = people[ start ];
            
            if( fat + thin > limit )
            {
                end--;
                answer++;
            }
            else if( fat + thin <= limit )
            {
                end--;
                start++;
                answer++;
            }
        }
        return answer;
    }
}
