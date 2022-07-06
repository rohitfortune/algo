package ds.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObtainingStream {

	public static void main(String[] args) {
		 int[] c= {1,6,2,2,1,3,6,4,4,4};
	     waysOfObtainingStream(c);
	}

	 private static void waysOfObtainingStream(int[] c) {
	        //lamda expression can only access local variable which is final or effectively final
	        //this keyword inside lamda expression refers to outer class
	        //lamda expression can modify outer class instance variable

	        Map<Integer,Integer> occuranceCount = Arrays.stream(c).boxed()
	                .collect(Collectors.toMap(i-> i, i-> 1, (oldValue, newValue)->oldValue+newValue));

	        System.out.println("Obtain stream from map using keySet: ");
	        occuranceCount.keySet().stream().forEach(System.out::println);

	        System.out.println("Obtain stream from map using entrySet: ");
	        occuranceCount.entrySet().stream().forEach(System.out::println);

	        System.out.println("Obtain stream from String using chars: ");
	        "rohit prasad".chars().forEach(a-> System.out.println(Character.toChars(a)));
	        	        
	        System.out.println("Obtain stream from String using split: ");
	        Arrays.stream("Nice Job".split(" ")).forEach(System.out::println);

	        System.out.println("Obtain stream from Integer array: ");
	        Integer[] intArr = {1,2,3,4,5};
	        Arrays.stream(intArr).forEach(System.out::println);
	        Stream.of(intArr).forEach(System.out::println);

	        System.out.println("Obtain stream from values: ");
	        Stream.of("one", "two", "three").forEach(System.out::println);

	        System.out.println("Obtain stream from function generate: ");
	        Stream.generate(()->Math.random()).limit(3).forEach(System.out::println);

	        System.out.println("Obtain stream from function iterate: ");
	        Stream.iterate(0, i->i+1).limit(7).forEach(System.out::println);

	        System.out.println("Obtain stream from another stream : ");
	        Arrays.stream(c).distinct().sorted().limit(3).forEach(System.out::println);
	    }
}
