package core_java_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordStartWithNumber {
	
	public static void main(String[] args) {
		
		String word = "3number";
		
		if(word.matches("^[0-9].*")) {
			System.out.println("word start with number");
		} else
		{
			System.out.println("word did not start with number");
		}
		
		List<String> list = Arrays.asList(word, "abcd", "5kyc");
		
		List<String> testList = list.stream().filter( new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return Pattern.matches("^[0-9].*", t);
			}
		}).collect(Collectors.toList());
		
		System.out.println(testList);
	}

}
