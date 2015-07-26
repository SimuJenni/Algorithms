package inversionCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InversionCounter {

	private static Scanner scanner;

	public static long countInversions(long[] array) {
		SortData result = sortAndCount(array);
		return result.count;
	}

	private static SortData sortAndCount(long[] a) {
		if(a.length==1) {
			return new SortData(a, 0);
		}
		SortData left, right, split;
		left = sortAndCount(left(a));
		right = sortAndCount(right(a));
		split = countSplit(left.array, right.array);
		split.count += left.count + right.count; 
		return split;
	}

	private static long[] left(long[] a) {
		return Arrays.copyOfRange(a, 0, a.length/2);
	}
	
	private static long[] right(long[] a) {
		return Arrays.copyOfRange(a, a.length/2, a.length);
	}

	private static SortData countSplit(long[] left, long[] right) {
		long[] merge = new long[left.length+right.length];
		int splitCount = 0;
		int i=0, j=0;
		for(int k=0; k<merge.length; k++){
			if(j==right.length||(i<left.length&&left[i]<right[j])){
				merge[k] = left[i];
				i++;
			} else {
				merge[k] = right[j];
				j++;
				splitCount += left.length-i;
			}
		}
		if(splitCount<0)
			return null;
		SortData result =  new SortData(merge, splitCount);
		return result;
	}

	public static void main (String[] args) throws FileNotFoundException {
		scanner = new Scanner(new File("integerArray.txt"));
		ArrayList<Integer> a = new ArrayList<Integer>();
		while(scanner.hasNextInt()){
		   a.add(scanner.nextInt());
		}
		long[] testArray = toIntArray(a);

		System.out.println("The number of inversions is: "+ countInversions(testArray));
	}
	
	static long[] toIntArray(ArrayList<Integer> list){
		  long[] ret = new long[list.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = list.get(i);
		  return ret;
	}
}

class SortData {
	public long[] array;
	public long count;

	public SortData(long[] array, long count) {
		this.array = array;
		this.count = count;
	}
}
