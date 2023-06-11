package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.GetAllBooks;

public class GetAllBooksStepDefs {

    GetAllBooks getAllBooks=new GetAllBooks();
    @Given("User should see book collection")
    public void user_should_see_book_collection() {
getAllBooks.getAllBooks_mtd();
    }


    @Then("User should verifyStatusCode of seeing book collection")
    public void user_should_verifyStatusCode_of_seeing_book_collection() {
getAllBooks.verifyStatusCode_GetAllBooks_mtd();
    }
}
