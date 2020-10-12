/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
Input: nums = [10,2]
Output: "210"

Input: nums = [3,30,34,5,9]
Output: "9534330"
*/

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "0";
        String arr[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            arr[i] = Integer.toString(nums[i]);
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b)
            {
                String x = a+b;
                String y = b+a;
                return y.compareTo(x);
            }
        });

        // [0,0,0,0] => "0"
        if (Integer.parseInt(arr[0]) == 0)
            return "0";

        StringBuilder ans = new StringBuilder();
        for(String s : arr)
        {
            ans.append(s);            
        }
        return ans.toString();
    }
}