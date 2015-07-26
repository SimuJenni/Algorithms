package quicksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
	private static int comparisonCount;
	private static Scanner scanner;

	public QuickSort() {
		this.comparisonCount = 0;
	}

	public void quickSort(int[] array, int i, int j) {
		if (j - i < 2) {
			return;
		}
		comparisonCount += j - i - 1;
		int p = choosePivot(array, i, j);
		swap(array, p, i);
		int split = partition(array, i, j);
		quickSort(array, i, split - 1);
		quickSort(array, split, j);
	}

	public static int choosePivot(int[] array, int i, int j) {
		// return i;
		// return j-1;
		int x = array[i];
		int y = array[j - 1];
		int z = array[(j + i - 1) / 2];
		if (x <= y && y <= z || z <= y && y <= x) {
			return j - 1;
		}
		if (x <= z && z <= y || y <= z && z <= x) {
			return (j + i - 1) / 2;
		} else {
			return i;
		}
	}

	private static int partition(int[] A, int l, int r) {
		int p = A[l]; // pivot element
		int i = l + 1;
		for (int j = l + 1; j < r; j++) {
			if (A[j] < p) {
				swap(A, j, i);
				i++;
			}
		}
		swap(A, l, i - 1);
		return i;
	}

	private static void swap(int[] A, int j, int i) {
		int tmp = A[j];
		A[j] = A[i];
		A[i] = tmp;
	}

	public static int random(int m, int n) {
		return (int) (Math.random() * (n - m + 1)) + m;
	}

	public int getCount() {
		return comparisonCount;
	}

	public static void main(String[] args) throws FileNotFoundException {
		scanner = new Scanner(new File("QuickSortTest.txt"));
		ArrayList<Integer> a = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			a.add(scanner.nextInt());
		}
		int[] testArray = toIntArray(a);
		QuickSort sorter = new QuickSort();
		sorter.quickSort(testArray, 0, testArray.length);

		System.out.println("The number of comparisons was: "
				+ sorter.getCount());
	}

	static int[] toIntArray(ArrayList<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}
}
