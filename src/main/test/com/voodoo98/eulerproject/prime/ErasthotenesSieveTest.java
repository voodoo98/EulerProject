package com.voodoo98.eulerproject.prime;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ErasthotenesSieveTest {

	private ErasthotenesSieve sieve;

	@BeforeClass
	public void init() {
		this.sieve = new ErasthotenesSieve();
		this.sieve.count();
	}

	@Test
	public void checkErasthotenesSieve() {
		Assert.assertEquals(this.sieve.getCount(-1), 0);
		Assert.assertEquals(this.sieve.getCount(0), 0);
		Assert.assertEquals(this.sieve.getCount(1), 0);
		Assert.assertEquals(this.sieve.getCount(2), 1);
		Assert.assertEquals(this.sieve.getCount(3), 1);
		Assert.assertEquals(this.sieve.getCount(4), 1);
		Assert.assertEquals(this.sieve.getCount(5), 1);
		Assert.assertEquals(this.sieve.getCount(6), 2);
		Assert.assertEquals(this.sieve.getCount(7), 1);
		Assert.assertEquals(this.sieve.getCount(644), 3);
		Assert.assertEquals(this.sieve.getCount(645), 3);
		Assert.assertEquals(this.sieve.getCount(646), 3);
		Assert.assertEquals(this.sieve.getCount(647), 1);
		Assert.assertEquals(this.sieve.getCount(134043), 4);
		Assert.assertEquals(this.sieve.getCount(134044), 4);
		Assert.assertEquals(this.sieve.getCount(134045), 4);
		Assert.assertEquals(this.sieve.getCount(134046), 4);
	}
}
