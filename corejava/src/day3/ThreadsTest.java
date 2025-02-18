package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ThreadsTest {
	
//	public Map<Month,List<Car>> groupCarsByMonth()	{
//		
//	}

	@Test
	void test() {
		Runnable r = new Runnable() {
			public void run() {
					for (int i = 0; ; i++) {
						System.out.println(Thread.currentThread() + " " + i);
				}
			}
		};
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		Thread t = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread()+" "+i);
				}
			};
		};
		t.start();
//		while(true) {}
	}

}
