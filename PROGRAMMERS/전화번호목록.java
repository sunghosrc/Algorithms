import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        PhoneDictionary dictionary  = new PhoneDictionary();
        
        for( String phone_number : phone_book )
        {
            //Null check
            if( phone_number == null || phone_number.isEmpty() )
                continue;
            
            // Get Prefix
            String  strPrefix   = phone_number.substring( 0, 1 );
            int     prefix      = Integer.parseInt( strPrefix );
            
            if( !dictionary.map.containsKey( prefix ) )
                dictionary.map.put( prefix, new PhoneDictionary() );
            else
            {
                if( phone_number.length() == 1 )
                    return false;
            }
            
            PhoneDictionary curr            = dictionary.map.get( prefix );
            boolean         containsAllKeys = true;
            
            // Rest of the numbers
            for( char strNumber : phone_number.substring( 1 ).toCharArray() )
            {
                int number  = Integer.parseInt( String.valueOf( strNumber ) );
                if( !curr.map.containsKey( number ) )
                {
                    if( curr.eos )
                        return false;
                    
                    curr.map.put( number, new PhoneDictionary() );
                    containsAllKeys = containsAllKeys && false;
                }
                curr    = curr.map.get( number );
                
            }
            
            if( containsAllKeys ) 
                return !containsAllKeys;
            
            curr.close();
        }
        return true;
    }
}

class PhoneDictionary{
    public Map< Integer, PhoneDictionary >  map;
    public boolean                          eos;
    
    public PhoneDictionary()
    {
        map = new HashMap<>();
        eos = false;
    }
    
    public void close()
    {
        eos = true;
    }
}
