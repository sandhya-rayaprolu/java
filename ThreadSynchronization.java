public class ThreadSynchronization extends Thread {
	private int start;
	private Object lock;
	private static boolean isEvenFirst = true;

	public ThreadSynchronization(int start, String threadName, Object lock) {
		super(threadName);
		this.start = start;
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			if ((isEvenFirst) && (start == 2)) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else{
				isEvenFirst = false;
			}
			for (int i = start; i <= 100; i += 2) {
				try {
					lock.notify();
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName() + ": The number is '" + i	+ "' ");
			}
			lock.notify();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object lock = new Object();
		Thread oddThread = new ThreadSynchronization(1, "Thread 1", lock);
		oddThread.start();
		Thread evenThread = new ThreadSynchronization(2, "Thread 2", lock);
		evenThread.start();
	}
}
