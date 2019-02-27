package thread;

import model.Searching;

public class SearchingThread extends Thread{
	private Searching sch;
	
	public SearchingThread(Searching s) {
		sch = s;
	}
	
	@Override
	public void run() {
		sch.countNumbers();
	}
}
