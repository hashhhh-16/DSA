class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long max = 0;
        for(int i = 0; i < piles.length; i++)
        {
            if(piles[i] > max)
            {
                max = piles[i];
            }
        }

        long low = 1;
        long high = max;
        long ans = high;
        while(low <= high)
        {
            long mid = low + (high - low) / 2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++)
            {
                hours += (piles[i] + mid - 1) / mid;
            }
            if(hours <= h)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
                   
        }
        return (int) ans;
        
    }
}