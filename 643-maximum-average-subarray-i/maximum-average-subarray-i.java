class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(i >= k)
            {
                sum -= nums[i - k];
            }
            if(i >= k - 1)
            {
                result = Math.max(result, sum);
            }
        }
        return (double) result / k;
    }
}