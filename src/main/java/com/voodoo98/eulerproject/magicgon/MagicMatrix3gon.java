package com.voodoo98.eulerproject.magicgon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.voodoo98.eulerproject.magicgon.Magic3Gon.A;
import static com.voodoo98.eulerproject.magicgon.Magic3Gon.B;
import static com.voodoo98.eulerproject.magicgon.Magic3Gon.C;
import static com.voodoo98.eulerproject.magicgon.Magic3Gon.D;
import static com.voodoo98.eulerproject.magicgon.Magic3Gon.E;
import static com.voodoo98.eulerproject.magicgon.Magic3Gon.F;

import com.voodoo98.eulerproject.biginteger.BigInteger;
import com.voodoo98.eulerproject.permutation.Permute;
import com.voodoo98.eulerproject.utils.NumberUtils;

public class MagicMatrix3gon {

	public BigInteger countMax() {
		final Permute permute = new Permute(true);
		permute.permute(Magic3Gon.getIntValues());

		BigInteger max = BigInteger.ZERO;
		for (final int[] permArray : permute.getArrayListResult()) {
			Magic3Gon.setValues(permArray);
			final BigInteger concatMatrixLines = this.concatMatrixLines();
			if (concatMatrixLines != null && max.lessThan(concatMatrixLines)) {
				max = concatMatrixLines;
			}
		}
		return max;
	}

	public BigInteger concatMatrixLines() {
		final int[] sumUpper = { D.getValue(), C.getValue(), B.getValue() };
		final int[] sumRight = { F.getValue(), B.getValue(), A.getValue() };
		final int[] sumLeft = { E.getValue(), A.getValue(), C.getValue() };
		final List<int[]> list = new ArrayList<>(Arrays.asList(sumUpper, sumRight, sumLeft));

		final int i = this.getclockwiseOrderedArray(sumUpper, sumRight, sumLeft);

		final int[] concat = NumberUtils.concatArrays(list.get(i), list.get((i + 1) % 3), list.get((i + 2) % 3));
		final int sumArray1 = NumberUtils.sumArray(sumLeft);
		BigInteger result = null;
		if (8 < sumArray1 && sumArray1 == NumberUtils.sumArray(sumUpper) && sumArray1 == NumberUtils.sumArray(sumRight)) {
			result = new BigInteger(concat);
		}
		return result;

	}

	private int getclockwiseOrderedArray(final int[] upper, final int[] right, final int[] left) {
		int result = -1;
		final int min = Math.min(upper[0], Math.min(right[0], left[0]));
		if (min == upper[0]) {
			result = 0;
		} else if (min == right[0]) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}

}
