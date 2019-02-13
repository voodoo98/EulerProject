package com.voodoo98.eulerproject.utils;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilsTest {

    @Test
    public void checkRemoveLeadingZeros() {
        Assert.assertEquals(StringUtils.removeLeadingZeros(null), null);
        Assert.assertEquals(StringUtils.removeLeadingZeros(""), "");
        Assert.assertEquals(StringUtils.removeLeadingZeros("00023"), "23");
        Assert.assertEquals(StringUtils.removeLeadingZeros("0000000210000"), "210000");
        Assert.assertEquals(StringUtils.removeLeadingZeros("0100000210000"), "100000210000");
    }

    @Test
    public void checkStringToIntArray() {
        Assert.assertEquals(StringUtils.stringToIntArray(null), new int[] {});
        Assert.assertEquals(StringUtils.stringToIntArray(""), new int[] {});
        Assert.assertEquals(Arrays.equals(StringUtils.stringToIntArray("00023"), new int[] { 0, 0, 0, 2, 3 }), true);
        Assert.assertEquals(Arrays.equals(StringUtils.stringToIntArray("1234567890"), new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }), true);
        Assert.assertEquals(Arrays.equals(StringUtils.stringToIntArray("123456789012345678901234567890"),
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }), true);
    }

    @Test
    public void checkIsDecimal() {
        Assert.assertEquals(StringUtils.isDecimal(null), false);
        Assert.assertEquals(StringUtils.isDecimal(""), false);
        Assert.assertEquals(StringUtils.isDecimal("00023"), true);
        Assert.assertEquals(StringUtils.isDecimal("1234567890"), true);
        Assert.assertEquals(StringUtils.isDecimal("1234567890.0"), false);
        Assert.assertEquals(StringUtils.isDecimal("1234567890.alma"), false);
        Assert.assertEquals(StringUtils.isDecimal("aa1234567890"), false);
        Assert.assertEquals(StringUtils.isDecimal("123b4567890"), false);
    }

    @Test
    public void checkIsNumeric() {
        Assert.assertEquals(StringUtils.isNumeric(null), false);
        Assert.assertEquals(StringUtils.isNumeric(""), false);
        Assert.assertEquals(StringUtils.isNumeric("00023"), true);
        Assert.assertEquals(StringUtils.isNumeric("1234567890"), true);
        Assert.assertEquals(StringUtils.isNumeric("1234567890.0"), true);
        Assert.assertEquals(StringUtils.isNumeric("1234567890.alma"), false);
        Assert.assertEquals(StringUtils.isNumeric("aa1234567890"), false);
        Assert.assertEquals(StringUtils.isNumeric("123b4567890"), false);
        Assert.assertEquals(StringUtils.isNumeric("-00023"), true);
        Assert.assertEquals(StringUtils.isNumeric("-1234567890"), true);
        Assert.assertEquals(StringUtils.isNumeric("-1234567890.0"), true);
        Assert.assertEquals(StringUtils.isNumeric("-1234567890.alma"), false);
        Assert.assertEquals(StringUtils.isNumeric("-aa1234567890"), false);
        Assert.assertEquals(StringUtils.isNumeric("-123b4567890"), false);
    }

    @Test
    public void checkArePermutatedStrings() {
        Assert.assertEquals(StringUtils.arePermutatedStrings(null, null), false);
        Assert.assertEquals(StringUtils.arePermutatedStrings("", ""), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("41063625", "41063625"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("41063625", "49836032"), false);
        Assert.assertEquals(StringUtils.arePermutatedStrings("41063625", "56623104"), true);
        Assert.assertEquals(StringUtils.arePermutatedStrings("41063625", "66430125"), true);

    }

}
