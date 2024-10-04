package core_java_project;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class QueueDemo {

	public static void main(String[] args) {
		
		Queue<String> queue = new PriorityQueue<>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		
		
		//queue.stream().forEach(System.out::println);
		
		Deque<String> deque = new ArrayDeque<>();
		deque.add("A");
		deque.add("B");
		deque.add("C");
		
		deque.addFirst("F");;
		deque.add("A");
		deque.addLast("L");
		
		deque.removeFirst();
		
		//deque.stream().forEach(System.out::println);
		
		Set<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.add("6");
		set.add("6skngk");
		set.add("abc");
		set.add("bcr");
		//set.stream().forEach(System.out::println);
		
		
		Set<String> ll = new LinkedHashSet<>();
		ll.add("1");
		ll.add("2");
		ll.add("3");
		ll.add("4");
		ll.add("5");
		ll.add("6");
		ll.add("6skngk");
		ll.add("abc");
		ll.add("bcr");
		//ll.stream().forEach(System.out::println);
		
		set = new TreeSet<>();
		set.add("2");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.add("1");
		set.add("6skngk");
		set.add("abc");
		set.add("bcr");
		//set.stream().forEach(System.out::println);
		
		CopyOnWriteArrayList<String> cl = new CopyOnWriteArrayList<>();
		cl.add("ad");
		cl.add("ffsfs");
		cl.add("things");
		
		Iterator<String> itr = cl.iterator();
		 while (itr.hasNext()) {
			 String s = itr.next();
			cl.add(s);
			 
		 }
		 
		 cl.stream().forEach(System.out::println);
		
	}
}
