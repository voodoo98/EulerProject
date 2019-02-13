package com.voodoo98.eulerproject.eulernumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.voodoo98.eulerproject.polygonalnumber.TriangleNumber;

public class TriangleNumberTest {

	@Test
	public void checkTriangleNumbersSubArray() {
		final TriangleNumber p = new TriangleNumber();
		p.count();
		final long[] subArray = p.getSubArray(10, 30);
		final long[] result = { 10, 15, 21, 28 };
		Assert.assertEquals(subArray.length, 4);
		for (int i = 0; i < subArray.length; i++) {
			Assert.assertEquals(subArray[i], result[i]);
		}
	}
}
