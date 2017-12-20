package ru.spbstu.parprog.lecture10;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class PoolsAndFutures {
	
	static ExecutorService service = Executors.newFixedThreadPool(10);
	
	
	private static class Fibonacci implements Callable<Long> {
		
		private long n;
		
		public Fibonacci(long n) {
			super();
			this.n = n;
		}

		@Override
		public Long call() throws Exception {
			
			long res = 1;
			
			if (n < 0) {
				throw new RuntimeException(new IllegalArgumentException("number cannot be negative"));
			}
			
			if (n < 2) {
				return 1L;
			}
			
			long prev = res; 
			long tmp;
			for (int i = 2; i <= n; i++) {
				tmp = res;
				res = res + prev;
				prev = tmp;
			}
			
			Thread.sleep(1000);
			return res;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Start");
		
		//submitRunnables();
		submitCallables();
		
		service.shutdown();
	}

	private static void submitCallables() throws InterruptedException, ExecutionException {
		
		List<Future<Long>> results = new LinkedList<>();
		long t = System.currentTimeMillis();
		System.out.println("Submitting tasks");
		for (int i = 0; i < 100; i++) {
			Fibonacci f = new Fibonacci(i);
			Future<Long> future = service.submit(f);
			results.add(future);
		}
		System.out.println("Done submitting " + (System.currentTimeMillis() - t));
		
//		Collections.reverse(results);
		while(!results.isEmpty()) {
			List<Future<Long>> completed = new LinkedList<>();
			for (Future<Long> r: results) {
				
				if (r.isDone()) {
					Long res = r.get();
					completed.add(r);
					System.out.println("I got some res: " + res);
				} else {
					System.out.println("future is still progressing");
				}
			}
			Thread.sleep(500);
			results.removeAll(completed);
			completed.clear();
		}
			
		
		
	}

	private static void submitRunnables() {
		for(int i = 0; i < 100; i++) {
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " " + new Date());
				}
			});
		}
	}

}
