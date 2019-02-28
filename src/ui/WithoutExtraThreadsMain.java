package ui;

import java.util.LinkedList;
import java.util.List;

import model.Searching;

public class WithoutExtraThreadsMain {
	public static void main(String[] args) {
		System.out.println("Program started.");
		System.out.println("Generating random integer list...");
		List<Integer> intList = generateRandomList(1000000, 1000);
		System.out.println("Random integer list generated.");
		
		System.out.println("Counting numbers...");
		
		long initTime = System.currentTimeMillis();
		
		Searching sch = new Searching(intList, 5, 0, intList.size());
		
		sch.countNumbers();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Numbers counted.");
		int output = sch.getTotal();
		System.out.println("5 is "+output+" times in the random array");
		System.out.println("Duration with 1 thread: "+(endTime-initTime));
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
