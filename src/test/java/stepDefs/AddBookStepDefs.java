package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.RegisterNewUser;

public class AddBookStepDefs {

    RegisterNewUser registerNewUser=new RegisterNewUser();
    @Given("User should add  books")
    public void user_should_add_books() {
registerNewUser.addBook_mtd();
    }


    @Then("User should verifyStatusCode of adding book")
    public void user_should_verifyStatusCode_of_adding_book() {
registerNewUser.verifyStatusCode_AddingBook_mtd();
    }
}
