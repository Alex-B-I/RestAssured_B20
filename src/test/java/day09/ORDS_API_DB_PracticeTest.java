package day09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Country;
import testbase.HR_ORDS_TestBAse;
import utility.DB_Utility;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ORDS_API_DB_PracticeTest extends HR_ORDS_TestBAse {

    @DisplayName("GET /countries/{country_id}")
    @Test
    public void testResponseMatchDatabaseData(){

        String myCountryID = "AR";
        // send request to /countries/{country_id} for AR
        // save the result as Country POJO
         Country arPOJO = given()
                        .pathParam("country_id", myCountryID).
                      when()
                         .get("/countries/{country_id}")
                         .as(Country.class) ;
        // here the shorter way of above code
       //  Country arPOJO1 = get("/countries/{country_id}",myCountryId).as(Country.class);

        System.out.println("arPOJO"+arPOJO);

        String query = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = '" + myCountryID + "'  " ;
        System.out.println("query = " + query);

        DB_Utility.runQuery(query);
        Map<String ,String> dbResultMap = DB_Utility.getRowMap(1);
// now start validating the actual response to expected result from database
        assertThat(arPOJO.getCountry_id(),is(dbResultMap.get("COUNTRY_ID")));
        assertThat(arPOJO.getCountry_name(),is(dbResultMap.get("COUNTRY_NAME")));
// save region_id from the map as number
       int expectedRegionId = Integer.parseInt(dbResultMap.get("REGION_ID"));
        assertThat(arPOJO.getRegion_id(), equalTo(expectedRegionId));

    }


}
