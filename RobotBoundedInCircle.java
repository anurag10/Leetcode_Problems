class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        
        // find final place and final direction
        
        int x = 0, y = 0;
        int dir = 0;
        
        int next[][] = {
            {0, 1}, // N
            {-1, 0}, // W
            {0, -1}, // S
            {1, 0}, // E 
        };
        
        // 0 : North 1: West 2: South 3: East
        
        for(int i = 0; i < instructions.length(); i++)
        {
            char c = instructions.charAt(i);
            if (c == 'G')
            {
                x = x + next[dir][0];
                y = y + next[dir][1];
            }
            else if (c == 'L')
            {
                dir = (dir+1) % 4;
            }
            else
            {
                dir = (dir+3) % 4;
            }
        }
        
        if (x == 0 && y == 0)
            return true;
        
        if (dir != 0)
            return true;
        
        return false;
        
    }
}