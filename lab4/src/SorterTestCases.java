import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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
		fail("This test is failing because it is yet to be implemented");
	} // testSortEmptyList()

   	/**
	 * This test will check the sorting of one element list
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortOneElementList() {
		fail("This test is failing because it is yet to be implemented");
	} // testSortOneElementList()

	/**
	 * This test will check the sorting of two elements list in correct order
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortTwoElementsInCorrectOrderList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortTwoElementsInCorrectOrderList()

	/**
	 * This test will check the sorting of two elements list in reverse order
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortTwoElementsInReverseOrderList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortTwoElementsInReverseOrderList()

	/**
	 * This test will check the sorting of two equal elements list
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortTwoEqualElementsList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortTwoEqualElementsList()

	/**
	 * This test will check the sorting of three elements list in correct order
	 * It should return the same list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsInCorrectOrderList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortThreeElementsInCorrectOrderList()	

	/**
	 * This test will check the sorting of three elements list with the first two swapped
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsWithFirstTwoSwappedList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortThreeElementsWithFirstTwoSwappedList()	

	/**
	 * This test will check the sorting of three elements list with the last two swapped
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsWithLastTwoSwappedList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortThreeElementsWithLastTwoSwappedList()	

	/**
	 * This test will check the sorting of three elements list in reverse order
	 * It should return the sorted list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testSortThreeElementsInReverseOrderList() {		
		fail("This test is failing because it is yet to be implemented");
	} // testSortThreeElementsInReverseOrderList()	

	/**
	 * This test will look for the maximum element of n unordered elements list
	 * It should return the biggest element of the list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testMaximumElementOfList() {
		fail("This test is failing because it is yet to be implemented");
	} // testMaximumElementOfList()

	/**
	 * This test will look for the minimum element of n unordered elements list
	 * It should return the smallest element of the list
	 * 
	 * See {@link Sorter#sort(int[])}
	 */	
	@Test
	public void testMinimumElementOfList() {
		fail("This test is failing because it is yet to be implemented");
	} // testMinimumElementOfList()	

} // SorterTestCases{}
