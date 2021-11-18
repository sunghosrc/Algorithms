class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> a.length() - b.length());
        Map<String,Integer> map = new HashMap<>();
        int answer = 0;
        for( String word : words ){
            map.put(word,1);
            int max = 1;
            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                String predecessor = sb.deleteCharAt(i).toString();
                
                if(map.containsKey(predecessor)){
                    max=Math.max(max,map.get(predecessor)+1);
                }
            }
            map.put(word,max);
            answer=Math.max(answer,max);
        }
        return answer;
    }
    
}
