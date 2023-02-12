package uk.co.library.testsuit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase {
    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod
    public void inIT() {
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Test
    public void test() {
        driver.switchTo().frame("gdpr-consent-notice");
        homePage.clickOnAccept();
        driver.switchTo().defaultContent();
        homePage.enterJobTitle("software tester");
        homePage.enterLocation("ha3 9rf");
        homePage.selectDistance(String.valueOf(Integer.parseInt("100")));
        homePage.clickOnMoreoptions();
        homePage.enterMinSalary("30000");
        homePage.enterMaxSalary("50000");
        homePage.selectSalaryTypeDropDown(1);
        homePage.selectJobTypeDropDown(1);
        homePage.clickOnSearchButton();
        resultPage.getResultText();
        String expected = resultPage.getResultText();
        String actualText = resultPage.getResultText();
        Assert.assertEquals(expected, actualText, "Result of searching Jobs");

    }

}
