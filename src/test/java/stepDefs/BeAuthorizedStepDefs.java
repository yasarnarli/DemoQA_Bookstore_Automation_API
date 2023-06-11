package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class BeAuthorizedStepDefs {
RegisterNewUser registerNewUser=new RegisterNewUser();
    @Given("User should be authorized")
    public void user_should_be_authorized() {
registerNewUser.beAuthorized_mtd();
    }



    @Then("User should verifyStatusCode of authorizing")
    public void user_should_verifyStatusCode_of_authorizing() {
registerNewUser.verifyStatusCode_BeAuthorized_mtd();
    }
}
