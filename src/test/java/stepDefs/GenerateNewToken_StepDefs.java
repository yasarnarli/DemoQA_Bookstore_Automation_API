package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class GenerateNewToken_StepDefs {
RegisterNewUser registerNewUser= new RegisterNewUser();
    @Given("User should input valid credentials")
    public void user_should_input_valid_credentials() {
registerNewUser.generateNewToken_mtd();
    }



    @Then("User should verifyStatusCode of generating new token")
    public void user_should_verifyStatusCode_of_generating_new_token() {
registerNewUser.verifyStatusCode_GenerateNewToken_mtd();
    }
}
