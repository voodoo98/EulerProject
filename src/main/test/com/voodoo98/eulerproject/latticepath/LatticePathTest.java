package com.voodoo98.eulerproject.latticepath;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.voodoo98.eulerproject.latticepaths.LatticePaths;

public class LatticePathTest {
    @Test
    public void checkPaths() {
        Assert.assertEquals(new LatticePaths(1).count(), 2);
        Assert.assertEquals(new LatticePaths(2).count(), 6);
        Assert.assertEquals(new LatticePaths(3).count(), 20);
        Assert.assertEquals(new LatticePaths(4).count(), 70);
    }
}
