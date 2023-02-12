package uk.co.library.testsuit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;

public class Dataset extends TestBase {
    HomePage homePage;
    ResultPage resultPage;
    @BeforeMethod
    public void inIT(){
        homePage = new HomePage();
        resultPage = new ResultPage();
//       driver.switchTo().frame("gdpr-consent-notice");
//       homePage.clickOnAccept();
//       driver.switchTo().defaultContent();
    }
    @Test(dataProvider = "JobsFound",dataProviderClass = TestData.class)
    public void doLogin(String jobTitle, String location, int distanceDropDown, String salaryMin, String salaryMax,int salary,int jobType) {
        driver.switchTo().frame("gdpr-consent-notice");
        homePage.clickOnAccept();
        driver.switchTo().defaultContent();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.clickOnMoreoptions();
        homePage.selectDistance(String.valueOf(distanceDropDown));
        homePage.enterMinSalary(String.valueOf(salaryMin));
        homePage.enterMaxSalary(String.valueOf(salaryMax));
        homePage.selectSalaryTypeDropDown(salary);
        homePage.selectJobTypeDropDown(jobType);
        homePage.clickOnSearchButton();
        resultPage.getResultText();




    }
}
