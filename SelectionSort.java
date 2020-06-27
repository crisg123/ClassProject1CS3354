/*Cody Koger 2020.06.24 
 * An Abstract Java class describing the methods to call all sort type subclasses
 * 
 * HOW TO USE:
 * 
 * SelectionSort selectionSortObject = new SelectionSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = selectionSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
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
public class SelectionSort extends Sorts {

//	Constructor Method requires Array of Integers. Call <X>.sort() after constructing to return an Array of Longs that give you, in order, [ Comparisons, Swaps, Time in microseconds]
	
	public SelectionSort(int[] arr) {
		super.ArrayOfInts = arr;
	}
	
	@Override
	public long[] sort() {
		startTimer();
		
		selSort();
		
		endTimer();
		return getCompsSwapTimeArr();
	}

	public void selSort() {
		
//		System.out.println("sel sort"); dirty debug
		
		for(int i = 0; i< super.ArrayOfInts.length - 1; i++) {
			
			int currentMin = ArrayOfInts[i];
			int currentMinIndex = i;
			
			for (int j = i + 1; j < ArrayOfInts.length; j++) {
				compareAdd();
				if(currentMin > ArrayOfInts[j]) {
					currentMin = ArrayOfInts[j];
					currentMinIndex = j;
					swapAdd();
				}
			}
			
			if (currentMinIndex != i) {
				ArrayOfInts[currentMinIndex] = ArrayOfInts[i];
				ArrayOfInts[i] = currentMin;
			}
			
		}
	}

}
