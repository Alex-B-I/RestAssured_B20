package day09;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Department;
import testbase.HR_ORDS_TestBAse;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestingOutLombokDependency extends HR_ORDS_TestBAse {

    @Test
    public void testDepartmentPOJO(){
        Department d = new Department();
        d.setDepartment_id(100);
        System.out.println(d.getDepartment_id());
        System.out.println(d);
        Department d2 = new Department(100,"ABC",12,1700);
        System.out.println("d2 = " + d2);

    }

    @DisplayName("GET /departments and save List of POJO")
    @Test
    public void testDepartmentJsonArrayToListOfPojo(){
        List<Department> allDeps = get("/departments")
                .jsonPath().getList("items", Department.class) ;

        //allDeps.forEach(System.out::println);
        // COPY THE CONTENT OF THIS LIST INTO NEW LIST
        // AND ONLY PRINT IF THE DEP MANAGER ID IS NOT NULL
        List<Department> allDepsCopy = new ArrayList<>(allDeps);
        allDepsCopy.removeIf( eachDep -> eachDep.getManager_id()==0 ) ;
        allDepsCopy.forEach(System.out::println);
    }
    @DisplayName("GET /departments and filter the result with JsonPath groovy")
    @Test
    public void testFilterResultWithGroovy(){
        JsonPath jp = get("/departments").jsonPath();
        List<Department> allDeps =
                jp.getList("items.findAll { it.manager_id > 0 }" , Department.class ) ;
        allDeps.forEach(System.out::println);
        // what if I just wanted to get List<String> to store DepartmentName
        List<String> depNames = jp.getList("items.department_name") ;
        System.out.println("depNames = " + depNames);
        // -->> items.department_name (all)
        // -->> items.findAll {it.manager_id>0 }.department_name (filtered for manager_id more than 0)
        List<String> depNamesFiltered = jp.getList("items.findAll {it.manager_id>0 }.department_name") ;
        System.out.println("depNamesFiltered = " + depNamesFiltered);


// Get all departments ID if its more than 70
        List<Integer> allDepIds = jp.getList("items.department_id") ;
        System.out.println("allDepIds = " + allDepIds);
        List<Integer> allDepIdsFiltered =
                jp.getList("items.department_id.findAll{ it > 70 } ") ;
        System.out.println("allDepIdsFiltered = " + allDepIdsFiltered);
// what if we have more than one condition for example : department_id between 70 - 100
        List<Integer> deps70to100 =
                jp.getList("items.department_id.findAll{ it >= 70 && it <= 100  }") ;
        System.out.println("deps70to100 = " + deps70to100);
// get the name of departments if department_id between 70 - 100


    }

}