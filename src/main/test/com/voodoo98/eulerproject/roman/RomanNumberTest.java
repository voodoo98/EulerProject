package com.voodoo98.eulerproject.roman;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RomanNumberTest {

    @Test
    public void testBasicRomanNumbers() {
        Assert.assertEquals(RomanNumber.convertToArabic("I"), 1);
        Assert.assertEquals(RomanNumber.convertToArabic("V"), 5);
        Assert.assertEquals(RomanNumber.convertToArabic("X"), 10);
        Assert.assertEquals(RomanNumber.convertToArabic("L"), 50);
        Assert.assertEquals(RomanNumber.convertToArabic("C"), 100);
        Assert.assertEquals(RomanNumber.convertToArabic("D"), 500);
        Assert.assertEquals(RomanNumber.convertToArabic("M"), 1000);
    }

    @Test
    public void testSpecialRomanNumbers() {
        Assert.assertEquals(RomanNumber.convertToArabic("XCIX"), 99);
        Assert.assertEquals(RomanNumber.convertToArabic("MCM"), 1900);
        Assert.assertEquals(RomanNumber.convertToArabic("MCMI"), 1901);
        Assert.assertEquals(RomanNumber.convertToArabic("MCMLXXXI"), 1981);
        Assert.assertEquals(RomanNumber.convertToArabic("MCMXCIX"), 1999);
        Assert.assertEquals(RomanNumber.convertToArabic("MM"), 2000);
        Assert.assertEquals(RomanNumber.convertToArabic("MMI"), 2001);
        Assert.assertEquals(RomanNumber.convertToArabic("MCDXC"), 1490);
        Assert.assertEquals(RomanNumber.convertToArabic("MDLV"), 1555);
        Assert.assertEquals(RomanNumber.convertToArabic("MDCCCLXXVI"), 1876);
        Assert.assertEquals(RomanNumber.convertToArabic("MMMMMMMMMMMMMMMDL"), 15550);
    }

    @Test
    public void testWrongRomanNumbers() {
        Assert.assertEquals(RomanNumber.convertToArabic("MCE"), -1);
    }

    @Test
    public void testEulerSampleRomanNumbers() {
        final List<String> asList = Arrays.asList("IIIIIIIIIIIIIIII", "VIIIIIIIIIII", "VVIIIIII", "XIIIIII", "VVVI", "XVI");
        for (final String number : asList) {
            Assert.assertEquals(RomanNumber.convertToArabic(number), 16);
        }
    }

    @Test
    public void testConvertFromIntegerToRoman() {
        Assert.assertEquals(RomanNumber.convertToRoman(16), "XVI");
        Assert.assertEquals(RomanNumber.convertToRoman(10), "X");
        Assert.assertEquals(RomanNumber.convertToRoman(100), "C");
        Assert.assertEquals(RomanNumber.convertToRoman(101), "CI");
        Assert.assertEquals(RomanNumber.convertToRoman(99), "XCIX");
        Assert.assertEquals(RomanNumber.convertToRoman(90), "XC");
        Assert.assertNotEquals(RomanNumber.convertToRoman(16), "IIIIIIIIIIIIIIII");
    }

    @Test
    public void testEulerSampleRomanNumbersInMinimalForm() {
        Assert.assertEquals(RomanNumber.isMinimalForm("IIIIIIIIIIIIIIII"), false);
        Assert.assertEquals(RomanNumber.isMinimalForm("VVIIIIII"), false);
        Assert.assertEquals(RomanNumber.isMinimalForm("XIIIIII"), false);
        Assert.assertEquals(RomanNumber.isMinimalForm("VVVI"), false);
        Assert.assertEquals(RomanNumber.isMinimalForm("XVI"), true);
    }

    @Test
    public void testConvertFromBiggerIntegerToRoman() {
        Assert.assertEquals(RomanNumber.convertToRoman(1900), "MCM");
        Assert.assertEquals(RomanNumber.convertToRoman(1901), "MCMI");
        Assert.assertEquals(RomanNumber.convertToRoman(1981), "MCMLXXXI");
        Assert.assertEquals(RomanNumber.convertToRoman(1999), "MCMXCIX");
        Assert.assertEquals(RomanNumber.convertToRoman(2000), "MM");
        Assert.assertEquals(RomanNumber.convertToRoman(2001), "MMI");
        Assert.assertEquals(RomanNumber.convertToRoman(1490), "MCDXC");
        Assert.assertEquals(RomanNumber.convertToRoman(1555), "MDLV");
        Assert.assertEquals(RomanNumber.convertToRoman(1876), "MDCCCLXXVI");
        Assert.assertEquals(RomanNumber.convertToRoman(15550), "MMMMMMMMMMMMMMMDL");
    }
}
