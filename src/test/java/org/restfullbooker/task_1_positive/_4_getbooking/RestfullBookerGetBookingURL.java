package org.restfullbooker.task_1_positive._4_getbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import static org.restfullbooker.task_1_positive._2_createbooking.RestfullBookerCreateBookingTestCases.bookingidToUpdate;

public class RestfullBookerGetBookingURL {
    // when the RestfullBookerGetBookingTestCases clas is need the response firstly the RestfullBookerGetBookingURL class is loadeed
    //then all the static variables is loaded it meaans the methods is called auto maticlaly
    public static final Response response;


    //here is the called who is handling the exception
    //it is the good practice to intialize the static variable in the static block (in this you can intialize the final variable also
    // otherwise without static block  you have to intialize the static variable in same line where it is decalared )
    static {
        try {
            response = restfullBookerGetBookingURL();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    //throws means its caller will handle the exception
    static Response restfullBookerGetBookingURL() throws JsonProcessingException {

        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
         //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        System.out.println(bookingidToUpdate);
        requestSpecification.basePath("/booking/"+bookingidToUpdate);


        Response response = requestSpecification.get();
        // Printing Response as string
        System.out.println(response.asString());

        return response;


    }


}
