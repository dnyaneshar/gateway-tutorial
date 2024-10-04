package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
	
	public static void main(String[] args) {
		
		String s1 = "abac";
		
		//List<Character> charList = new ArrayList<>();
		
		Map<Character, Integer> map = new HashMap<>();
		
		char[] chars = s1.toCharArray();
		for(int i = 0 ; i < chars.length; i++) {
			if(map.get(chars[i]) == null) {
				map.put(chars[i], 1);
			} else {
				map.put(chars[i], map.get(chars[i]) + 1);
			}
		}
		
		System.out.println(map);
		
		for( Entry<Character, Integer> entry : map.entrySet()) {
			
			if (entry.getValue() == 1 ) {
				//System.out.println("First non repeated chars is : - " + entry.getKey());
				break;
			}
		}
		
		List<Character> list = map.entrySet().stream().filter(e -> e.getValue() == 1)
		.map(e -> e.getKey()).collect(Collectors.toList());
		
		//System.out.println("non repeated char : - " + list.get(0));
		
		int count = 0;
		// find second non repeated char
		Character ch = map.entrySet().stream()
				.filter(e -> e.getValue() == 1 )
				.map(e -> e.getKey()).findFirst().get();
		
		//System.out.println("ch : " +ch);
		
		
		Entry<Character, Integer> entry =  map.entrySet().stream()
				.filter(e->e.getValue() ==1 ).map(e->e).findFirst().get();
		
		//System.out.println("first non repeated char is :- "+ entry.getKey());
		
		Entry<Character, Long> ee =  s1.chars().mapToObj(c -> Character.valueOf( (char)c))
		.collect(Collectors.groupingBy(Function.identity(), 
				LinkedHashMap::new, Collectors.counting())).entrySet()
		.stream().filter(l -> l.getValue() == 1)
		.skip(1)
		.findFirst().get();
		
		
		
		//System.out.println(ee);
		System.out.println("second non repeated char is :- "+ ee.getKey());
		
//		Stream.iterate(new long[] { 1, 1 }, p -> new long[] { p[1], p[0] + p[1] })
//	      .limit(5)
//	      .forEach(p -> System.out.println(p[0]));
		
		Stream.iterate(new long [] {1,1}, p -> new long[] {p[1], p[0 ] + p[1]})
		.limit(10)
		.forEach(p -> System.out.println(p[0]));
		
		// remove duplicate character from the string 
		
//		Arrays.asList(s1.split(""))
//				.stream().distinct().collect(Collectors.toList())
//				.forEach(System.out::println);;
				

		//remove duplicates using hashset
		s1.chars().mapToObj(item -> (char)item).collect(Collectors.toSet())
		.forEach(System.out::println);
		
		Entry<Character, Long> ee1 = s1.chars().mapToObj(item -> (char) item ).collect(Collectors.groupingBy(
				Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream().filter(e -> e.getValue() == 1)
		.findFirst().get();
		
		System.out.println(ee1.getKey());
		
		//remove duplicates characters using set
//		Set<Character> set = s1.chars()
//				.mapToObj(item -> (char) item).collect(Collectors.toSet());
//		set.forEach(System.out::println);
		
		//find second highest number
		int i = Arrays.asList(1, 20, 3, 4,19)
		.stream().sorted(Collections.reverseOrder())
		.skip(1).findFirst().get();
		System.out.println("second highest number :- " + i);
		
		//find average number
		Double avg = Arrays.asList(1, 20, 3, 4,19).stream().collect(Collectors.averagingInt(a->a));
		
		System.out.println("average number :-" + avg);
		
		List<String> asList = Arrays.asList(s1.split(""));
		
		Map<String, String> stringMap = asList.stream().distinct().collect(Collectors.toMap(Function.identity(), item -> item));
		
		
		//find object which has key as "a"
		stringMap.entrySet().stream().filter(e -> e.getKey().equals("a")).findFirst().get();
		stringMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() +" " + e.getValue()));
		
		
	}

}
