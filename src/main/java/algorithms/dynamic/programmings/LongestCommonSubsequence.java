package algorithms.dynamic.programmings;

public class LongestCommonSubsequence {
    static char[] lcs(String x, String y, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int index=dp[m][n];
        char[] result = new char[index];
        int i=m;
        int j=n;
        while(i >0 && j>0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                result[index-1]= x.charAt(i-1);
                i--;j--;
                index--;
            }
            else if(dp[i][j-1] < dp[i-1][j]){
                i--;
            }
            else{
                j--;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        char[] res = lcs("ABCBDAB", "BDCABA", 7, 6);
        System.out.println(res);
    }


}
