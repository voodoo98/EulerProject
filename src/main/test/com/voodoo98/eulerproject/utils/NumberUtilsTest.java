package com.voodoo98.eulerproject.utils;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberUtilsTest {

    @Test
    public void paddingNotNullNumberWith0Check() {
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(0, -1), "0");
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(0, 0), "0");
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(-100, -1), "-100");
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(-100, 3), "-100000");
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(1212, 0), "1212");
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(1212, 2), "121200");
        Assert.assertEquals(NumberUtils.paddingNotNullNumberWith0(33312121, 14), "3331212100000000000000");
    }

    @Test
    public void checkArrayConvertInt() {
        Assert.assertEquals(NumberUtils.arrayConvertInt(new int[] { 0 }), 0l);
        Assert.assertEquals(NumberUtils.arrayConvertInt(new int[] { 10 }), 10l);
        Assert.assertEquals(NumberUtils.arrayConvertInt(new int[] { 1, 2, 3, 4 }), 1234l);
        Assert.assertEquals(NumberUtils.arrayConvertInt(new int[] { 1, 2, 3, 4, 0, 0, 5, 6, 7 }), 123400567l);
        Assert.assertEquals(NumberUtils.arrayConvertInt(new int[] { 1, 0, 0, 0 }), 1000l);
    }

    @Test
    public void checkLongConvertToArray() {
        Assert.assertEquals(NumberUtils.longConvertToArray(0), new int[] {});
        Assert.assertEquals(NumberUtils.longConvertToArray(1), new int[] { 1 });
        Assert.assertEquals(NumberUtils.longConvertToArray(12451212), new int[] { 1, 2, 4, 5, 1, 2, 1, 2 });
        Assert.assertEquals(NumberUtils.longConvertToArray(Long.MAX_VALUE), new int[] { 9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7 });
    }

    @Test
    public void checkCircularNumber() {
        Assert.assertEquals(Arrays.toString(NumberUtils.countCircularNumbers(0)), "[]");
        Assert.assertEquals(Arrays.toString(NumberUtils.countCircularNumbers(1)), "[1]");
        Assert.assertEquals(Arrays.toString(NumberUtils.countCircularNumbers(12)), "[12, 21]");
        Assert.assertEquals(Arrays.toString(NumberUtils.countCircularNumbers(197)), "[197, 971, 719]");
        Assert.assertEquals(Arrays.toString(NumberUtils.countCircularNumbers(1234)), "[1234, 2341, 3412, 4123]");

    }

    @Test
    public void checkPalindromeNumber() {
        Assert.assertEquals(NumberUtils.isPalindrome(0), true);
        Assert.assertEquals(NumberUtils.isPalindrome(8), true);
        Assert.assertEquals(NumberUtils.isPalindrome(12112), false);
        Assert.assertEquals(NumberUtils.isPalindrome(121121), true);
        Assert.assertEquals(NumberUtils.isPalindrome(111111), true);
        Assert.assertEquals(NumberUtils.isPalindrome(123456), false);
        Assert.assertEquals(NumberUtils.isPalindrome("0"), true);
        Assert.assertEquals(NumberUtils.isPalindrome("8"), true);
        Assert.assertEquals(NumberUtils.isPalindrome("12112"), false);
        Assert.assertEquals(NumberUtils.isPalindrome("121121"), true);
        Assert.assertEquals(NumberUtils.isPalindrome("111111"), true);
        Assert.assertEquals(NumberUtils.isPalindrome("123456"), false);

    }
}
