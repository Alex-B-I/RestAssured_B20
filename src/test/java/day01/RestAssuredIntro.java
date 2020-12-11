package day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.* ;

public class RestAssuredIntro {

    @DisplayName("Spartan GET /api/hello Endpoint Test")
    @Test
    public void TestHello(){

        // This is the public ip I shared for spartan2
        // use it if you do not have your own
        // if you have your own , use your own IP
        //http://100.26.101.158:8000/api/hello

        // make sure this is what's imported for data type Response
        // import io.restassured.response.Response;

       // Response response =  get("http://100.26.101.158:8000/api/hello") ;
        Response response = get("http://34.207.224.251:8000/api/hello") ;
       // RestAssured.get("http://34.207.224.251:8000/api/hello") ; //!!! alt+enter+enter-->> generate Response response
        // get status code out of this Response object
        System.out.println("status code is : " + response.statusCode()  );

        // assert the status code is 200
        assertThat(response.statusCode(),is(200));

        //how to pretty print entire response body
        //prettyPrint() --print and return the body (payload) as String   /// body ---->>>> payload
        String payload = response.prettyPrint();
        // assertThat the body is Hello from Sparta

        assertThat(payload , is("Hello from Sparta") );

        // There are always multiple way to same thing in RestAssured
        //get the header called ContentType from the response
        System.out.println( response.getHeader("Content-Type"));
        System.out.println( response.getContentType() );
        System.out.println( response.contentType() );

        //assertThat Content-Type is text/plain;charset=UTF-8
        assertThat(response.contentType(),is ("text/plain;charset=UTF-8"));
        assertThat(response.contentType(), containsString("text/plain"));

        // assert That Content-Type startWith text
        assertThat(response.contentType(),startsWith("text"));

        // Easy way to work with Content-type without typing much
        // We can use ContentType Enum from RestAssured to easily get main part content-type
        // ContentType.TEXT -->> text/plain as Enum
        // startWith accept a String object
        // so use toString method to turn ContentType.TEXT to String so we can use it startWith
        assertThat(response.contentType(),startsWith(""+ContentType.TEXT));
        assertThat(response.contentType(),startsWith(ContentType.TEXT.toString()));

        assertThat(response.contentType(),is(not(ContentType.JSON)));

//==========================================================short video===========================
        Response response1 = get("http://34.207.224.251:8000/api/spartans");
        assertThat(response1.body().asString(), is(containsStringIgnoringCase("Ervin")));


    }




}
