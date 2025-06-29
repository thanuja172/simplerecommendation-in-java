public class SimpleRecommendation {
    public static void main(String[] args) {
        // Sample user-item data
        // Rows = users, Columns = items (1 means liked, 0 means not liked)
        int[][] data = {
            {1, 1, 0, 0}, // User 0
            {1, 1, 1, 0}, // User 1
            {0, 0, 1, 1}, // User 2
            {1, 0, 0, 1}  // User 3
        };

        int user = 0; // Recommend for User 0
        int[] userData = data[user];

        // Find similar user
        int maxCommon = -1;
        int similarUser = -1;

        for (int i = 0; i < data.length; i++) {
            if (i == user) continue;
            int common = 0;
            for (int j = 0; j < data[i].length; j++) {
                if (userData[j] == 1 && data[i][j] == 1) {
                    common++;
                }
            }
            if (common > maxCommon) {
                maxCommon = common;
                similarUser = i;
            }
        }

        // Recommend item liked by similar user but not by current user
        System.out.println("Recommended items for User " + user + ":");
        for (int j = 0; j < data[0].length; j++) {
            if (data[similarUser][j] == 1 && userData[j] == 0) {
                System.out.println("Item " + j);
            }
        }
    }
}

