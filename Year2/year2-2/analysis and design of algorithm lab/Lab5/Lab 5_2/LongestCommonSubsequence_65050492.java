import java.util.Scanner;

public class LongestCommonSubsequence_65050492 {

	private static StringBuilder lcsStringBuilder = new StringBuilder();

	public int findLCSLength(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// Reconstruct the LCS
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				lcsStringBuilder.insert(0, str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence_65050492 lcs = new LongestCommonSubsequence_65050492();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the first string: ");
		String s1 = scanner.nextLine();

		System.out.print("Enter the second string: ");
		String s2 = scanner.nextLine();

		int length = lcs.findLCSLength(s1, s2);
		System.out.println("Length of LCS is: " + length);

		if (length > 0) {
			int displayLength = Math.min(4, length); // Display the first four characters
			System.out.println("First four characters of LCS are: " + lcsStringBuilder.substring(0, displayLength));
		}
		scanner.close();
	}
}
