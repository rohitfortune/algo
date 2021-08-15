package algorithms.recursive;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("wowow"));
    }

    public static boolean isPalindrome(String s)
    {
        if(s == null || s.length() < 1 ){
            return false;
        }
        if(s.length() == 1){
            return true;
        }
        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
    }
}
