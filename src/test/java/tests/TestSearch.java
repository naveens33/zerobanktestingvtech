package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch extends BaseTest {
    @Test
    public void testSearch(){
        extentTest = report.createTest("Search scenario");
        Assert.assertEquals(5,7);
    }
}
