package com.voodoo98.eulerproject.latticepaths;

import com.voodoo98.eulerproject.utils.MathUtils;

public class LatticePaths {

	private final int n;

	public LatticePaths(final int n) {
		this.n = n;
	}

	public long count() {
		return MathUtils.nchoosek(this.n * 2, this.n);
	}

	public int getDimension() {
		return this.n;
	}

	@Override
	public String toString() {
		return "LatticePaths [n=" + this.n + "]";
	}

}
