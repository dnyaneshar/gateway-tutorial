package core_java_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;

import com.configserver2.ConfigServer2Application;

public class WordStartWithNumber {
	
	class Student{
		 String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		 
		 
	}
	
	public static void main(String[] args) {
		
		List<Wheather> slist= new ArrayList<>();
		slist.add(new Wheather(12.0));
		slist.add(new Wheather(10.00));
		slist.stream().map(Wheather::getTemp).sorted().forEach(System.out::println);
		
		
	}

}
