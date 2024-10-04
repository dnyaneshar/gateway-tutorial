package core_java_project;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class copyOnArrayListThreadDemo implements Runnable{

	CopyOnWriteArrayList<String> cl = new CopyOnWriteArrayList<>();
	
	@Override
	public void run() {
		
		ArrayList<Object> ar = new ArrayList<>();
		ar.add(1);
		ar.add("sfsfs");
		
		Object[] obj = new Object[10];
		obj[0] = 1;
		obj[1] = "sfsf";
		
		cl.add("D");
		
	}
	
	
	
}
