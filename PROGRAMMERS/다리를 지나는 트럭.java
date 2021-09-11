import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int                 curr_weight = 0;
        Queue< Truck >      queue       = new LinkedList<>();
        int                 time        = 0;
        for( int truck_weight : truck_weights )
        {
            int next_weight = curr_weight + truck_weight;
            
            if( next_weight > weight ) //overweight
            {
                while( !queue.isEmpty() && next_weight > weight )
                {
                    Truck truck = queue.poll();
                    next_weight -= truck.weight; 
                    time += ( bridge_length + truck.crossed_at ) - time;
                }
                queue.offer( new Truck( truck_weight, time ) );
            }
            else
            {
                time++;
                queue.offer( new Truck( truck_weight, time ) );
                
                while( !queue.isEmpty() && time - queue.peek().crossed_at  >= bridge_length )
                {
                    Truck truck = queue.poll();
                    next_weight -= truck.weight;
                }
            }

            curr_weight = next_weight;
            // System.out.println( time + ": " + truck_weight + "(" + curr_weight + ")" );
        }
    
        return time + bridge_length;
    }
}

class Truck {
    public int weight;
    public int crossed_at;
    
    public Truck ( int w, int t )
    {
        this.weight     = w;
        this.crossed_at = t;
    }
}
