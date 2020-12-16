package day06;
import io.restassured.http.ContentType;
import utility.ConfigurationReader;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
import org.junit.jupiter.api.DisplayName;
import utility.SpartanUtil;

import java.util.Map;

public class PostWithCustomObject {

    @BeforeAll
    public static void setUp(){
        //RestAssured.filters().add(new AllureRestAssured() ) ;
        baseURI = ConfigurationReader.getProperty("spartan.base_url");
        basePath = "/api" ;
        }

        @AfterAll
    public static void tearDown(){
        reset();
    }

}
