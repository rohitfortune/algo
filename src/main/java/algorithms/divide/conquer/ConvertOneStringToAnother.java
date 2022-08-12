package algorithms.divide.conquer;

import java.util.HashMap;

public class ConvertOneStringToAnother {

  //Divide and Conquer
  private int findMinOperations (String s1, String s2, int i1, int i2) {
    if (i1 == s1.length()) {
      return s2.length() - i2;
    }
    if (i2 == s2.length()) {
      return s1.length() - i1;
    }

    if (s1.charAt(i1)==s2.charAt(i2)) {
      return findMinOperations(s1, s2, i1+1, i2+1);
    }
    int deleteOp = 1 + findMinOperations(s1, s2, i1+1, i2);
    int insertOp = 1 + findMinOperations(s1, s2, i1, i2+1);
    int replaceOp = 1 + findMinOperations(s1, s2, i1+1, i2+1);
    return Math.min(deleteOp, Math.min(insertOp, replaceOp));
  }

  public int findMinOperations(String s1, String s2) {
    return findMinOperations(s1, s2, 0, 0);
  }



  //Dynamic Programming using Top-Down Approach
  public int findMinOperationsTD(String s1, String s2) {
    HashMap<String, Integer> dict = new HashMap<>();
    return findMinOperations(s1, s2, 0, 0, dict);
  }
  private int findMinOperations (String s1, String s2, int i1, int i2, HashMap<String, Integer> dict) {
    if (i1 == s1.length()) {
      return s2.length() - i2;
    }
    if (i2 == s2.length()) {
      return s1.length() - i1;
    }
    if (s1.charAt(i1)==s2.charAt(i2)) {
      return findMinOperations(s1, s2, i1+1, i2+1, dict);
    }
    String key = String.valueOf(s1.charAt(i1) + s2.charAt(i2));
    if(!dict.containsKey(key)){
      int deleteOp = 1 + findMinOperations(s1, s2, i1+1, i2, dict);
      int insertOp = 1 + findMinOperations(s1, s2, i1, i2+1, dict);
      int replaceOp = 1 + findMinOperations(s1, s2, i1+1, i2+1, dict);
      dict.put(key,  Math.min(deleteOp, Math.min(insertOp, replaceOp)));
    }
    return dict.get(key);
  }

  //DP Bottom-Up Approach
  public int findMinOperationsBU(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];

    for (int i1 = 0; i1 <= s1.length(); i1++) // if we have reached the end of s1, then insert all the remaining characters of s2
      dp[i1][0] = i1;

    for (int i2 = 0; i2 <= s2.length(); i2++) // if we have reached the end of s2, then delete all the remaining characters of s1
      dp[0][i2] = i2;

    for (int i1 = 1; i1 <= s1.length(); i1++) {
      for (int i2 = 1; i2 <= s2.length(); i2++) { // If the strings have a matching character, recursively match for the remaining lengths.
        if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
          dp[i1][i2] = dp[i1 - 1][i2 - 1];
        else
          dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], // delete
                  Math.min(dp[i1][i2 - 1], // insert
                          dp[i1 - 1][i2 - 1])); // replace
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
