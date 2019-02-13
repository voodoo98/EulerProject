package com.voodoo98.eulerproject.fibonacci;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.voodoo98.eulerproject.biginteger.BigInteger;

public class FibonacciTest {
	@Test
	public void checkCount() {

		final FibonacciBigInteger fibonacci = new FibonacciBigInteger();
		Assert.assertEquals(fibonacci.count(1), BigInteger.createInstance(1));
		Assert.assertEquals(fibonacci.count(2), BigInteger.createInstance(1));
		Assert.assertEquals(fibonacci.count(3), BigInteger.createInstance(2));
		Assert.assertEquals(fibonacci.count(4), BigInteger.createInstance(3));
		Assert.assertEquals(fibonacci.count(10), BigInteger.createInstance(55));
		Assert.assertEquals(fibonacci.count(11), BigInteger.createInstance(89));
		Assert.assertEquals(fibonacci.count(12), BigInteger.createInstance(144));

	}
}
