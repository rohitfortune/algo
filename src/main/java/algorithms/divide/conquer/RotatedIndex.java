package algorithms.divide.conquer;

/*findRotatedIndex([3, 4, 1, 2], 4) # 1
        findRotatedIndex([4, 6, 7, 8, 9, 1, 2, 3, 4], 8) # 3
        findRotatedIndex([6, 7, 8, 9, 1, 2, 3, 4], 3) # 6
        findRotatedIndex([37, 44, 66, 102, 10, 22], 14) # -1
        findRotatedIndex([6, 7, 8, 9, 1, 2, 3, 4], 12) # -1
        findRotatedIndex([11, 12, 13, 14, 15, 16, 3, 5, 7, 9], 16) # 5
        findRotatedIndex([11, 12, 13, 17, 39], 17) # 3
        findRotatedIndex([11], 11) # 0
        findRotatedIndex([], 11) # -1
        findRotatedIndex([4, 4, 4, 4, 4], 5) # -1*/

public class RotatedIndex {
    public static int findRotatedIndex(int[] arr, int num) {
        int right=arr.length-1;
        int left=0;
        int mid=(left+right)/2;
        int i=mid;
        int j=mid;

        while(i>=0 && j<arr.length){
            if(arr[i]>arr[i-1]){
                i--;
            }else{
                left=i;
                break;
            }
            if(arr[j]<arr[j+1]){
                j++;
            }
            else{
                left=j+1;
                break;
            }
        }
        if(num<=arr[left-1] && num>=arr[0]){
            right=left-1;
            left=0;
        }


        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]>num){
                right=mid-1;
            }
            else if(num>arr[mid]){
                left=mid+1;
            }
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr={4, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.printf("Rotated Index: "+ findRotatedIndex(arr, 8));
    }
}
