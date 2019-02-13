package com.voodoo98.eulerproject.magicgon;

import static com.voodoo98.eulerproject.magicgon.Magic5Gon.A;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.B;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.C;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.D;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.E;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.F;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.G;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.H;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.I;
import static com.voodoo98.eulerproject.magicgon.Magic5Gon.J;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.voodoo98.eulerproject.permutation.Permute;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class MagicMatrix5gon {

	public long countMax() {
		final Permute permute = new Permute(true);
		permute.permute(Magic5Gon.getIntValues());

		long max = 0;
		for (final int[] permArray : permute.getArrayListResult()) {
			Magic5Gon.setValues(permArray);
			final long concatMatrixLines = this.concatMatrixLines();
			if (max < concatMatrixLines) {
				max = concatMatrixLines;
			}
		}
		return max;
	}

	public long concatMatrixLines() {
		final int[] sumA = { G.getValue(), A.getValue(), E.getValue() };
		final int[] sumB = { F.getValue(), E.getValue(), D.getValue() };
		final int[] sumC = { J.getValue(), D.getValue(), C.getValue() };
		final int[] sumD = { I.getValue(), C.getValue(), B.getValue() };
		final int[] sumE = { H.getValue(), B.getValue(), A.getValue() };
		final List<int[]> list = new ArrayList<>(Arrays.asList(sumA, sumB, sumC, sumD, sumE));

		final int i = this.getclockwiseOrderedArray(sumA, sumB, sumC, sumD, sumE);

		final int sumArrayA = NumberUtils.sumArray(sumA);
		if (sumArrayA == NumberUtils.sumArray(sumB) && sumArrayA == NumberUtils.sumArray(sumC) && sumArrayA == NumberUtils.sumArray(sumD) && sumArrayA == NumberUtils.sumArray(sumE)) {
			final int[] concat = NumberUtils.concatArrays(list.get(i), list.get((i + 1) % 5), list.get((i + 2) % 5), list.get((i + 3) % 5), list.get((i + 4) % 5));
			final String str = NumberUtils.intArrayToString(concat);
			return str.length() == 16 ? Long.parseLong(str) : -1;
		}
		return -1;

	}

	private int getclockwiseOrderedArray(final int[] sumA, final int[] sumB, final int[] sumC, final int[] sumD, final int[] sumE) {
		int result = -1;
		final int min = Math.min(sumA[0], Math.min(sumB[0], Math.min(sumC[0], Math.min(sumD[0], sumE[0]))));
		if (min == sumA[0]) {
			result = 0;
		} else if (min == sumB[0]) {
			result = 1;
		} else if (min == sumC[0]) {
			result = 2;
		} else if (min == sumD[0]) {
			result = 3;
		} else if (min == sumE[0]) {
			result = 4;
		}
		return result;
	}

}
