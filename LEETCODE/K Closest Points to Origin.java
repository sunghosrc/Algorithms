class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //1.Sort the points then get k
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> ( ((a[0]*a[0]) + (a[1]*a[1])) - ((b[0]*b[0]) + (b[1]*b[1])) )
        );
        for( int[] point : points ){
            pq.offer(point);
        }
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
        
        //2.Quicksort till k
        int l = 0, r = points.length-1;
    
        while( l <= r ){
            int mid = getMid(points,l,r);
            if(mid==k)
                break;
            else if(mid>k)
                r=mid-1;
            else
                l=mid+1;
        }
        return Arrays.copyOfRange(points,0,k);
    }
    
    private int getMid(int[][] points, int l, int r){
        int[] pivot = points[l];
        while(l<r){
            while( l<r && distance(points[r],pivot) >= 0 ) r--;
            points[l] = points[r];
            while( l<r && distance(points[l],pivot) <= 0 ) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    private int distance(int[] p1, int[] p2){
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }
}
