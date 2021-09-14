class Solution {
    public int solution(int[] numbers, int target) {
        return dfs( numbers, target, 0 );
    }
    
    private int dfs( int[] numbers, int target, int index )
    {
        if( index == numbers.length && target == 0 )
            return 1;
        else if( index < numbers.length )
        {
            return dfs( numbers, target - numbers[ index ], index + 1 ) +
                dfs( numbers, target + numbers[ index ], index + 1 );
        }
        else
            return 0;
    }
}
