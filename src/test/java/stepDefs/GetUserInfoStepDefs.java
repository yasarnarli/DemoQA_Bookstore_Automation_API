package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class GetUserInfoStepDefs {
    RegisterNewUser registerNewUser=new RegisterNewUser();
    @Given("User should get the user info")
    public void user_should_get_the_user_info() {
registerNewUser.getUserInfo_mtd();
    }



    @Then("User should verifyStatusCode of getUserInfo")
    public void user_should_verifyStatusCode_of_getUserInfo() {
registerNewUser.verifyStatusCode_GetUserInfo_mtd();
    }
}
