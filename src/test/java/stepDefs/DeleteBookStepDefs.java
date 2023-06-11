package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class DeleteBookStepDefs {

    RegisterNewUser registerNewUser=new RegisterNewUser();
    @Given("User should delete the book")
    public void user_should_delete_the_book() {
registerNewUser.deleteBook_mtd();
    }



    @Then("User should verifyStatusCode of Deleting the book")
    public void user_should_verifyStatusCode_of_Deleting_the_book() {
registerNewUser.verifyStatusCode_DeleteBook_mtd();
    }

}
