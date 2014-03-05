import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;


public class SorterTestCases {	

   	/**
	 * This test will check the sorting of listSize random numbers list
	 * It should return a sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test(timeout=5000)
	public void testSortNElementsInRandomOrderList() {
		
		// Don't push this limit too far if you are in a hurry... :)
		final int listSize = 10000;		
		
		final int lowerBound = -100000;
		final int upperBound = -lowerBound;
		
		/*
		 * The following piece of code generates listSize random numbers 
		 */
		// Declaration of some random number and boolean generators and local variable
		Random randomIntegerGenerator = new Random();
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

		// Creation of the actual list of random numbers (both number and sign are random)
		while ( listOfNumbers.size() < listSize ) {
			int randomInteger = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
			listOfNumbers.add( randomInteger );
		}

		// Transfer of numbers (from integer object to their corresponding primitive type)
		int[] testList = new int[listSize];
		for ( int i = 0; i < listSize; i++ ) {
			testList[i] = listOfNumbers.get( i ).intValue();
		}

		/**
		 * A nasty hack :)
		 * Using Java's modified merge sort for a quick sort of the 'master' list
		 *
		 * @See {@link http://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List)}
		 */
		Collections.sort( listOfNumbers );
		int[] masterList = new int[listSize];
		for ( int i = 0; i < listSize; i++ ) {
			masterList[i] = listOfNumbers.get( i ).intValue();
		}

		// Sort the list with Sorter.sort()
		Sorter.sort( testList );

		// Some 'decent' output
		System.out.println( "Sorting with Java native's method : " + Arrays.toString( masterList ) );
		System.out.println( "Sorting with shell-sort           : " + Arrays.toString( testList ) );

