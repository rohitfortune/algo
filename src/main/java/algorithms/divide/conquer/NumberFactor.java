package algorithms.divide.conquer;

import java.util.HashMap;

public class NumberFactor {
  public int waysToGetN(int n) {
    if ((n==0) || (n==1) || (n==2)) {
      return 1;
    }
    if (n == 3) {
      return 2; //{1,1,1} {3}
    }
    int sub1 = waysToGetN(n-1);
    int sub2 = waysToGetN(n-3);
    int sub3 = waysToGetN(n-4);

    return sub1+sub2+sub3;

  }

  HashMap<Integer,Integer> memo = new HashMap<>();

  public int waysToGetNTopDown(int n) {
    if(n <= 2)
      return 1;
    if(n == 3)
      return 2;

    if(!memo.containsKey(n)){
      int c1 = waysToGetNTopDown(n-1) + waysToGetNTopDown(n-3) + waysToGetNTopDown(n-4);
      memo.put(n, c1);
    }

    return memo.get(n);
  }
}
