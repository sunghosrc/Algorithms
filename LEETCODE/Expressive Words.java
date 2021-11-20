class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for( String word : words ){
            if( isStretchy(s,word) )
                res++;
        }
        return res;
    }
    
    private boolean isStretchy(String s, String word){
        int i = 0;
        int j = 0;
        while( i < s.length() && j < word.length() ){
            if( s.charAt(i) != word.charAt(j) )
                return false;

            int repeat1 = repeatedLettersCount(s,i);
            int repeat2 = repeatedLettersCount(word,j);

            if( (repeat1 < 3 && repeat1 != repeat2) || (repeat1 >= 3 && repeat1 < repeat2) )
                return false;

            i += repeat1;
            j += repeat2;
        }

        return i == s.length() && j == word.length();
    }
    
    private int repeatedLettersCount( String s, int i){
        int j = i;
        char c = s.charAt(i);
        while( j < s.length() && c == s.charAt(j)){
            j++;
        }
        return j-i;
    }
}
