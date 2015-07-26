package inversionTest;

import static org.junit.Assert.*;
import inversionCount.InversionCounter;

import java.util.Arrays;

import org.junit.Test;

public class TestCount {

	@Test
	public void testArraySplit() {
		long[] testA = {3,2,1,4,6,5};
		long[] left = Arrays.copyOfRange(testA, 0, testA.length/2);
		long[] right = Arrays.copyOfRange(testA, testA.length/2, testA.length);
		assertArrayEquals(left,new long[] {3,2,1});
		assertArrayEquals(right,new long[] {4,6,5});
		assertEquals(4, InversionCounter.countInversions(testA));
	}
	
	@Test
	public void testArraySplit2() {
		long[] testA = {1,2,3,4,5,6,7,8,9,10};
		assertEquals(0, InversionCounter.countInversions(testA));
	}
	
	@Test
	public void testArraySplit3() {
		long[] testA = {10,2,3,4,5,6,7,8,9,1};
		assertEquals(17, InversionCounter.countInversions(testA));
	}

}
