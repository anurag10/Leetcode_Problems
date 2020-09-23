/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class MajorityElementI {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int candidate = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if (cnt == 0)
            {
                candidate = nums[i];
            }
            
            cnt = (candidate == nums[i]) ? cnt+1 : cnt-1;
        }
        return candidate;
    }
}