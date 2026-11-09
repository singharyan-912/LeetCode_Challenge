class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int far = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < arr2.length; j++) {
                int dis = Math.abs(arr1[i] - arr2[j]);
                if (dis <= d) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                far++;
            }
        }
        return far;
    }
}
