package core_java_project;

import java.util.ArrayList;
import java.util.List;

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
