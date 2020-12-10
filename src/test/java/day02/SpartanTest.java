package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;

public class SpartanTest {

    @BeforeAll
    public static void setUp(){
        // baseURI and basePath is static fields of RestAssured Class
        // Since we static imported RestAssured, we can access all static field directly just like it's in our own class here
        // you can use static way as below
        //RestAssured.baseURI = "http://34.207.224.251:8000";
        // or you can directly use as below
        baseURI = "http://34.207.224.251:8000";
        //RestAssured.basePath = "/api" ;
        basePath = "/api";
        //baseURI+ basePath + whatever you provided in http method like GET post
        //for example:
        //get("/spartans") -->> get(baseURI + basePath + "/spartans")


    }


    @AfterAll
    public static void tearDown(){
        // resetting the value of baseURI , basePath to original value
   //     RestAssured.reset();
        reset();
    }

    @DisplayName("Testing /api/spartans endpoint")
    @Test
    public void testGetAllSpartan(){

        //send a GET request to above endpoint
        //save the response
        //print out the result
        //try to assert the status code
        //content type header

        //Response response =  get("http://34.207.224.251:8000/api/spartans") ;
        Response response =  get("/spartans") ;
        response.prettyPrint();

        assertThat(response.statusCode(), is(200)) ;
        assertThat(response.contentType(),equalTo(ContentType.JSON.toString()));


    }

    @DisplayName("Testing /api/spartans endpoint XML Rsponse")
    @Test
    public void testGetAllSpartanXML(){

/**
 * given
 *      --- RequestSpecification
 *      used to provide additional information about the request
 *      base url  base path
 *      header , query params , path variable , payload
 *      authentication authorization
 *      logging , cookie
 * when
 *      --- This is where you actually send the request with http method
 *      -- like GET POST PUT DELETE .. with the URL
 *      -- We get Response Object after sending the request
 * then
 *      -- ValidatableResponse
 *      -- validate status code , header , payload , cookie
 *      -- responseTime , structure of the payload  , logging
 */
       given()
               .header("accept","application/xml") .
       when()
               //.get("http://34.207.224.251:8000/api/spartans") .
               .get("/spartans") .
       then()
//               .assertThat()  // this is not required, but can be added to make it obvious that this is were we start assertions
               .statusCode(200)
//               .and() //this is not required at all, just for readability, optional
               .header("Content-Type","application/xml") ;


       //this will do same exact things as above in slightly different way
       //since accept header and content type header is so common, RestAssured
       //has good support or those header by providing method directly rather than using header method we used above

        /*
        You are hungry for a burger.
you send a request to your waiter saying "I'm sending "Content-type" burger and burger only"
the waiter gives you a respond with ACCEPT burger.
accept header ---> for response, saying you can accept this data as XML or Json  (to receive request)
Content-Type --->  you are telling postman what kind of data you are sending.  (to send request)
         */
       given()
                .accept(ContentType.XML).
       when()
              // .get("http://34.207.224.251:8000/api/spartans") .
               .get("/spartans") .
       then()
               .assertThat()
               .statusCode(is(200))
               .and()
               .contentType(ContentType.XML) ;

    }


}
