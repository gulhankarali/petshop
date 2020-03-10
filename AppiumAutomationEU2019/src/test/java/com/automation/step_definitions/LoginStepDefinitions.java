package com.automation.step_definitions;

import com.automation.pages.LoginPage;
import com.automation.utilities.MobileUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    LoginPage loginPage= new LoginPage();

    @Given("User clicks on Get Started")
    public void user_clicks_on_Get_Started() {
        loginPage.clickOnGetStarted();
    }

    @When("Login with Etsy credentials")
    public void login_with_Etsy_credentials() {
        loginPage.login();
        MobileUtilities.wait(10);
    }

    @Then("User verifies that etsy logo is displayed")
    public void user_verifies_that_etsy_logo_is_displayed() {

    }

}
