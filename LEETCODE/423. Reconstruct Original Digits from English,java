class Solution {
    public String originalDigits(String s) {
        if(s==null)
            return "";
        int[] counts = new int[10];
        int[] characters = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++ ){
            char c = chars[i];
            characters[c-'a']++;
        }
        
        //0
        if(characters['z'-'a'] > 0 ){
            int count = characters['z'-'a'];
            counts[0] = count;
            characters['z'-'a'] -= count;
            characters['e'-'a'] -= count;
            characters['r'-'a'] -= count;
            characters['o'-'a'] -= count;
        }
        
        //2
        if(characters['w'-'a'] > 0 ){
            int count = characters['w'-'a'];
            counts[2] = count;
            characters['t'-'a'] -= count;
            characters['w'-'a'] -= count;
            characters['o'-'a'] -= count;
        }
        
        //4
        if(characters['u'-'a'] > 0 ){
            int count = characters['u'-'a'];
            counts[4] = count;
            characters['f'-'a'] -= count;
            characters['o'-'a'] -= count;
            characters['u'-'a'] -= count;
            characters['r'-'a'] -= count;
        }
        
        //5
        if(characters['f'-'a'] > 0 ){
            int count = characters['f'-'a'];
            counts[5] = count;
            characters['f'-'a'] -= count;
            characters['i'-'a'] -= count;
            characters['v'-'a'] -= count;
            characters['e'-'a'] -= count;
        }
        
        //6
        if(characters['x'-'a'] > 0 ){
            int count = characters['x'-'a'];
            counts[6] = count;
            characters['s'-'a'] -= count;
            characters['i'-'a'] -= count;
            characters['x'-'a'] -= count;
        }
        
        //7
        if(characters['s'-'a'] > 0 ){
            int count = characters['s'-'a'];
            counts[7] = count;
            characters['s'-'a'] -= count;
            characters['e'-'a'] -= count;
            characters['v'-'a'] -= count;
            characters['e'-'a'] -= count;
            characters['n'-'a'] -= count;
        }
        
        //8
        if(characters['g'-'a'] > 0 ){
            int count = characters['g'-'a'];
            counts[8] = count;
            characters['e'-'a'] -= count;
            characters['i'-'a'] -= count;
            characters['g'-'a'] -= count;
            characters['h'-'a'] -= count;
            characters['t'-'a'] -= count;
        }
        
        //3
        if(characters['h'-'a'] > 0 ){
            int count = characters['h'-'a'];
            counts[3] = count;
            characters['t'-'a'] -= count;
            characters['h'-'a'] -= count;
            characters['r'-'a'] -= count;
            characters['e'-'a'] -= (count*2);
        }
        
        //1
        if(characters['o'-'a'] > 0 ){
            int count = characters['o'-'a'];
            counts[1] = count;
            characters['o'-'a'] -= count;
            characters['n'-'a'] -= count;
            characters['e'-'a'] -= count;
        }
        
        //9
        if(characters['n'-'a'] > 0 ){
            int count = characters['n'-'a'];
            counts[9] = (count/2);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<counts.length;i++){
            int count = counts[i];
            for(int j=0;j<count;j++)
                sb.append(i);
        }
        return sb.toString();
    }
}
