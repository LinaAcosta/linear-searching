package ui;

import model.Searching;

public class WithoutExtraThreadsMain {
	public static void main(String[] args) {
		long[] array = generateRandomArray(100000000, 1000);
		
		long initTime = System.currentTimeMillis();
		
		Searching sch = new Searching(array, 5, 0, array.length);
		
		int output = sch.countNumbers();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("5 is "+output+" times in the random array");
		System.out.println("Duration with 1 thread: "+(endTime-initTime));
	}
	
	public static long[] generateRandomArray(int size, int max) {
		long[] randomArray = new long[size];
		
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = (long)(Math.random()*max);
		}
		
		return randomArray;
	}
}
