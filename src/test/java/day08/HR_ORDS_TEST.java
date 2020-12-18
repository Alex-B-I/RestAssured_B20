package day08;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import pojo.BookCategory;
import pojo.Region;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;

public class HR_ORDS_TEST {

    //http://54.90.101.103:1000/ords/hr/regions/3
    @BeforeAll
    public static void setUp(){
        baseURI = "http://54.90.101.103:1000";
        basePath = "/ords/hr" ;
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }



}
