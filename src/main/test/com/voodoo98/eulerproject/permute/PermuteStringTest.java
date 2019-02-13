package com.voodoo98.eulerproject.permute;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.voodoo98.eulerproject.permutation.PermuteString;
import com.voodoo98.eulerproject.utils.StringUtils;

public class PermuteStringTest {

    @Test
    public void checkStringPermutation() {
        final PermuteString permuteString = new PermuteString("123");
        permuteString.permute();
        final List<String> resultList = permuteString.getResultList();
        Assert.assertEquals(resultList.size(), 6);
        Assert.assertEquals(resultList.get(0), "123");
        Assert.assertEquals(resultList.get(1), "132");
        Assert.assertEquals(resultList.get(2), "213");
        Assert.assertEquals(resultList.get(3), "231");
        Assert.assertEquals(resultList.get(4), "321");
        Assert.assertEquals(resultList.get(5), "312");

    }

    @Test
    public void checkArePermutatedString() {
        Assert.assertEquals(StringUtils.arePermutatedStrings("", ""), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("0", "0"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("1", "1"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("11", "11"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("12", "21"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("123456", "456321"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("1234567", "456321"), false);
        Assert.assertEquals(StringUtils.arePermutatedStrings("123456", "4563216"), false);

    }
}
