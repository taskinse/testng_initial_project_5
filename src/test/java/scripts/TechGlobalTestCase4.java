package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.TestData;

public class TechGlobalTestCase4 extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @Test(priority = 4, description = "Validate TechGlobal Login card Forgot Password?")
    public void validateForgotPassword() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.forgotPasswordLink.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordHeader.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordMessage.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.emailInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordSubmitButton.isDisplayed());
    }
    @Test(priority = 5, description = "Validate TechGlobal Login card Reset Password link")
        public void validatePasswordLink() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.forgotPasswordLink.click();
        techGlobalLoginFormPage.emailInputBox.sendKeys(TestData.emailForResetPassword);
        techGlobalLoginFormPage.resetPasswordSubmitButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.confirmationMessage.isDisplayed());
    }
    @Test(priority = 6, description = "Validate TechGlobal Login card invalid login with wrong username")
    public void validateWrongUsername() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.wrongUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.validPassword);
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        }
    @Test(priority = 7, description = "Validate TechGlobal Login card invalid login with wrong password")
    public void validateWrongpassword(){
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(TestData.wrongPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessagePassword.isDisplayed());
    }
    @Test(priority = 8, description = "Validate TechGlobal Login card invalid login with both wrong credentials ")
    public void validateWrongCredentials(){
        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.wrongUsername);
        techGlobalLoginFormPage.usernameInputBox.sendKeys(TestData.wrongPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());

    }
}
