package quickSortTest;

import static org.junit.Assert.*;

import org.junit.Test;

import quicksort.QuickSort;

public class TestQuickSort {

	@Test
	public void testArraySort() {
		int[] testA = { 3, 2, 1, 4, 6, 5 };
		QuickSort sorter = new QuickSort();
		sorter.quickSort(testA, 0, testA.length);
		assertArrayEquals(testA, new int[] { 1, 2, 3, 4, 5, 6 });
		assertEquals(9, sorter.getCount());
	}

	@Test
	public void testArraySort2() {
		int[] testA = { 4, 3, 2, 1 };
		QuickSort sorter = new QuickSort();
		sorter.quickSort(testA, 0, testA.length);
		assertArrayEquals(testA, new int[] { 1, 2, 3, 4 });
		assertEquals(6, sorter.getCount());
	}

	@Test
	public void testPivot() {
		int[] testA = { 4, 3, 2, 1 };
		int p = QuickSort.choosePivot(testA, 0, testA.length);
		assertEquals(1, p);
	}

}
