package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.TestData;

public class TechGlobalTestCase3 extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @Test(priority = 1, description = "Validate Login card valid login and then logout")
    public void validateLoginForm() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);

        techGlobalLoginFormPage.loginButton.click();
        techGlobalLoginFormPage.logoutButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }
}
