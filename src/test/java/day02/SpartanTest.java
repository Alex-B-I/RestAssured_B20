package day02;

import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class SpartanTest {

    Response response =  get("http://34.207.224.251:8000/api/hello") ;
}
