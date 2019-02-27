package ui;

import model.Searching;

public class TenThreadsMain {
	public static void main(String[] args) {
		long[] array = generateRandomArray(100000000, 1000);
		
		long initTime = System.currentTimeMillis();
		
		Searching sch1 = new Searching(array, 5, 0, 10000000);
		Searching sch2 = new Searching(array, 5, 10000000, 20000000);
		Searching sch3 = new Searching(array, 5, 20000000, 30000000);
		Searching sch4 = new Searching(array, 5, 30000000, 40000000);
		Searching sch5 = new Searching(array, 5, 40000000, 50000000);
		Searching sch6 = new Searching(array, 5, 50000000, 60000000);
		Searching sch7 = new Searching(array, 5, 60000000, 70000000);
		Searching sch8 = new Searching(array, 5, 70000000, 80000000);
		Searching sch9 = new Searching(array, 5, 80000000, 90000000);
		Searching sch10 = new Searching(array, 5, 90000000, 100000000);
		
		int output  = sch1.countNumbers();
		output += sch2.countNumbers();
		output += sch3.countNumbers();
		output += sch4.countNumbers();
		output += sch5.countNumbers();
		output += sch6.countNumbers();
		output += sch7.countNumbers();
		output += sch8.countNumbers();
		output += sch9.countNumbers();
		output += sch10.countNumbers();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("5 is "+output+" times in the random array");
		System.out.println("Duration with 5 thread: "+(endTime-initTime));
	}
	
	public static long[] generateRandomArray(int size, int max) {
		long[] randomArray = new long[size];
		
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = (long)(Math.random()*max);
		}
		
		return randomArray;
	}
}