		/*
		 * And here comes the assertion...
		 */
		Assert.assertArrayEquals( masterList, testList );

	} // testSortNElementsInRandomOrderList()

	/**
	 * This test will check the sorting of an empty list
	 * It should return an empty list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortEmptyList() {
		// Create some empty lists
		int[] masterList = new int[0];
		int[] testList = new int[0];
		
		// Sort one of them
		Sorter.sort(testList);
		
		// Make sure they're still equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortEmptyList()

   	/**
	 * This test will check the sorting of one element list
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortOneElementList() {		
		final int lowerBound = -100000;
		final int upperBound = -lowerBound;
		
		// Create two lists, each with the same randomly generated element
		Random randomIntegerGenerator = new Random();
		int randomInt = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
		int[] masterList = {randomInt};
		int[] testList = {randomInt};
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortOneElementList()

	/**
	 * This test will check the sorting of two elements list in correct order
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortTwoElementsInCorrectOrderList() {
		final int lowerBound = -100000;
		final int upperBound = -lowerBound;
		
		// Create two lists, both with the same correctly ordered random integers
		Random randomIntegerGenerator = new Random();
		int randomInt1 = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
		int randomInt2 = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
		int[] masterList = new int[2];
		int[] testList = new int[2];
		if(randomInt1 > randomInt2) {
			masterList[0] = randomInt2;
			masterList[1] = randomInt1;
			testList[0] = randomInt2;
			testList[1] = randomInt1;
		} else {
			masterList[0] = randomInt1;
			masterList[1] = randomInt2;
			testList[0] = randomInt1;
			testList[1] = randomInt2;			
		}
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortTwoElementsInCorrectOrderList()

	/**
	 * This test will check the sorting of two elements list in reverse order
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortTwoElementsInReverseOrderList() {		
		final int lowerBound = -100000;
		final int upperBound = -lowerBound;
		
		// Create two lists with the same random integers, one correctly ordered, one incorrectly
		Random randomIntegerGenerator = new Random();
		int randomInt1 = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
		int randomInt2 = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
		int[] masterList = new int[2];
		int[] testList = new int[2];
		if(randomInt1 > randomInt2) {
			masterList[0] = randomInt2;
			masterList[1] = randomInt1;
			testList[0] = randomInt1;
			testList[1] = randomInt2;
		} else {
			masterList[0] = randomInt1;
			masterList[1] = randomInt2;
			testList[0] = randomInt2;
			testList[1] = randomInt1;			
		}
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortTwoElementsInReverseOrderList()

	/**
	 * This test will check the sorting of two equal elements list
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortTwoEqualElementsList() {	
		final int lowerBound = -100000;
		final int upperBound = -lowerBound;
		
		// Create two lists, each with two of the same randomly generated element
		Random randomIntegerGenerator = new Random();
		int randomInt = randomIntegerGenerator.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
		int[] masterList = {randomInt, randomInt};
		int[] testList = {randomInt, randomInt};
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );	
	} // testSortTwoEqualElementsList()

	/**
	 * This test will check the sorting of three elements list in correct order
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsInCorrectOrderList() {	
		final int upperBound = 100000;
		
		// Create two lists, each with the same three randomly generated elements in ascending order
		Random randomIntegerGenerator = new Random();
		int randomInt1 = randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt2 = randomInt1 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt3 = randomInt2 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int[] masterList = {randomInt1, randomInt2, randomInt3};
		int[] testList = {randomInt1, randomInt2, randomInt3};
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortThreeElementsInCorrectOrderList()	

	/**
	 * This test will check the sorting of three elements list with the first two swapped
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsWithFirstTwoSwappedList() {		
		final int upperBound = 100000;

		// Create two lists, with the same three randomly generated elements in ascending order
		// in one, and the two first swapped in the other
		Random randomIntegerGenerator = new Random();
		int randomInt1 = randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt2 = randomInt1 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt3 = randomInt2 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int[] masterList = {randomInt1, randomInt2, randomInt3};
		int[] testList = {randomInt2, randomInt1, randomInt3};
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortThreeElementsWithFirstTwoSwappedList()	

	/**
	 * This test will check the sorting of three elements list with the last two swapped
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsWithLastTwoSwappedList() {		
		final int upperBound = 100000;

		// Create two lists, with the same three randomly generated elements in ascending order
		// in one, and the two first swapped in the other
		Random randomIntegerGenerator = new Random();
		int randomInt1 = randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt2 = randomInt1 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt3 = randomInt2 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int[] masterList = {randomInt1, randomInt2, randomInt3};
		int[] testList = {randomInt1, randomInt3, randomInt2};
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortThreeElementsWithLastTwoSwappedList()	

	/**
	 * This test will check the sorting of three elements list in reverse order
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsInReverseOrderList() {		
		final int upperBound = 100000;

		// Create two lists, with the same three randomly generated elements in ascending order
		// in one, and the two first swapped in the other
		Random randomIntegerGenerator = new Random();
		int randomInt1 = randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt2 = randomInt1 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int randomInt3 = randomInt2 + randomIntegerGenerator.nextInt( upperBound ) + 1;
		int[] masterList = {randomInt1, randomInt2, randomInt3};
		int[] testList = {randomInt3, randomInt2, randomInt1};
		
		Sorter.sort(testList);

		// Make sure they're equal		
		Assert.assertArrayEquals( masterList, testList );
	} // testSortThreeElementsInReverseOrderList()	

	/**
	 * This test will look for the maximum element of n unordered elements list
	 * It should return the biggest element of the list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testMaximumElementOfList() {
        int[] masterList = new int[]{32,6,-1,234,623,19,-342,523,2621,-23,0};
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        for(int n : masterList){
            listOfNumbers.add(n);
        }
        Collections.sort(listOfNumbers);
        int[] testList = new int[masterList.length];
        for(int i = 0;i < testList.length;i++){
            testList[i] = masterList[i];
        }
        Sorter.sort(testList);
		Assert.assertEquals((int)listOfNumbers.get(masterList.length-1),testList[masterList.length-1]);
	} // testMaximumElementOfList()

	/**
	 * This test will look for the minimum element of n unordered elements list
	 * It should return the smallest element of the list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testMinimumElementOfList() {
        int[] masterList = new int[]{32,6,-1,234,623,19,-342,523,2621,-23,0};
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        for(int n : masterList){
            listOfNumbers.add(n);
        }
        Collections.sort(listOfNumbers);
        int[] testList = new int[masterList.length];
        for(int i = 0;i < testList.length;i++){
            testList[i] = masterList[i];
        }
        Sorter.sort(testList);
		Assert.assertEquals((int)listOfNumbers.get(0),testList[0]);
	} // testMinimumElementOfList()	
	
	@Test
	public void testNull() {
        boolean thrown = false;
        try{
            Sorter.sort(null);
        }catch(NullPointerException e){
            thrown = true;
        }
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void testMinMaxIntList() {
        int[] masterList = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] testList = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        Sorter.sort(testList);
		Assert.assertArrayEquals( masterList, testList );
	}


} // SorterTestCases{}
