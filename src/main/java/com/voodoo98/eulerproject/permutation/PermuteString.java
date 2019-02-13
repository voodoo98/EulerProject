package com.voodoo98.eulerproject.permutation;

import java.util.ArrayList;
import java.util.List;

import com.voodoo98.eulerproject.utils.StringUtils;

public class PermuteString {

    private final List<String> result;
    private final int[] array;

    public PermuteString(final String str) {
        this.result = new ArrayList<>();
        this.array = StringUtils.stringToIntArray(str);
    }

    public void permute() {
        this.permute(this.array, 0);
    }

    public void permute(final int[] arr, final int k) {
        for (int i = k; i < arr.length; i++) {
            this.swap(arr, i, k);
            this.permute(arr, k + 1);
            this.swap(arr, k, i);
        }
        if (k == arr.length - 1) {
            this.result.add(StringUtils.intArrayToString(this.array));
        }
    }

    private void swap(final int[] arr, final int i, final int k) {
        final int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    public List<String> getResultList() {
        return this.result;
    }

}
