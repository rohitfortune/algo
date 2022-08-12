package algorithms.divide.conquer;

public class HouseRobber {

  private int maxMoneyRecursive(int[] HouseNetWorth, int currentIndex) {
    if (currentIndex >= HouseNetWorth.length) {
      return 0;
    }

    int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecursive(HouseNetWorth, currentIndex+2);
    int skipCurrentHouse = maxMoneyRecursive(HouseNetWorth, currentIndex+1);

    return Math.max(stealCurrentHouse,skipCurrentHouse );
  }

  public int maxMoney(int[] HouseNetWorth) {
    return maxMoneyRecursive(HouseNetWorth, 0);
  }


  //Dynamic Programing Top-Down Approach
  public int maxMoneyTopDown(int[] HouseNetWorth) {
    int[] arr = new int[HouseNetWorth.length+2];

    return maxMoneyTopDown(HouseNetWorth, 0, arr);

  }

  public int maxMoneyTopDown(int[] HouseNetWorth, int index, int[] arr) {
    if(index >= HouseNetWorth.length)
      return 0;

    if(arr[index] == 0){
      int skip = maxMoneyTopDown(HouseNetWorth, index+1, arr);
      int take = HouseNetWorth[index] + maxMoneyTopDown(HouseNetWorth, index+2, arr);
      arr[index] = Math.max(skip, take);
    }

    return arr[index];
  }

  //Dynamic Programing Bottom Up Approach
  public int maxMoneyBottomUp(int[] wealth) {

    int[] arr = new int[wealth.length+2];

    for(int i=wealth.length-1; i>=0; i--){
      int skip = arr[i+1];
      int take = wealth[i] + arr[i+2];
      arr[i] = Math.max(skip, take);
    }

    return arr[0];
  }

}
