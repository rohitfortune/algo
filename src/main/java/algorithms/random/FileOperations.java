package algorithms.random;

import java.io.File;
//Java Program illustrating that we can read a file in 
//a human readable format using FileReader 
// Accessing FileReader, FileWriter, IOException 
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Reading words from a file and printing word occurance and no vowels of in each word: ");
		try {
			Map<String, Long> wordCountMap = Files.lines(Paths.get("D:\\abc.txt")).parallel()
					.flatMap(line -> Stream.of(line.split(" ")))
					.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

			for (Map.Entry<String, Long> e : wordCountMap.entrySet()) {

				long vowelCountInWord = e.getKey().chars().filter(ch -> "aeiou".chars().anyMatch(v -> v == ch)).count();
				System.out.println(
						"Word: " + e.getKey() + "\t occurance: " + e.getValue() + " vowel count: " + vowelCountInWord);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading all files from a given director and 
		List<Path> paths = Files.list(Paths.get(".")).filter(Files::isRegularFile).collect(Collectors.toList());
		
		Arrays.stream(new File(".").listFiles(file -> file.isFile()));

		Files.newDirectoryStream(Paths.get("."), file -> Files.isRegularFile(file)).forEach(path -> {
			try {
				long l = Files.lines(path).count();
				System.out.println("Total lines in " + path.getFileName() + ": " + l);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		FileReader sourceStream = null;
		try {
			sourceStream = new FileReader("D:\\test.txt");

			// Reading sourcefile and writing content to
			// target file character by character.
			int temp;
			while ((temp = sourceStream.read()) != -1)
				System.out.println((char) temp);
		} finally {
			// Closing stream as no longer in use
			if (sourceStream != null)
				sourceStream.close();
		}
	}
}
