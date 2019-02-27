package model;

public class Searching {
	private long[] numbers;
	private long num;
	private int start;
	private int end;
	
	public Searching(long[] nums, long n, int s, int e) {
		numbers = nums;
		num = n;
		start = s;
		end = e;
	}
	
	public int countNumbers() {
		int total = 0;
		for (int i = start; i < end; i++) {
			if(numbers[i]==num) {
				total++;
			}
		}
		return total;
	}
}
