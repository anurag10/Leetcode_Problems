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