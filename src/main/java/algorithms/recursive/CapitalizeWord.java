package algorithms.recursive;

import java.util.Arrays;

public class CapitalizeWord {

    public static void main(String[] args) {
        System.out.println(capitalizeWord2("i love kotlin"));
    }

    public static String capitalizeWord(String str){
        if (str == null || str.isEmpty()){
            return str;
        }

        if (str.split(" ").length == 1){
            return str.substring(0,1).toUpperCase() + str.substring(1, str.length());
        }

        String[] strArr = str.split(" ");
        String capitalizeString = "";
        for(int i =0; i<strArr.length; i++){
            capitalizeString +=" "+ capitalizeWord(strArr[i]);
        }

        return capitalizeString.trim();
    }

    public static String capitalizeWord2(String str) {

        if(str.isEmpty()) {
            return str;
        }
        char chr = str.charAt(str.length()-1);
        if(str.length()==1) {
            return Character.toString(Character.toUpperCase(chr));
        }
        if((str.substring(str.length()-2, str.length()-1).equals(" "))) {
            chr = Character.toUpperCase(chr);
        }
        return capitalizeWord(str.substring(0,str.length()-1))+ Character.toString(chr);
    }
}
