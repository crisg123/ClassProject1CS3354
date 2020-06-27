/*Cody Koger 2020.06.24 
 * An Abstract Java class describing the methods to call all sort type subclasses
 * 
 * HOW TO USE:
 * 
 * QuickSort quickSortObject = new QuickSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = quickSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
 * 
 * 
 * to compare the sorts, use the returned values from each 'NewArray' to determine the best sort
 * recommended to weight time more
 * 
 * NOTE ON TIME:
 * the time of these sorts is using the more accurate CPUTime when available. CPU Time describes time actually spent by this application
 * Noisy Time, or wall clock time, will be used when CPU Time is not available
 *  
*/
public class QuickSort extends Sorts {

//	Constructor Method requires Array of Integers. Call <X>.sort() after constructing to return an Array of Longs that give you, in order, [ Comparisons, Swaps, Time in microseconds]
	
	public QuickSort(int[] arr) {
		super.ArrayOfInts = arr;
	}
	
	
	@Override
	public long[] sort() {
		startTimer();
		
		quikSort(0, ArrayOfInts.length-1);
		
		endTimer();
		return getCompsSwapTimeArr();
	}

	
	
	public void quikSort(int first, int last) {
		if(last > first) {
			int pivotIndex = partition(first, last);
			quikSort(first, pivotIndex -1);
			quikSort(pivotIndex +1, last);
		}
	}
	
	
	private int partition(int first, int last) {
		int pivot = ArrayOfInts[first];
		int low = first + 1, high = last;
		
		while(high > low) {
			
			while(low <= high && ArrayOfInts[low] <= pivot) {
				low++;
				compareAdd();
			}
			
			while(low <= high && ArrayOfInts[high] > pivot) {
				high--;
				compareAdd();
			}
			
			if(high > low) {
				swapAdd();
				int temp = ArrayOfInts[high];
				ArrayOfInts[high] = ArrayOfInts[low];
				ArrayOfInts[low] = temp;
			}
			
		}
		
		while(high > first && ArrayOfInts[high] >= pivot) {
			high--;
			compareAdd();
		}
		
		if(pivot > ArrayOfInts[high]) {
			swapAdd();
			ArrayOfInts[first] = ArrayOfInts[high];
			ArrayOfInts[high] = pivot;
			return high;
		}
		else
			return first;
		
		
	}
	
}
