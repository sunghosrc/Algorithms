class Solution {
    public int singleNonDuplicate(int[] nums) {
        // normally even,odd indices are pairs
        
        int l = 0, r = nums.length - 1;
        while( l <= r ){
            int mid = ( l + r ) / 2;
            if( mid == 0 || mid == nums.length - 1 ){
                return nums[mid];
            } else {
                if( nums[mid-1] != nums[mid] ){
                    if( nums[mid] != nums[mid+1] )
                        return nums[mid];
                    else {
                        if( mid % 2 == 0 )
                            l = mid + 1;
                        else
                            r = mid - 1;
                    }
                } else {
                    if( (mid-1) % 2 == 0 )
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
            }
        }
        return nums[l];
    }
}
