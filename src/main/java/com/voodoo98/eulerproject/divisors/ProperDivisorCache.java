package com.voodoo98.eulerproject.divisors;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class ProperDivisorCache {

    private final LoadingCache<Long, Long> cache = CacheBuilder.newBuilder().build(new CacheLoader<Long, Long>() {

        @Override
        public Long load(final Long number) throws Exception {
            return ProperDivisorCache.this.sumDivisors(number);
        }
    });

    public Long getSumOfDivisors(final long number) {
        return this.cache.getUnchecked(number);
    }

    private Long sumDivisors(final Long number) {
        final ProperDivisorList divisorList = new ProperDivisor(number).getDivisorList();
        long sum = 0;
        for (final Long divisor : divisorList) {
            sum += divisor;
        }
        return sum;
    }

}
