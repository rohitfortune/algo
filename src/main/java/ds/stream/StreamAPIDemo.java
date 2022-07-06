package ds.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemo {
	public static void main(String[] args) {
		int[] c = { 1, 6, 2, 2, 1, 3, 6, 4, 4, 4 };

		List<Book> bookList = getBookList();
		// partitioningBy takes a predicate
		System.out.println(
				bookList.parallelStream().collect(Collectors.partitioningBy(b -> b.getReleaseYear() == 1954)) + "\n");
		// groupingBy takes Function
		System.out.println(bookList.stream().collect(Collectors.groupingBy(b -> b.getReleaseYear())) + "\n");

		System.out.println(bookList.stream().collect(Collectors.partitioningBy(b -> b.getReleaseYear() == 1954,
				Collectors.mapping(b -> b.getName(), Collectors.toList()))) + "\n");

		System.out.println(bookList.stream().collect(Collectors.groupingBy(b -> b.getReleaseYear(),
				Collectors.mapping(b -> b.getIsbn(), Collectors.toList()))));

		System.out.println(
				bookList.stream().collect(Collectors.groupingBy(b -> b.getReleaseYear(), Collectors.counting())));

		System.out.println("Obtain array from ArrayList using toArray: ");
		Book[] books = bookList.stream().filter(b -> b.getReleaseYear() == 1954).toArray(Book[]::new);
		Arrays.stream(books).forEach(b -> System.out.println(b.getIsbn() + " " + b.getReleaseYear()));

		System.out.println("Obtain Object array from ArrayList using toArray: ");
		Object[] bookObjs = bookList.stream().toArray();
		Arrays.stream(bookObjs)
				.forEach(b -> System.out.println(((Book) b).getIsbn() + " " + ((Book) b).getReleaseYear()));

		System.out.println("Obtain list of books grouped by published year");
		Map<Integer, List<Book>> map = bookList.stream()
				.collect(Collectors.groupingBy(b -> b.getReleaseYear(), Collectors.toList()));
		map.entrySet().stream()
				.forEach(e -> System.out.println(((Map.Entry) e).getKey() + " " + ((Map.Entry) e).getValue()));

		System.out.println("Obtain set of books published in 1954 ");
		Map<Integer, Set<Book>> map1 = bookList.stream()
				.collect(Collectors.groupingBy(b -> b.getReleaseYear(), Collectors.toSet()));
		map1.entrySet().stream()
				.forEach(e -> System.out.println(((Map.Entry) e).getKey() + " " + ((Map.Entry) e).getValue()));
		Set<Book> setOfBook = bookList.stream().filter(b -> b.getReleaseYear() == 1954)
				.collect(Collectors.toSet());
		System.out.println("sets of book in 1954 "+ setOfBook);

		System.out.println("Obtain collections of books published in 1954 ");
		ArrayList<Book> bookArrayList = bookList.stream().filter(b -> b.getReleaseYear() == 1955)
				.collect(Collectors.toCollection(ArrayList::new));
		bookArrayList.stream().forEach(System.out::println);

		System.out.println("Test all elements matches predicate ");
		Predicate<Book> p = b -> b.getReleaseYear() == 1954;
		System.out.println(bookList.stream().allMatch(p));

		System.out.println("Test whether any elements matches predicate ");
		System.out.println(bookList.stream().anyMatch(p));

		System.out.println("Test whether none elements matches predicate ");
		Predicate<Book> p1 = b -> b.getReleaseYear() == 1956;
		System.out.println(bookList.stream().noneMatch(p1));

		boolean boo = (8 & 1) == 0;
		System.out.println("testing odd or even by bitwise: " + boo);

		System.out.println(
				"Moddifying ArrayList using replaceAll, sort, removeIf method of List interface which accepts lambda");
		List<Integer> intValues = Arrays.stream(c).boxed().collect(Collectors.toList());
	 	intValues.replaceAll(i -> i * 2);
		intValues.sort((a, b) -> a - b);
		intValues.removeIf(a -> a > 11);
		intValues.forEach(System.out::println);

		System.out.println("Reading words from a file and printing counts: ");
		try {
			Map<String, Long> wordCountMap = Files.lines(Paths.get("D:\\abc.txt")).parallel().flatMap(line -> Stream.of(line.split(" ")))
					.collect(Collectors.groupingBy(s->s,Collectors.counting()));
			
			for(Map.Entry<String, Long> e : wordCountMap.entrySet()) {
				
				long vowelCountInWord = e.getKey().chars().filter(ch-> "aeiou".chars().anyMatch(v->v==ch)).count();
				System.out.println("Word: "+e.getKey()+"\t occurance: "+e.getValue()+" vowel count: "+ vowelCountInWord);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Book> getBookList() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
		bookList.add(new Book("The Two Towers", 1954, "0345339711"));
		bookList.add(new Book("The Return of the King", 1956, "0618129111"));
		bookList.add(new Book("The Return of the King", 1955, "0618129111"));
		return bookList;
	}

}
