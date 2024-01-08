package org.restfullbooker.task_1_positive._2_createbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.restfullbooker.task_1_positive._1_createtoken.RestFullBookerRequestTokenURL;
import org.testng.annotations.Test;

import java.io.File;

import static org.restfullbooker.task_1_positive._2_createbooking.RestFullBookerRequestBookingURL.request;


public class RestfullBookerCreateBookingTestCases {



    public static String bookingid;
    @Test
    void  resfullBookerCreateBookingStatusOk() throws JsonProcessingException {

        Response response= request();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));

    }


    @Test
    void  resfullBoookerCreateBokingHeaderContentType() throws JsonProcessingException {

        Response response = request();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(String.valueOf(response.getHeaders().hasHeaderWithName("Content-type")), true);




    }



    @Test
    void  resfullBoookerTokenBodyJsonSchema() throws JsonProcessingException {

        Response response = request();
        //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/java/resource/schema1.json")));



    }



    @Test
    void resfullBoookerCreateBookingBookingId () throws JsonProcessingException {




        Response response = request();

        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        bookingid=jsonPath.getString("bookingid");

        //static variable withing a class can be accessed
        System.out.println(bookingid);//$.bookingid ->jasonpath

        //MatcherAssert.assertThat(response.getHeaders(), hasKey("Content-Type"));


        //Restfull booker is the class which is loaded first then all the static variable inside that class loaded then
        // so static variable is at the class level when then7 class the destroyed in then only static variable is destroyed
        //per class you can make only one type of variable name can be static variable.



        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        //4.
        System.out.println(response.asPrettyString());
        // "token" :"1343434", value in double quotes so it is string only ,now left side "12334" comes,right side
        // ,there is with Matcher object that it gives signal that it must not be the null value
        // equivalent to $.token
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("bookingid"),Matchers.notNullValue());
    }






}
