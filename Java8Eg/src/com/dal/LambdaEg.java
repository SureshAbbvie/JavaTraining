package com.dal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class LambdaEg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Java 7 - syntax;
//Runnable r = new MyTaskThread();
//Thread thread = new Thread(r);
//thread.start();

//Java 7 -- s 3
//Runnable r = new Runnable() {
//	@Override
//	public void run() {
//		Task task = new Task();
//		task.connect();
//	}
//};
//Thread t1= new Thread(r);
//t1.start();
		//Java 8 -- sntax -1
		/*Runnable r = ()->{
			Task task = new Task();
			task.connect();
		};
		Thread t1= new Thread(r);
		t1.start();
		*/
		/*Thread th1 = new Thread(() ->{
			Task task = new Task();
			task.connect();
		});
		th1.start();
		*/
		/*new Thread(()->{
			new Task().connect();
		}).start();
		*/
		/*new Thread (new Task()::connect).start();*/
		
		
		 User u1 = new User(11,"Nilima","nilima@gmail.com"); User u2 = new
		 User(12,"Praveen","prav@gmail.com"); User u3 = new
		 User(13,"Aarika","arika@gmail.com");
		 List<User> li = new ArrayList<User>();
		 li.add(u1); li.add(u2); li.add(u3);
		 System.out.println("User List :" + li);
		 
		 /*Iterator<User> i = li.iterator(); 
		 while (i.hasNext()) {
		 System.out.println(i.next());
		 
		 }	
		 */	
		 //li.forEach(lis->System.out.println(lis));
		 li.forEach(System.out::println);
	} // main class close
}
