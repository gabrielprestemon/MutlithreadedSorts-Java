
public class Quicksort {
	// array to be sorted
	private int[] a;
	// get the sorted array
	public int[] getArray(){return a;}
	
	// constructor will automatically run the multithreaded quicksort on the array
	public Quicksort(int[] arr){
		a = arr;
		// start the recursive sort
		QsortThread q = new QsortThread(0, a.length - 1);
	}
		
	
	// quicksort thread class
	private class QsortThread extends Thread{
		// start and end indexes for the thread's array partition
		private int L;
		private int R;
		
		// start the thread as soon as it's initialized
		public QsortThread(int l, int r){
			L = l;
			R = r;
			start();
		}
		
		public void start(){
			run();
		}
		
		public void run(){
			if(L < R){
				int p = partition();
				QsortThread LT = new QsortThread(L, p - 1);
				QsortThread LR = new QsortThread(p + 1, R);
			}
		}
		
		private int partition(){
			// save the pivot 
			int pivot = a[R];
			// index the pivot will be at after looping
			int p = L;
			// sort numbers to their proper side of the pivot
			for(int i = L; i < R; i++){
				// if the element is out of place, swap and increment pivot index
				if(a[i] <= pivot){
					int temp = a[i];
					a[i] = a[p];
					a[p++] = temp;
				}
			}
			// swap the pivot with the element at the pivot index
			int temp = a[p];
			a[p] = a[R];
			a[R] = temp;
			// index p is in its place. return it
			return p;
		}
	}
	
	
	// STATIC UNTHREADED QUICKSORT
	
	// static method sort will run a standard, unthreaded quicksort on the input
	public static int[] sort(int[] arr){
		qsort(arr, 0, arr.length - 1);
		return arr;
	}
	
	// the recursive method which will be called in static method sort
	private static void qsort(int[] arr, int L, int R){
		if(L < R){
			int p = partition(arr, L, R);
			qsort(arr, L, p - 1);
			qsort(arr, p + 1, R);
		}
	}
	
	// used in private static method qsort to partition the array
	private static int partition(int[] arr, int L, int R){
		// save the pivot 
		int pivot = arr[R];
		// index the pivot will be at after looping
		int p = L;
		// sort numbers to their proper side of the pivot
		for(int i = L; i < R; i++){
			// if the element is out of place, swap and increment pivot index
			if(arr[i] <= pivot){
				int temp = arr[i];
				arr[i] = arr[p];
				arr[p++] = temp;
			}
		}
		// swap the pivot with the element at the pivot index
		int temp = arr[p];
		arr[p] = arr[R];
		arr[R] = temp;
		// index p is in its place. return it
		return p;
	}
}
