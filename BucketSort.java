/*Cody Koger 2020.06.25
 * 
 * HOW TO USE:
 * 
 * BucketSort bucketSortObject = new BucketSort('OriginalArray'.clone());
 * then prepare a new array of longs with 3 spaces/ 3 length       'NewArray'
 * set 'NewArray' = bucketSortObject.sort(); to get and array with [ # of comparisons, # of swaps, time in microseconds]
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

public class BucketSort extends Sorts {

	public BucketSort(int[] a) {
		super.ArrayOfInts = a;
	}
	
	
	
	@Override
	public long[] sort() {
		startTimer();
		
		bucketSort();
		
		endTimer();
		return getCompsSwapTimeArr();
	}
	
	public void bucketSort() {
		SimpleQ[] qArr = new SimpleQ[1000000 + 1];
		
		for(int i = 0; i< qArr.length; i++)
			qArr[i] = new SimpleQ();
		
		for(int i = 0; i< ArrayOfInts.length; i++) {
			swapAdd();
			compareAdd();
			qArr[ArrayOfInts[i]].enQ(ArrayOfInts[i]);
		}
			
		int j = 0;
		for(int i = 0; i< qArr.length; i++) {
			while(qArr[i].hasHead()) {
				swapAdd();
				ArrayOfInts[j++] = qArr[i].deQ();
			}
		}
	}
	
	class SimpleQ{
		
		QBlock front, tail;
		
		SimpleQ(){
			front = null;
			tail = null;
		}
		
		void enQ(int n) {
			if (front == null) {
				front = new QBlock(n);
				tail = front;
			}
			else if( front ==  tail) {
				tail = new QBlock(n);
				front.addNext(tail);
			}
			else {
				tail.addNext(new QBlock(n));
				tail = tail.getNext();
			}
		}
		
		int deQ() {
			int ret = front.getN();
			front = front.getNext();
			return ret;			
		}
		
		boolean hasHead() {
			return !(front == null);
		}
		
		
		class QBlock{
			int num;
			QBlock next;
			
			QBlock(int n, QBlock nex){
				num =n;
				next =nex;
			}
			
			QBlock(int n){
				num = n;
				next = null;
			}
			
			void addNext(QBlock q) {
				next = q;
			}
			
			int getN() { return num;}
			
			QBlock getNext() { return next;}
			
		}
	}

}
