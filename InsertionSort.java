/*Cody Koger 2020.06.23 
 * An Abstract Java class describing the methods to call all sort type subclasses
 * 
 * HOW TO USE:
 * 
 * InsertionSort insertionSortObject = new InsertionSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = insertionSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
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


public class InsertionSort extends Sorts {

	
//	Constructor Method requires Array of Integers. Call <X>.sort() after constructing to return an Array of Longs that give you, in order, [ Comparisons, Swaps, Time in microseconds]
	
	public InsertionSort(int[] arr) {
		super.ArrayOfInts = arr;
	}
	
	@Override
	public long[] sort() {
		startTimer();
		
		inserSort();
		
		endTimer();
		return getCompsSwapTimeArr();
	}


	private void inserSort() {
		
		for(int i = 1; i < super.ArrayOfInts.length; i++) {
			int currentElement = ArrayOfInts[i], k;
			
			for( k= i-1; k>=0 && ArrayOfInts[k] > currentElement; k-- ) {
				compareAdd();
				swapAdd();
				ArrayOfInts[k + 1] = ArrayOfInts[k];
			}
			
			swapAdd();
			ArrayOfInts[k + 1] = currentElement;
						
		}
		
	}

}