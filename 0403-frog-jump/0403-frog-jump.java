import java.util.HashMap;

class Solution {
    private HashMap<String, Boolean> memo;
    private HashMap<Integer, Integer> stoneMap;

    public boolean canCross(int[] stones) {

        if (stones.length > 1 && stones[1] != 1) {
            return false;
        }

        memo = new HashMap<>();
        stoneMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            stoneMap.put(stones[i], i);
        }

        return solve(stones, 0, 0);
    }

    private boolean solve(int[] stones, int currentIndex, int prevJump) {

        if (currentIndex == stones.length - 1) {
            return true;
        }

        String stateKey = currentIndex + "," + prevJump;
        if (memo.containsKey(stateKey)) {
            return memo.get(stateKey);
        }

        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextPosition = stones[currentIndex] + nextJump;
                if (stoneMap.containsKey(nextPosition)) {
                    int nextIndex = stoneMap.get(nextPosition);
                    if (solve(stones, nextIndex, nextJump)) {
                        memo.put(stateKey, true);
                        return true;
                    }
                }
            }
        }

        memo.put(stateKey, false);
        return false;
    }
}