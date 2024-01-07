package org.restfullbooker.task_1_positive._2_createbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
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



    RequestSpecification requestSpecification= RestAssured.given();
    ValidatableResponse validatableResponse;
    String token;




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







}
