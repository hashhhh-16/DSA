class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                currentSum -= 1;
            }
            else
            {
                currentSum += 1;
            }
            if(map.containsKey(currentSum))
            {
                int length = i - map.get(currentSum);
                maxLength = Math.max(maxLength, length);
            }
            else
            {
                map.put(currentSum, i);
            }
        }
        return maxLength;
    }
}