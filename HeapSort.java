/*Cody Koger 2020.06.24 
 * 
 * HOW TO USE:
 * 
 * HeapSort heapSortObject = new HeapSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = heapSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
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
public class HeapSort extends Sorts {

	public Integer[] list;
	
	public HeapSort(int[] arr) {
		super.ArrayOfInts = arr;
		list = new Integer[arr.length];
		for(int i = 0; i < ArrayOfInts.length; i++) 
			list[i] = ArrayOfInts[i];
	}
	
	
	
	public long[] sort() {
		startTimer();
		
		heapSort();
		
		endTimer();
		
		for(int i = 0; i < ArrayOfInts.length; i++) 
			ArrayOfInts[i] = list[i].intValue();
		return getCompsSwapTimeArr();
	}

	public <E extends Comparable<E>> void heapSort() {
		Heap<Integer> heap = new Heap<>(list); 
		
		for(int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		for(int i = list.length-1; i>=0; i--)
			list[i] = heap.remove();
	}
	
	class Heap<E extends Comparable<E>>{
		
		private java.util.ArrayList<E> heapList = new java.util.ArrayList<>();
		
		public Heap() {
		}
		
		public Heap(E[] objects) {
			for(int i = 0; i < objects.length; i++)
				add(objects[i]);
		}
		
		
		public void add(E newObject) {
			heapList.add(newObject);
			int currentIndex = heapList.size()-1;
			
			while(currentIndex >0) {
				int parentIndex = (currentIndex - 1)/2;
				compareAdd();
				
				if(heapList.get(currentIndex).compareTo(heapList.get(parentIndex)) >0) {
					swapAdd();
					E temp = heapList.get(currentIndex);
					heapList.set(currentIndex, heapList.get(parentIndex));
					heapList.set(parentIndex, temp);
				}
				else break;
			
				
				currentIndex = parentIndex;
			}
		}
		
		public E remove() {
			if(heapList.size() == 0) return null;
			
			E removedObject = heapList.get(0);
			
			heapList.set(0, heapList.get(heapList.size() - 1));
			heapList.remove(heapList.size() -1);
			
			int currentIndex = 0;
			
			while(currentIndex < heapList.size()) {
				int leftChildIndex = 2* currentIndex + 1;
				int rightChildIndex = 2* currentIndex + 2;
				
				
				if(leftChildIndex >= heapList.size()) break;
				
				int maxIndex = leftChildIndex;
				if(rightChildIndex < heapList.size()) {
					compareAdd();
					if(heapList.get(maxIndex).compareTo(heapList.get(rightChildIndex)) < 0) {
						maxIndex = rightChildIndex;
					}
				}
				
				compareAdd();
				if(heapList.get(currentIndex).compareTo(heapList.get(maxIndex)) < 0) {
					swapAdd();
					E Temp = heapList.get(maxIndex);
					heapList.set(maxIndex, heapList.get(currentIndex));
					heapList.set(currentIndex, Temp);
					currentIndex = maxIndex;
				}
				else break;
			}
			
			return removedObject;
		}
		
		public int getSize() {
			return heapList.size();
		}
		
		
	}

}

