package day02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;

public class SpartanTest {

    @DisplayName("Testing /api/spartans endpoint")
    @Test
    public void testGetAllSpartan(){

        //send a GET request to above endpoint
        //save the response
        //print out the result
        //try to assert the status code
        //content type header

        Response response =  get("http://34.207.224.251:8000/api/spartans") ;
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
               .get("http://34.207.224.251:8000/api/spartans") .
       then()
//               .assertThat()  // this is not required, but can be added to make it obvious that this is were we start assertions
               .statusCode(200)
//               .and() //this is not required at all, just for readability, optional
               .header("Content-Type","application/xml") ;


       //this will do same exact things as above in slightly different way
       //since

       given()
                .accept(ContentType.XML).
       when()
               .get("http://34.207.224.251:8000/api/spartans") .
       then()
               .assertThat()
               .statusCode(is(200))
               .and()
               .contentType(ContentType.XML) ;

    }


}
