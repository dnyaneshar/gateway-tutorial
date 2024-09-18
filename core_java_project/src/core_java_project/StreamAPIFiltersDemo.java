package core_java_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class StreamAPIFiltersDemo {

	public static void main(String[] args) {
		
		
		
		/*
		 * we need to remove the email String from 
		 * email1 list, by checking the email String in email2
		 * 
		 * that means if abc@gmail.com is available in the email2 list and it is 
		 * available in the email2 as well then remove it from the 
		 * email1 list then remove it without creating new object.
		 */
		List<String> email1 = new ArrayList<>();
		
		email1.add("a@gmail.com");
		email1.add("b@gmail.com");
		email1.add("c@gmail.com");
		email1.add("d@gmail.com");
		
		
		List<String> email2 = new ArrayList<>();
		
		email2.add("a@gmail.com");
		email2.add("b@gmail.com");
		
		email1.removeIf(new Predicate<String>() {
			public boolean test(String t) {
				return email2.contains(t);
				
			};
		});
		
		System.out.println("email1 list : " + email1);
		System.out.println("email2 list :"+email2);
		
		/*
		 * Print the word that are starts with number i.e 2two - print it.
		 * 
		 */
		
		List<String> words = Arrays.asList("One", "2wo", "Three","4Four");
		words.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				
				return Pattern.compile("^[0-9].*")
			      .matcher(t)
			      .matches();
			}
		});
		
		System.out.println("words starts with number : " + words);
		
		/*
		 * what are the spring component ?
		 */
		
		
		
		/*
		 * create rest end point that will give student and exam information
		 * 
		 */
		
		
		
		
	}
}
