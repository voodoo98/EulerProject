package com.voodoo98.eulerproject.perfectnumber;

import static org.bitbucket.dollar.Dollar.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmbudantSieve {

    private final int n;

    public AmbudantSieve(final int n) {
        this.n = n;
    }

    public List<Integer> count() {
        final List<Integer> ambudants = this.buildAmbudantList();

        final Integer[] array = this.enrichAmbudants(ambudants);
        final List<Integer> list = Arrays.asList(array);
        final List<Integer> filteredList = list.stream().filter(i -> 0 < i).collect(Collectors.toList());
        return filteredList;
    }

    private Integer[] enrichAmbudants(final List<Integer> ambudants) {
        final Integer[] array = $(0, this.n).toArray();
        for (final Integer int1 : ambudants) {
            for (final Integer int2 : ambudants) {
                final int sum = int1 + int2;
                if (sum < this.n) {
                    array[sum] = -1;
                }
            }
        }
        return array;
    }

    private List<Integer> buildAmbudantList() {
        final List<Integer> abudants = new ArrayList<>();
        for (int i = 0; i < this.n; i++) {
            if (PerfectNumber.isAbundant(i)) {
                abudants.add(i);
            }
        }
        return abudants;
    }

}
