/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet <String> map = new HashSet();
        for(String srt : wordDict)
        {
            map.add(srt);
        }

        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[0] = true;
        for(int end = 1; end <= len; end++)
        {
            // for(int st = 0; st < end; st++)
            for(int st = end-1; st >= 0; st--)
            {
                String temp = s.substring(st,end);
                if (map.contains(temp) && (dp[st]))
                {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}