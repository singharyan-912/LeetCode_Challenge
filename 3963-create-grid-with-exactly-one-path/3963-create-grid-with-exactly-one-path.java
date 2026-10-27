import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] createGrid(int m, int n) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == n - 1) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            result.add(sb.toString());
        }

        return result.toArray(new String[0]);
    }
}