package algorithms.dynamic.programmings;

public class LargestPalindromeSequence {
    public static int findLPSLengthBU(String st) {
        int m= st.length();
        int[][] dp = new int[m][m];

        for(int i=0; i<m; i++)
            dp[i][i]=1;

        for(int col=1; col<m; col++){
            for(int row=0; row+col<m; row++){
                if(st.charAt(row) == st.charAt(row+col)){
                    dp[row][row+col] = 2 + dp[row+1][row+col-1];
                }
                else{
                    dp[row][row+col] = Math.max(dp[row][row+col-1], dp[row+1][row+col]);
                }
            }
        }
        displayMatrix(st, m, dp);
        return dp[0][m-1];

    }

    public static String longestPalindrome(String st) {
        int m= st.length();
        int[][] dp = new int[m][m];

        for(int i=0; i<m; i++)
            dp[i][i]=1;

        for(int col=1; col<m; col++){
            for(int row=0; row+col<m; row++){
                if(st.charAt(row) == st.charAt(row+col)){
                    dp[row][row+col] = 2 + dp[row+1][row+col-1];
                }
                else{
                    dp[row][row+col] = Math.max(dp[row][row+col-1], dp[row+1][row+col]);
                }
            }
        }
        int i=0;
        int j=m-1;
        int length =  dp[0][m-1];
        char[] result = new char[length];
        int index=0;
        while(i<=j){
            if(st.charAt(i)==st.charAt(j)){
                result[index++]=st.charAt(i);
                i++;j--;
            }
            else if(dp[i][j-1] < dp[i+1][j]){
                i++;
            }
            else{
                j--;
            }
        }
        int startIndex=(length/2)-1;
        while(index<length){
            result[index++]=result[startIndex--];
        }
        return String.copyValueOf(result);
    }


    private static void displayMatrix(String st, int m, int[][] dp) {
        for(int i = 0; i< m; i++)
            System.out.print("\t"+ st.charAt(i));
        System.out.println();
        for (int i = 0; i< m; i++){
            System.out.print(st.charAt(i));
            for (int j = 0; j< m; j++){
                System.out.print("\t"+ dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int l = findLPSLengthBU("ELRMENMET");
        System.out.println("Length: "+l);
        System.out.println(longestPalindrome("ELRMENMET"));
    }
}
