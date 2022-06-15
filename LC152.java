class Solution {
    public int maxProduct(int[] nums) {
        Integer minPos = 1, maxPos = 1, maxNeg = null, ans = Integer.MIN_VALUE, curr = 1;
        
        for (int num: nums) {
            if (num == 0) {
                ans = Math.max(ans, num);
                minPos = 1;
                maxPos = 1;
                maxNeg = null;
                curr = 1;
                continue;
            } 
            
            curr *= num;
            
            if (curr > 0) {
                ans = Math.max(ans, curr / minPos);
                minPos = Math.min(minPos, curr);
                maxPos = Math.max(maxPos, curr);
            } else {
                ans = Math.max(ans, curr / (maxNeg == null ? maxPos : maxNeg));
                maxNeg = maxNeg == null ? curr : Math.max(maxNeg, curr);
            }
            

        }
        
        return ans;
        
    }
}