/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Note: The algorithm should run in linear time and in O(1) space.

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> ans = new ArrayList();

    	if (nums == null || nums.length == 0)
    		return ans;

    	int n = nums.length;
    	// There can be atmost two elements with > n/3 occurrences
    	// Intuition from MajorityElementI --> Select two candidates and two counts
    	Integer candidate1 = null;
    	Integer candidate2 = null;
    	int cnt1 = 0, cnt2 = 0;

    	for(int a : nums)
    	{
    		if (candidate1 != null && candidate1 == a)
    		{
    			cnt1++;
    		}
    		else if (candidate2 != null && candidate2 == a)
    		{
    			cnt2++;
    		}
    		else if (cnt1 == 0)
    		{
    			candidate1 = a;
    			cnt1 = 1;
    		}
    		else if (cnt2 == 0)
    		{
    			candidate2 = a;
    			cnt2 = 1;
    		}
    		else
    		{
    			cnt1--;
    			cnt2--;
    		}
    	}

    	// check if counts > n/3
    	cnt2 = 0;
    	cnt1 = 0;
    	for(int a : nums)
    	{
    		if (candidate1 != null && candidate1 == a)
    			cnt1++;
    		else if (candidate2 != null && candidate2 == a)
    			cnt2++;
    	}

    	if (cnt1 > n/3)
    		ans.add(candidate1);
    	if (cnt2 > n/3)
    		ans.add(candidate2);
    	return ans;
    }
}