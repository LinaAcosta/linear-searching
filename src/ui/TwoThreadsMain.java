package ui;

import java.util.LinkedList;
import java.util.List;

import model.Searching;
import thread.SearchingThread;

public class TwoThreadsMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program started.");
		System.out.println("Generating random integer list...");
		List<Integer> intList = generateRandomList(100000, 1000);
		System.out.println("Random integer list generated.");
		
		Searching sch1 = new Searching(intList, 5, 0, 50000);
		Searching sch2 = new Searching(intList, 5, 50000, 100000);
		
		SearchingThread st1 = new SearchingThread(sch1);
		SearchingThread st2 = new SearchingThread(sch2);
		
		System.out.println("Counting numbers...");
		
		long initTime = System.currentTimeMillis();
		
		st1.start();
		st2.start();
		
		st1.join();
		st2.join();
	
		long endTime = System.currentTimeMillis();
				
		int output  = sch1.getTotal();
		output += sch2.getTotal();
		
		System.out.println("Numbers counted.");
		System.out.println("5 is "+output+" times in the random array");
		System.out.println("Duration with 2 threads: "+(endTime-initTime));
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
