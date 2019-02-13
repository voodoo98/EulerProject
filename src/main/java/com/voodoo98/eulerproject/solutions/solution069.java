package com.voodoo98.eulerproject.solutions;

import com.voodoo98.eulerproject.phi.EulerPhi;
import com.voodoo98.eulerproject.phi.EulerPhiSieve;
import com.voodoo98.eulerproject.utils.MathUtils;

public class solution069 {

	public static void main(final String[] args) {
		long time = System.currentTimeMillis();

		System.err.println("Euler Phi Sieve: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		System.err.println("Unique solution: " + oldSolution());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static int count() {
		final int limit = 1_000_000;
		final EulerPhiSieve eulerPhiSieve = new EulerPhiSieve(limit);
		final long[] phi = eulerPhiSieve.count();
		double max = 0;
		int maxN = 0;
		for (int n = 2; n < phi.length; n++) {
			final double nphin = (double) n / phi[n];
			if (max < nphin) {
				max = nphin;
				maxN = n;
			}
		}
		return maxN;
	}

	// https://en.wikipedia.org/wiki/Euler%27s_totient_function#Proof_of_Euler.27s_product_formula
	// https://en.wikipedia.org/wiki/Euler%27s_totient_function#Other_formulae_involving_.CF.86
	// http://www.doc.ic.ac.uk/~mrh/330tutor/ch05s02.html
	private static int oldSolution() {
		final double sqrt = Math.sqrt(1000000);
		final EulerPhi eulerPhi = new EulerPhi();
		double max = 0;
		int maxN = 0;
		for (int n = 2; n < sqrt; n++) {
			for (int m = n + 1; m < sqrt; m++) {
				if (MathUtils.areCoprimes(n, m)) {
					final int phinm = eulerPhi.getPhi(n) * eulerPhi.getPhi(m);
					final double nphin = (double) n * m / phinm;
					if (max < nphin) {
						max = nphin;
						maxN = n * m;
					}
				}
			}
		}
		return maxN;
	}

}
