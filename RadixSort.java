/*Cody Koger 2020.06.25
 * HOW TO USE:
 * 
 * RadixSort radixSortObject = new RadixSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = radixSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
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



import java.util.Arrays;

public class RadixSort extends Sorts {
	
	public RadixSort(int[] a) {
		super.ArrayOfInts = a;
	}
	
	
	
	@Override
	public long[] sort() {
		startTimer();
		
		radixSort();
		
		endTimer();
		return getCompsSwapTimeArr();
	}
	
	public void radixSort() {
		int max = getMax();
		for(int i = 1; max/i >0; i*=10) {
			countSort(i);
		}
	}
	
	public int getMax() {
		int m = ArrayOfInts[0];
		for(int i = 1; i< ArrayOfInts.length; i++) {
			compareAdd();
			if(ArrayOfInts[i]>m) {
				m = ArrayOfInts[i];
				swapAdd();
			}
		}
		return m;
	}
	
	
	public void countSort(int r) {
		int[] out = new int[ArrayOfInts.length];
		
		int i;
		int[] count = new int[10];
		Arrays.fill(count, 0);
		for(i=0; i<ArrayOfInts.length; i++)
			count[(ArrayOfInts[i]/r)%10]++;
		
		for(i=1; i<10; i++)
			count[i] += count[i-1];
		
		for(i = ArrayOfInts.length -1; i>=0; i--) {
			out[count[(ArrayOfInts[i]/r)%10]-1] = ArrayOfInts[i];
			count[(ArrayOfInts[i]/r)%10]--;
			swapAdd();
		}
		
		for(i = 0; i< ArrayOfInts.length; i++)
			ArrayOfInts[i] = out[i];
	}

}
