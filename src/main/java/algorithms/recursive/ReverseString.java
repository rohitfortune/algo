package algorithms.recursive;


public class ReverseString {

    public static void main(String[] args) {
        String str = "Rohit";
        System.out.println(reverse(str));
    }

    public static String reverse(String str)
    {
        if (str == null || str.length() <= 1){
            return str;
        }
        return str.charAt(str.length()-1) + reverse(str.substring(0,str.length()-1));

    }
}
