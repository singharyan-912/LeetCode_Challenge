import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] result = new int[qLen];
        int[] serverCount = new int[n + 1];
        int activeServers = 0;

        int left = 0;
        int right = 0;
        int logsLen = logs.length;

        for (int i = 0; i < qLen; i++) {
            int qTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            int windowStart = qTime - x;
            int windowEnd = qTime;

            while (right < logsLen && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                right++;
            }

            while (left < logsLen && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            result[originalIdx] = n - activeServers;
        }

        return result;
    }
}