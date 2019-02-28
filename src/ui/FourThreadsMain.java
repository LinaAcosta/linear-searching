package ui;

import java.util.LinkedList;
import java.util.List;

import model.Searching;
import thread.SearchingThread;

public class FourThreadsMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program started.");
		System.out.println("Generating random integer list...");
		List<Integer> intList = generateRandomList(100000, 1000);
		System.out.println("Random integer list generated.");
		
		Searching sch1 = new Searching(intList, 5, 0, 25000);
		Searching sch2 = new Searching(intList, 5, 25000, 50000);
		Searching sch3 = new Searching(intList, 5, 50000, 75000);
		Searching sch4 = new Searching(intList, 5, 75000, 100000);
		
		SearchingThread st1 = new SearchingThread(sch1);
		SearchingThread st2 = new SearchingThread(sch2);
		SearchingThread st3 = new SearchingThread(sch3);
		SearchingThread st4 = new SearchingThread(sch4);
		
		System.out.println("Counting numbers...");
		
		long initTime = System.currentTimeMillis();
		
		st1.start();
		st2.start();
		st3.start();
		st4.start();
		
		st1.join();
		st2.join();
		st3.join();
		st4.join();
		
		long endTime = System.currentTimeMillis();
				
		int output  = sch1.getTotal();
		output += sch2.getTotal();
		output += sch3.getTotal();
		output += sch4.getTotal();
		
		System.out.println("Numbers counted.");
		System.out.println("5 is "+output+" times in the random array");
		System.out.println("Duration with 4 threads: "+(endTime-initTime));
	}
	
	public static List<Integer> generateRandomList(int size, int max) {
		List<Integer> randomArray = new LinkedList<Integer>();
		
		for (int i = 0; i < size; i++) {
			int randomNumber = (int)(Math.random()*max);
			randomArray.add(randomNumber);
		}
		
		return randomArray;
	}
}
