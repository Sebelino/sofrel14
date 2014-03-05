
public class Sorter {	
	
	/**
	 * This sort method is an implementation of the shell sort algorithm
	 * A not so efficient sort algorithm for large list of numbers but still
	 * efficient enough for somewhat medium sized lists (note that it all
	 * depends on the choice of the gap)
	 * 
	 * See {@link http://en.wikipedia.org/wiki/Shellsort}.
	 * 
	 * @param list
	 * @return
	 */
	public static void sort( int[] list ) {	
		
		// Define the step size
		final int step = 3;
		
		// Let's find an initial value of the gap (somewhat pre-chosen...)
		int gap = 1;
		while ( gap < list.length ) {
			gap = step*gap + 1;
		}
		
		// Let's do the real sorting...
		while ( gap > 0 ) {
			
			for ( int i = 0; i < gap; i++ ) {
				for ( int j = gap + i; j < list.length; j += gap ) {
					int tmp = list[j];
					int k = j - gap;
					
					while ( k >= 0 && list[k] > tmp ) {
						list[k + gap] = list[k];
						k -= gap;
					}
					
					list[k + gap] = tmp;
					
					/*
					 * At this point the following invariant applies:
					 * Each array[ 0, gap, 2*gap,..., k ] is sorted
					 */

				}
			}
			gap = (gap-1)/step;
			
			
			/*
			 * At this point the following invariant applies:
			 * Each gap-sub-array is sorted
			 */

		}
		
	} // sort()

} // Sorter{}