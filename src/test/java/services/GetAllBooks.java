package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllBooks {

    Response response;

    public void getAllBooks_mtd(){
        response= RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();
    }
    public void verifyStatusCode_GetAllBooks_mtd(){
        response.then().statusCode(200);
    }
}
