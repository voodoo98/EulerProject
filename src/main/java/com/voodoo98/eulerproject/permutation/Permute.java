package com.voodoo98.eulerproject.permutation;

import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.utils.NumberUtils;

public class Permute {

	private List<Long> result;
	private List<int[]> arrayList;
	private final boolean arrayListResult;

	public Permute() {
		this(false);
	}

	public Permute(final boolean arrayListResult) {
		this.arrayListResult = arrayListResult;
		if (arrayListResult) {
			this.arrayList = new ArrayList<>();
		} else {
			this.result = new ArrayList<>();
		}
	}

	public void permute(final int n) {
		this.permute(NumberUtils.longConvertToArray(n), 0);
	}

	public void permute(final int... arr) {
		this.permute(arr, 0);
	}

	public void permute(final int[] arr, final int k) {
		for (int i = k; i < arr.length; i++) {
			this.swap(arr, i, k);
			this.permute(arr, k + 1);
			this.swap(arr, k, i);
		}
		if (k == arr.length - 1) {
			if (this.arrayListResult) {
				this.arrayList.add(arr.clone());
			} else {
				this.result.add(NumberUtils.arrayConvertLong(arr));
			}
		}
	}

	private void swap(final int[] arr, final int i, final int k) {
		final int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}

	public static boolean arePermutatedPairs(long a, long b) {
		final int array[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		while (a != 0) {
			array[(int) (a % 10)]++;
			a /= 10;
		}
		while (b != 0) {
			array[(int) (b % 10)]--;
			b /= 10;
		}

		boolean res = true;
		for (final int element : array) {
			if (element != 0) {
				res = false;
				break;
			}
		}
		return res;
	}

	public static boolean hasPermutatedDigits(final long n) {
		return !hasSameDigits(n);
	}

	public static boolean hasSameDigits(long n) {
		final int array[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		while (n != 0) {
			array[(int) (n % 10)]++;
			n /= 10;
		}

		boolean res = false;
		for (final int element : array) {
			if (1 < element) {
				res = true;
				break;
			}
		}
		return res;
	}

	public List<Long> getResultList() {
		return this.result;
	}

	public List<int[]> getArrayListResult() {
		return this.arrayList;
	}

}
