package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class UpdateBookCollectionStepDefs {

    RegisterNewUser registerNewUser=new RegisterNewUser();
    @Given("User should update collection")
    public void user_should_update_collection() {
registerNewUser.updateBookCollection_mtd();
    }



    @Then("User should verifyStatusCode of updating")
    public void user_should_verifyStatusCode_of_updating() {
registerNewUser.verifyStatusCode_UpdateBookCollection_mtd();
    }
}
