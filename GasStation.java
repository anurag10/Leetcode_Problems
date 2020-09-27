/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
Note:
    If there exists a solution, it is guaranteed to be unique.
    Both input arrays are non-empty and have the same length.
    Each element in the input arrays is a non-negative integer.

Input: 
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]
Output: 3

Input: 
	gas  = [2,3,4]
	cost = [3,4,3]
Output: -1
*/

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    	if (gas == null)
    		return -1;

    	int n = gas.length;

    	// If sum(gas) >= sum(cost) solution always exits, otherwise return -1
    	int totalGas = 0, totalCost = 0;

		// find maximum sum subarray and return it's starting point;
		int sumTillNow = 0; // gas[0]-cost[0];
		int startIdx = -1;
		for(int i = 0; i < n; i++)
		{
			totalCost += cost[i];
			totalGas += gas[i];

			sumTillNow += (gas[i]-cost[i]);
			if (sumTillNow < 0)
			{
				// reset
				sumTillNow =  0;
				startIdx = -1;
			}
			else if (startIdx < 0)
			{
				startIdx = i;
			}
		}

		if (totalGas < totalCost)
			return -1;
		return startIdx;
    }
}