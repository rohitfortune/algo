package com.example.stream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemo {
    public static void main(String[] args) {
        int[] c= {1,6,2,2,1,3,6,4,4,4};
        sortAsPerOccurance(c);
        waysOfObtainingStream(c);

        List<Book> bookList = getBookList();
        //partitioningBy takes a predicate
        System.out.println(bookList.stream().collect(Collectors.partitioningBy(b-> b.getReleaseYear()==1954)));
        //groupingBy takes Function
        System.out.println(bookList.stream().collect(Collectors.groupingBy(b->b.getReleaseYear())));

        System.out.println(bookList.stream().collect(Collectors.partitioningBy(b-> b.getReleaseYear()==1954,
                Collectors.mapping(b->b.getName(), Collectors.toList()))));

        System.out.println(bookList.stream().collect(Collectors.groupingBy(b-> b.getReleaseYear(),
                Collectors.mapping(b-> b.getIsbn(),Collectors.toList()))));

        System.out.println(bookList.stream().collect(Collectors.groupingBy(b->b.getReleaseYear(),
                Collectors.counting())));

        System.out.println("Obtain array from ArrayList using toArray: ");
        Book[] books= bookList.stream().filter(b->b.getReleaseYear()==1954).toArray(Book[]::new);
        Arrays.stream(books).forEach(b->System.out.println(b.getIsbn()+" "+b.getReleaseYear()));

        System.out.println("Obtain Object array from ArrayList using toArray: ");
        Object[] bookObjs= bookList.stream().toArray();
        Arrays.stream(bookObjs).forEach(b-> System.out.println(((Book)b).getIsbn()+" "+((Book)b).getReleaseYear()));

        System.out.println("Obtain list of books grouped by published year");
        Map<Integer,List<Book>> map = bookList.stream().collect(Collectors.groupingBy(b-> b.getReleaseYear(),Collectors.toList()));
        map.entrySet().stream().forEach(e-> System.out.println(((Map.Entry)e).getKey()+" "+((Map.Entry)e).getValue()));

        System.out.println("Obtain set of books published in 1954 ");
        Map<Integer,Set<Book>> map1 = bookList.stream().collect(Collectors.groupingBy(b-> b.getReleaseYear(),Collectors.toSet()));
        map1.entrySet().stream().forEach(e-> System.out.println(((Map.Entry)e).getKey()+" "+((Map.Entry)e).getValue()));

        System.out.println("Obtain collections of books published in 1954 ");
        ArrayList<Book> bookArrayList = bookList.stream().filter(b->b.getReleaseYear()==1955).collect(Collectors.toCollection(ArrayList::new));
        bookArrayList.stream().forEach(System.out::println);

        System.out.println("Test all elements matches predicate ");
        Predicate<Book> p = b-> b.getReleaseYear()==1954;
        System.out.println(bookList.stream().allMatch(p));

        System.out.println("Test whether any elements matches predicate ");
        System.out.println(bookList.stream().anyMatch(p));

        System.out.println("Test whether none elements matches predicate ");
        Predicate<Book> p1 = b-> b.getReleaseYear()==1956;
        System.out.println(bookList.stream().noneMatch(p1));

        boolean boo = (7&1) == 0;
        System.out.println("testing odd or even by bitwise: "+ boo);

        System.out.println("Moddifying ArrayList using replaceAll, sort, removeIf method of List interface which accepts lamda");
        List<Integer> intValues = Arrays.stream(c).boxed().collect(Collectors.toList());
        intValues.replaceAll(i->i*2);
        intValues.sort((a,b)->a-b);
        intValues.removeIf(a->a>11);
        intValues.forEach(System.out::println);

    }

    private static void waysOfObtainingStream(int[] c) {
        //lamda expression can only access local variable which is final or effectively final
        //this keyword inside lamda expression refers to outer class
        //lamda expression can modify outer class instance variable

        Map<Integer,Integer> occuranceCount = Arrays.stream(c).boxed()
                .collect(Collectors.toMap(i-> i, i-> Integer.valueOf(1), (oldValue, newValue)->oldValue+newValue));

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
        //Stream.of(intArr).forEach(System.out::println);

        System.out.println("Obtain stream from values: ");
        Stream.of("one", "two", "three").forEach(System.out::println);

        System.out.println("Obtain stream from function generate: ");
        Stream.generate(()->Math.random()).limit(3).forEach(System.out::println);

        System.out.println("Obtain stream from function iterate: ");
        Stream.iterate(0, i->i+1).limit(7).forEach(System.out::println);

        System.out.println("Obtain stream from another stream : ");
        Arrays.stream(c).distinct().sorted().limit(3).forEach(System.out::println);
    }

    private static List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));
        return bookList;
    }



    private static void sortAsPerOccurance(int[] c) {

        Map<Integer,Integer> occuranceCount = Arrays.stream(c).boxed()
                .collect(Collectors.toMap(i-> i, i-> Integer.valueOf(1), (oldValue, newValue)->oldValue+newValue));

        List<Map.Entry<Integer,Integer>> entrylist = new ArrayList<>(occuranceCount.entrySet());

        Collections.sort(entrylist, (a, b)->{
            if (a.getValue() > b.getValue())
                return -1;
            else if (a.getValue() < b.getValue())
                return 1;
            else
            {
                if (a.getKey()>b.getKey())
                    return -1;
                else if (a.getKey()<b.getKey())
                    return 1;
                else
                    return 0;
            }
        });

        for (Map.Entry e : entrylist){
            System.out.println("Key: "+e.getKey() +" Value: "+e.getValue());
        }
    }

}
