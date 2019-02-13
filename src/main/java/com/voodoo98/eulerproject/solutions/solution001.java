package com.voodoo98.eulerproject.solutions;

public class solution001 {

	public static void main(final String[] args) {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += countFizzBuzz(i);
		}
		System.out.println(sum);
	}

	private static int countFizzBuzz(final int number) {
		return number % 3 == 0 || number % 5 == 0 ? number : 0;
	}

}
