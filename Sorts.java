/*Cody Koger 2020.06.23 
 * An Abstract Java class describing the methods to call all sort type subclasses
 * 
 * HOW TO USE:
 * 
 * pass the array to the specific constructor using 'ArrayName'.clone() to get a deep copy of the main array
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = 'CostructedSort'.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
 * 
 * 
 * to compare the sorts, use the returned values from each 'NewArray' to determine the best sort
 * recommended to weight time more
 * 
 * NOTE ON TIME:
 * the time of these sorts is using the more accurate CPUTime when available. CPU Time describes time actually spent by this application
 * Noisy Time, or wall clock time, will be used when CPU Time is not availble
 *  
*/

import java.lang.management.*;

public abstract class Sorts {

	private long[] CompsSwapTimeArr = new long[3];
		
	protected int[] ArrayOfInts;
	
	private long comparisons = 0;
	private long swaps = 0;
	private long elapsedTimeMicroSecs = 0;
	private long initTimeNS, finalTimeNS;
	private boolean noiseyTime = false;
	
//	Methods to time the different sorts. Should provide a more accurate estimate when available
	
	private static long noiseyTimeNS() {
		return System.nanoTime();
	}
	
	private static long goodTimeNS(ThreadMXBean timeBean) {
		return timeBean.getCurrentThreadCpuTime();
	}
	
	protected void startTimer() {
		ThreadMXBean timeBean = ManagementFactory.getThreadMXBean();
		noiseyTime = !timeBean.isCurrentThreadCpuTimeSupported();
		initTimeNS = noiseyTime ? noiseyTimeNS() : goodTimeNS(timeBean);
	}
	
	protected void endTimer() {
		finalTimeNS = noiseyTime ? noiseyTimeNS() : goodTimeNS(ManagementFactory.getThreadMXBean());
	}
	


	public long getElapsedTimeMicroSecs() {
		elapsedTimeMicroSecs = (finalTimeNS -initTimeNS)/1000;
		return elapsedTimeMicroSecs;
	}
	
	
//	Standard Methods for inter-class interactions
	Sorts() {}
	public Sorts(int[] arr) {ArrayOfInts = arr;}
	
	public abstract long[] sort();

	public long[] getCompsSwapTimeArr() {
		
		CompsSwapTimeArr[0] = getComparisons();
		CompsSwapTimeArr[1] = getSwaps();
		CompsSwapTimeArr[2] = getElapsedTimeMicroSecs();
		
		return CompsSwapTimeArr;
	}

	public long getComparisons() {
		return comparisons;
	}
	
	public long getSwaps() {
		return swaps;
	}
	
	public int[] getArrayOfInts() {
		return ArrayOfInts;
	}

	public long getInitTimeNS() {
		return initTimeNS;
	}

	public long getFinalTimeNS() {
		return finalTimeNS;
	}
	
	
	protected void compareAdd() {
		comparisons++;
	}
	
	protected void swapAdd() {
		swaps++;
	}
}
