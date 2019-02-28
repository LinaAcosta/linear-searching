package model;

import java.util.List;

public class Searching {
	private List<Integer> numbers;
	private long num;
	private int start;
	private int end;
	private int total;
	
	public Searching(List<Integer> nums, long n, int s, int e) {
		numbers = nums;
		num = n;
		start = s;
		end = e;
	}
	
	public void countNumbers() {
		total = 0;
		for (int i = start; i < end; i++) {
			if(numbers.get(i)==num) {
				total++;
			}
		}
	}
	
	public int getTotal() {
		return total;
	}
}
