package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class RegisterNewUser_StepDefs {

    RegisterNewUser registerNewUser=new RegisterNewUser();
    @Given("User should register with valid credentials")
    public void user_should_register_with_valid_credentials() {
registerNewUser.registerNewUser_mtd();
    }

    @Then("User should verify the registerStatusCode")
    public void user_should_verify_the_registerStatusCode() {
registerNewUser.verifyStatusCode_RegisterNewUser_mtd();
    }

}
