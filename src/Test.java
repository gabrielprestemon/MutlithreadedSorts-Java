
public class Test {
	// fill the array with random integers, [0, range)
	public static void fillWithRandomInt(int[] arr, int range){
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * range);
		}
	}
	
	// return true if the array is in ascending order, false otherwise
	public static boolean isOrdered(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			// if a pair of indexes is out of order, return false
			if(arr[i] > arr[i + 1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		int size = 100;
		int range = 1000;
		int[] arr = new int[size];
		// fill the array with random numbers
		Test.fillWithRandomInt(arr, range);
		
		// sort the array using the standard single-threaded quicksort
		System.out.println("Sorting with quicksort (standard).");
		arr = Quicksort.sort(arr);
		
		// print whether or not the array is sorted
		if(Test.isOrdered(arr)){
			System.out.println("Sort successful.");
		}
		else{
			System.out.println("Sort unsuccessful.");
		}
	}
}
