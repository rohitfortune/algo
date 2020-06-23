package com.example.random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    String s;
    public static void main(String[] args) {
        Demo d =new Demo();
        try {
            d.display(4);
        } catch (FileNotFoundException | NullPointerException e) {  
            e.getMessage();
        }
        //aabcacabba
        
        String result= stringMinimization("aabcacabba");
        System.out.println("String minimization: " + result);
        Object o = "abc";
        String reslt= stringMinimization(o);
        

        int[] c= {1,2,2,1,3,6,4,4,4};
        //Arrays.stream(c).map(i -> i/0).forEach(System.out::println);
        int[][] input = {{0,5},{10,20},{25,40},{35,45}};
        int spaces = minParkingSpaces(input);
        System.out.println("Min spaces required: "+spaces);


        try {
           List<Integer> list =  Files.lines(Paths.get("D:\\test.txt")).map(Integer::parseInt).collect(Collectors.toList());
           list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        // YOUR CODE HERE
        List<Set<Integer>> spaces = new ArrayList<>();
        boolean addNewSpace = true;
        l1:for(int i =0; i<parkingStartEndTimes.length; i++){
            for(Set<Integer> space : spaces){
                addNewSpace = false;
                for(Integer idx: space){
                    if(!(parkingStartEndTimes[i][0]
                            <= parkingStartEndTimes[idx][0] && parkingStartEndTimes[i][1]<= parkingStartEndTimes[idx][0]
                            || parkingStartEndTimes[i][0]
                            >= parkingStartEndTimes[idx][1] && parkingStartEndTimes[i][1]>= parkingStartEndTimes[idx][1]))
                        addNewSpace = true;
                }
                if(!addNewSpace){
                    space.add(i);
                    continue l1;
                }
            }
                Set<Integer> space = new HashSet<>();
                space.add(i);
                spaces.add(space);
        }
        return spaces.size();
    }

     private static String stringMinimization(String str) {
        String leftPart= str.substring(0,str.length()/2);
        String rightPart= str.substring(str.length()/2);
        System.out.println( " left part: " +leftPart+ " right part: "+ rightPart);
        System.out.println( "After rotating and remove repeated words from between of: " +rightPart+leftPart);
        int i=-1,j=rightPart.length();
        while(i<leftPart.length()-1){
            i++;j--;
            if (i==leftPart.length() && j<0) {
                return "";
            }
            if (i==leftPart.length())
                return rightPart.substring(0,j+1);
            if (j<0)
                return leftPart.substring(i);
            if (leftPart.charAt(i) != rightPart.charAt(j))
                return rightPart.substring(0,j+1) + leftPart.substring(i);
            while((i+1)<leftPart.length() && leftPart.charAt(i)==leftPart.charAt(i+1))
                i++;
            while((j-1)>=0 && rightPart.charAt(j)==rightPart.charAt(j-1))
                j--;
            //System.out.println("i= "+i+" j= "+j);
        }
        return "";
    }
     
     private static String stringMinimization(Object str) {
        return "";
     }

    void display(int l) throws FileNotFoundException {
        int[] a;
        String local;

        System.out.println("Printing array:"+ s);
        if(l>0)
            a= new int[l];
        else
            a= new int[2];
        for (int n : a) {
            System.out.println(n);
        }
        try{
            String str = null;
            str.concat("abc");
        }
        catch (Exception e){
            throw new FileNotFoundException();
        }
        finally {
            throw new NullPointerException("haha");
        }
    }
}
