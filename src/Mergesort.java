
public class Mergesort {

	
	// STATIC UNTHREADED MERGESORT
	
	public static void sort(int[] arr){
		split(arr, 0, arr.length);
	}
	
	// split the array into sub-arrays using indexes
	// s is start index, e is end (size)
	private static void split(int[] arr, int s, int e){
		// only split arrays that are more than one element
		if(s < e - 1){
			// find the middle index
			int m = (e + s) / 2;
			split(arr, s, m);
			split(arr, m, e);
			merge(arr, s, m, e);
		}
	}
	
	// merge the two sub-arrays split by the middle index
	// s is start index, m is end of first half, start of second half, e is end of second half (size)
	private static void merge(int[] arr, int s, int m, int e){
		int L = s, R = m;
		int[] a = new int[e - s];
		
		// iterate through the list
		for(int i = 0; i < a.length; i++){
			// if there are elements in the left partition
			// and
			// (the left element is less than the right element
			//   or there are no elements in the right partition)
			if(L < m && (R >= e || arr[L] <= arr[R])){
				// left element moves up
				a[i] = arr[L++];
			}
			// else there are no elements left in the left partition
			//   or the right element is greater than the left
			else{
				a[i] = arr[R++];
			}
		}
		
		// copy the merged partitions up to the main array
		for(int i = 0; i < a.length; i++){
			arr[i + s] = a[i];
		}
	}
}
