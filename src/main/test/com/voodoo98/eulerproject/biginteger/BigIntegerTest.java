package com.voodoo98.eulerproject.biginteger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BigIntegerTest {

	@Test
	public void checkAddingBothZero() {
		final BigInteger bigInteger = new BigInteger();
		bigInteger.add("0");
		Assert.assertEquals(bigInteger.value(), "0");
	}

	@Test
	public void checkAddingZero() {
		final BigInteger bigInteger1 = new BigInteger("1212121212").add("0");
		Assert.assertEquals(bigInteger1.value(), "1212121212");

		final BigInteger bigInteger2 = new BigInteger().add("123456");
		Assert.assertEquals(bigInteger2.value(), "123456");

		final BigInteger bigInteger3 = new BigInteger().add("1234561111111111111111111111111111111111111");
		Assert.assertEquals(bigInteger3.value(), "1234561111111111111111111111111111111111111");

	}

	@Test
	public void checkAddingIntegerNumbers() {
		final long numA = 1212121212l;
		final long numB = 999999l;
		final String expected = String.valueOf(numA + numB);
		final BigInteger bigInteger = new BigInteger().add(numA, numB);
		Assert.assertEquals(bigInteger.value(), expected);
	}

	@Test
	public void checkAddingLongNumbers() {
		final long number = 1212121212l;
		final long adding = 999999999999l;
		final String expected = String.valueOf(number + adding);
		final BigInteger bigInteger = new BigInteger(number).add(adding);
		Assert.assertEquals(bigInteger.value(), expected);
	}

	@Test
	public void checkAddingVeryBigNumbers() {
		final BigInteger bigInteger1 = new BigInteger("11111111111111111111").add("11111111111111111111");
		Assert.assertEquals(bigInteger1.value(), "22222222222222222222");

		final BigInteger bigInteger2 = new BigInteger("22222222222222222222").add("77777777777777777777");
		Assert.assertEquals(bigInteger2.value(), "99999999999999999999");

		final BigInteger bigInteger3 = new BigInteger("999999").add("777777");
		Assert.assertEquals(bigInteger3.value(), "1777776");

		final BigInteger bigInteger4 = new BigInteger("99999999999999999999").add("77777777777777777777");
		Assert.assertEquals(bigInteger4.value(), "177777777777777777776");

		final BigInteger bigInteger5 = new BigInteger("555555").add("555555");
		Assert.assertEquals(bigInteger5.value(), "1111110");

		final BigInteger bigInteger6 = new BigInteger("55555555555555555555").add("55555555555555555555");
		Assert.assertEquals(bigInteger6.value(), "111111111111111111110");

	}

	@Test
	public void checkMultiPlyWithZero() {
		final BigInteger bigInteger = new BigInteger();
		bigInteger.multiply("0", "12");
		Assert.assertEquals(bigInteger.value(), "0");
	}

	@Test
	public void checkZeroIsMultiplied() {
		final BigInteger bigInteger = new BigInteger();
		bigInteger.multiply("3312", "0");
		Assert.assertEquals(bigInteger.value(), "0");
	}

	@Test
	public void checkMultiPly() {
		final long x = 11;
		final int y = 12;
		final String expected = String.valueOf(x * y);
		final BigInteger bigInteger = new BigInteger().multiply(x, y);
		Assert.assertEquals(bigInteger.value(), expected);
	}

	@Test
	public void checkMultiPlyWithBiggerNumbers() {
		final long x = 11121212;
		final int y = 121212;
		final String expected = String.valueOf(x * y);
		final BigInteger bigInteger1 = new BigInteger().multiply(x, y);
		Assert.assertEquals(bigInteger1.value(), expected);
		final BigInteger bigInteger2 = new BigInteger(x).multiply(y);
		Assert.assertEquals(bigInteger2.value(), expected);
	}

	@Test
	public void checkMultiPlyWithBigIntegersAndOne() {
		final BigInteger bigInteger1 = new BigInteger("12121212121212121212").multiply(1);
		Assert.assertEquals(bigInteger1.value(), "12121212121212121212");
		final BigInteger bigInteger2 = new BigInteger().multiply("12121212121212121212", "1");
		Assert.assertEquals(bigInteger2.value(), "12121212121212121212");
	}

	@Test
	public void checkMultiPlyWithBigIntegersAndTwo() {
		final BigInteger bigInteger1 = new BigInteger("12121212121212121212").multiply("2");
		Assert.assertEquals(bigInteger1.value(), "24242424242424242424");
		final BigInteger bigInteger2 = new BigInteger().multiply("12121212121212121212", "2");
		Assert.assertEquals(bigInteger2.value(), "24242424242424242424");
	}

	@Test
	public void checkMultiPlyWithBigIntegers() {
		final BigInteger bigInteger = new BigInteger("12121212121212121212").multiply("11111111111111111111");
		Assert.assertEquals(bigInteger.value(), "134680134680134680131986531986531986532");
	}

	@Test
	public void checkPowWithZero() {
		final BigInteger bigInteger1 = new BigInteger().pow(2, 3);
		Assert.assertEquals(bigInteger1.value(), "8");
		final BigInteger bigInteger2 = new BigInteger().pow(2, 16);
		Assert.assertEquals(bigInteger2.value(), "65536");
		final BigInteger bigInteger3 = new BigInteger().pow(3, 4);
		Assert.assertEquals(bigInteger3.value(), "81");
		final BigInteger bigInteger4 = new BigInteger().pow(24, 34);
		Assert.assertEquals(bigInteger4.value(), "84563357566790276763032290197830086290913099776");
		final BigInteger bigInteger5 = new BigInteger().pow(100, 3);
		Assert.assertEquals(bigInteger5.value(), "1000000");

	}

	@Test
	public void checkFactorial() {
		final BigInteger bigInteger0 = new BigInteger(4).factorial();
		Assert.assertEquals(bigInteger0.value(), "24");
		final BigInteger bigInteger1 = new BigInteger().factorial(5);
		Assert.assertEquals(bigInteger1.value(), "120");
		final BigInteger bigInteger2 = new BigInteger().factorial(10);
		Assert.assertEquals(bigInteger2.value(), "3628800");
		final BigInteger bigInteger3 = new BigInteger().factorial(100);
		Assert.assertEquals(bigInteger3.value(),
		        "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
	}

	@Test
	public void checkDivision() {
		final BigInteger bigInteger = new BigInteger();
		Assert.assertEquals(bigInteger.divide(10, 8).value(), "1.25");
		Assert.assertEquals(bigInteger.divide(10, 4).value(), "2.5");
		Assert.assertEquals(bigInteger.divide(100, 100).value(), "1");
		Assert.assertEquals(bigInteger.divide(0, 1121200).value(), "0");
		Assert.assertEquals(bigInteger.divide(1121200, 25).value(), "44848");
		Assert.assertEquals(bigInteger.divide(1, 8).value(), "0.125");
		Assert.assertEquals(bigInteger.divide(100, 40).value(), "2.5");
	}

	@Test
	public void checkCompareSimple() {
		final BigInteger bigInteger1 = new BigInteger(1);
		final BigInteger bigInteger2 = new BigInteger(2);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger2), true);
		Assert.assertEquals(bigInteger2.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger1), true);
	}

	@Test
	public void checkCompareInt() {
		final BigInteger bigInteger1 = new BigInteger(1211);
		final BigInteger bigInteger2 = new BigInteger(3523);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger2), true);
		Assert.assertEquals(bigInteger2.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger1), true);
	}

	@Test
	public void checkCompareString() {
		final BigInteger bigInteger1 = new BigInteger("0011");
		final BigInteger bigInteger2 = new BigInteger("3523");
		Assert.assertEquals(bigInteger1.lessThan(bigInteger2), true);
		Assert.assertEquals(bigInteger2.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger1), true);
	}

	@Test
	public void checkCompareComplicated() {
		final BigInteger bigInteger1 = new BigInteger("1211352521323333");
		final BigInteger bigInteger2 = new BigInteger("35234324341341421");
		Assert.assertEquals(bigInteger1.lessThan(bigInteger2), true);
		Assert.assertEquals(bigInteger2.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger1), true);
	}

	@Test
	public void checkCompareMoreComplicated() {
		final BigInteger bigInteger1 = new BigInteger("3523432434134142135234324341341421");
		final BigInteger bigInteger2 = new BigInteger("3523432434134142135234324341341422");
		Assert.assertEquals(bigInteger1.lessThan(bigInteger2), true);
		Assert.assertEquals(bigInteger2.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger1), true);
	}

	@Test
	public void checkCompareComplicatedEquals() {
		final BigInteger bigInteger1 = new BigInteger("1211352521323333");
		final BigInteger bigInteger2 = new BigInteger("1211352521323333");
		Assert.assertEquals(bigInteger1.lessThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.lessThan(bigInteger1), false);
		Assert.assertEquals(bigInteger1.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger1), false);
		Assert.assertEquals(bigInteger2.greaterThan(bigInteger2), false);
		Assert.assertEquals(bigInteger1.equals(bigInteger2), true);
	}

}
