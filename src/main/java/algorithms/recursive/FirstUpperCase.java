package algorithms.recursive;

public class FirstUpperCase {
    public static void main(String[] args) {
        System.out.println(first("RoHit"));
        System.out.println(first("rohiT"));
    }

    static char first(String str) {

        if (Character.toUpperCase(str.charAt(0)) ==  str.charAt(0)){
            return str.charAt(0);
        }
        else {
            return first(str.substring(1, str.length()));
        }

    }
}
