/*Cody Koger 2020.06.25
 * 
 * HOW TO USE:
 * 
 * MergeSort mergeSortObject = new MergeSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = mergeSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
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
public class MergeSort extends Sorts {

	public MergeSort(int[] arr) {
		super.ArrayOfInts = arr;
	}
	@Override
	public long[] sort() {
		startTimer();
		
		mergeSort(ArrayOfInts);
		
		endTimer();
		return getCompsSwapTimeArr();
	}

	
	public void mergeSort(int[] list) {
		if(list.length >1) {
			
			int[] firstHalf = new int[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			mergeSort(firstHalf);
			
			int[] secondHalf = new int[list.length - list.length/2];
			System.arraycopy(list, list.length/2, secondHalf, 0, list.length - list.length/2);
			mergeSort(secondHalf);
			
			merge(firstHalf, secondHalf, list);
		}
	}
	
	public void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0, current2 = 0, current3 = 0;
		
		while(current1 < list1.length && current2 < list2.length) {
			compareAdd();
			if(list1[current1] < list2[current2]) {
				swapAdd();
				temp[current3++] = list1[current1++];
			}
			else {
				swapAdd();
				temp[current3++] = list2[current2++];
			}
		}
		
		while (current1 < list1.length) {
			swapAdd();
			temp[current3++] = list1[current1++];
		}
		
		while (current2 < list2.length) {
			swapAdd();
			temp[current3++] = list2[current2++];
		}
	}
	
}
