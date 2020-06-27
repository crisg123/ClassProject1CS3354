//Cody Koger 2019.06.25
//Class used to test the sorting classes

public class SortsTester {

	public static void main(String[] args) {
		int x = 100000;
		long[] cst;
		int[] intsArr = generateList(x);
				
		int[] inSort = intsArr.clone();
		int[] selSort = intsArr.clone();
		int[] quiSort = intsArr.clone();
		int[] hepSort = intsArr.clone();
		int[] merSort = intsArr.clone();
		int[] bukSort = intsArr.clone();
		int[] radSort = intsArr.clone();
		
		
		//Insertion Sort class testing
		
		InsertionSort IS = new InsertionSort(inSort);
		cst = IS.sort();
		
//		System.out.println("Array cloning works: " + !Arrays.equals(IS.getArrayOfInts(), selSort));  check if .clone() works as it should
		
		
		System.out.println("List of " + x + " sorted?: " + isSorted(IS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");
		
		
		//Selection Sort class testing
		SelectionSort SS = new SelectionSort(selSort);
		cst = SS.sort();
		
		System.out.println("List of " + x + " sorted?: " + isSorted(SS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");
		
		
//		Quick Sort class testing
		QuickSort QS = new QuickSort(quiSort);
		cst = QS.sort();
		
		System.out.println("List of " + x + " sorted?: " + isSorted(QS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");
		
		
//		Heap Sort class testing
		HeapSort HS = new HeapSort(hepSort);
		cst = HS.sort();
		
		System.out.println("List of " + x + " sorted?: " + isSorted(HS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");
		
		
//		Merge Sort class testing
		MergeSort MS = new MergeSort(merSort);
		cst = MS.sort();
		
		System.out.println("List of " + x + " sorted?: " + isSorted(MS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");

		
//		Bucket Sort class testing
		BucketSort BS = new BucketSort(bukSort);
		cst = BS.sort();
		
		System.out.println("List of " + x + " sorted?: " + isSorted(BS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");
		
		
//		Radix Sort class testing
		RadixSort RS = new RadixSort(radSort);
		cst = RS.sort();
		
		System.out.println("List of " + x + " sorted?: " + isSorted(RS.getArrayOfInts()));
		
		System.out.println("Compares: " + cst[0] + "\nSwaps: " + cst[1] + "\nTime: " + cst[2] + " microseconds or ~" + ((double)cst[2]/1000000.0) + " seconds");
	}
	
	
	static int[] generateList(int n) {
		int[] a = new int[n];
		for(int i = 0; i< n; i++)
			a[i] = (int)(Math.random() *n*10);
		return a;
	}
	
	static boolean isSorted(int[] a) {
		for(int i = 0; i< a.length-1; i++)
			if(a[i+1] < a[i])
				return false;
		return true;
	}

}
