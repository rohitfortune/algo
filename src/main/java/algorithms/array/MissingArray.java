package algorithms.array;

public class MissingArray {
    public static void main(String[] args) {
        int[] arry = {1,2,3,4,5,6,7,8,9,11};
        printMissingArray(arry);

        //Reverse string without reversing space
        String str = "I am  Rohit   prasad";
        String[] strArr = str.split(" ");
        String revStr="";
        int len = strArr.length;
        int i=0, j=len-1;
        while(i<j){
            if (!strArr[i].isEmpty() && !strArr[j].isEmpty()){
                String temp = strArr[i];
                strArr[i]= strArr[j];
                strArr[j]=temp;
                i++;j--;
            }
            else if (strArr[i].isEmpty())
                i++;
            else
                j--;
        }
        for (String s: strArr) {
            revStr+=s+" ";
        }
        System.out.println("Reverse String: "+revStr.trim()+revStr);
    }

    private static void printMissingArray(int[] arry) {
        int sum1=0, sum2=0;
        for (int i :arry) {
            sum1 += i;
        }
        sum2 = 11*(11+1)/2; //n(n+1)/2
        System.out.println("missing number: "+ (sum2-sum1));
    }
}
