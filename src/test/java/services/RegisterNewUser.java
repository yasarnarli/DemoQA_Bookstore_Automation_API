package services;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class RegisterNewUser {

    Faker faker=new Faker();
    Response response;
    public static String userName;
    public static String userID;
    public static String token;
    public static String isbn;
     String password=ConfigurationReader.get("commonPassword");

    public void registerNewUser_mtd(){


        userName=faker.name().fullName();

        Map<String, Object> body=new HashMap<>();

        body.put("userName",userName);
        body.put("password",password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .post("/Account/v1/User").prettyPeek();

        userID=response.path("userID");
        System.out.println("userID = " + userID);

    }

    public void verifyStatusCode_RegisterNewUser_mtd(){
        response.then().statusCode(201);
    }

    public void generateNewToken_mtd(){

        Map<String,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        response=RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .post("/Account/v1/GenerateToken");

        token=response.path("token");
        System.out.println("token = " + token);

    }
    public void verifyStatusCode_GenerateNewToken_mtd(){
        response.then().statusCode(200);
    }

    public void beAuthorized_mtd(){

        Map<String,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);

        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .post("/Account/v1/Authorized").prettyPeek();


    }

    public void verifyStatusCode_BeAuthorized_mtd(){
        response.then().statusCode(200);
    }

    public void addBook_mtd(){
        String body="{\n" +
                "  \"userId\": \""+userID+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn2")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);


        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books").prettyPeek();

        isbn=response.path("books[0].isbn");
        System.out.println("isbn = " + isbn);
    }

    public void verifyStatusCode_AddingBook_mtd(){
        response.then().statusCode(201);
    }

    public void updateBookCollection_mtd(){
        String body="{\n" +
                "  \"userId\": \""+userID+"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn3")+"\"\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);


        response=RestAssured.given().contentType(ContentType.JSON)
                .pathParam("isbn",isbn)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}").prettyPeek();

        isbn=response.path("books[0].isbn");
    }

    public void verifyStatusCode_UpdateBookCollection_mtd(){
        response.then().statusCode(200);
    }

    public void deleteBook_mtd(){
        String body="{\n" +
                "  \"isbn\": \""+isbn+"\",\n" +
                "  \"userId\": \""+userID+"\"\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);

        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .delete("/BookStore/v1/Book").prettyPeek();


    }

    public void verifyStatusCode_DeleteBook_mtd(){
        response.then().statusCode(204);
    }

    public void getUserInfo_mtd(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+token);

        response=RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",userID)
                .headers(tokenMap)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();
    }

    public void verifyStatusCode_GetUserInfo_mtd(){
        response.then().statusCode(200);
    }






}
