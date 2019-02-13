package com.voodoo98.eulerproject.prime;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PrimeSieveTest {

	private PrimeSieve primeSieve;

	@BeforeClass
	public void init() {
		this.primeSieve = new PrimeSieve();
		this.primeSieve.count();
	}

	@Test
	public void checkPrimeSieve() {
		Assert.assertEquals(this.primeSieve.isPrime(0), false);
		Assert.assertEquals(this.primeSieve.isPrime(1), false);
		Assert.assertEquals(this.primeSieve.isPrime(2), true);
		Assert.assertEquals(this.primeSieve.isPrime(3), true);
		Assert.assertEquals(this.primeSieve.isPrime(4), false);
		Assert.assertEquals(this.primeSieve.isPrime(5), true);
		Assert.assertEquals(this.primeSieve.isPrime(600), false);
		Assert.assertEquals(this.primeSieve.isPrime(997), true);
	}
}
