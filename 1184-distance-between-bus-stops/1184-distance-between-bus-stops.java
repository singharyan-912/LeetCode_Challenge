class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = distance[0];
        suffix[n - 1] = distance[n - 1];

        int forwardsum = 0;
        int backwardsum = 0;

        for (int i = 1; i < n; i++) {
            prefix[i] = distance[i] + prefix[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + distance[i];
        }

        int l = Math.min(start, destination);
        int r = Math.max(start, destination);

        for (int i = l; i < r; i++) {
            forwardsum += distance[i];
        }

        backwardsum = prefix[n - 1] - forwardsum;

        return Math.min(forwardsum, backwardsum);
    }
}
