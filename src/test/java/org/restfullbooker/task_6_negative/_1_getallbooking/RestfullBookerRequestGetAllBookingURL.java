package org.restfullbooker.task_6_negative._1_getallbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RestfullBookerRequestGetAllBookingURL{

    // when the RestFullBookerGetAllBookingTestCases clas is need the response firstly the RestfullBookerRequestGetAllBookingURL class is loadeed
    //then all the static variables is loaded it means the methods is called automaticlally
    public static final Response response;

    static{

        try {
            //here is the called who is handling the exception
            //it is the good practice to intialize the static variable in the static block (in this you can intialize the final variable also
            // otherwise without static block  you have to intialize the static variable in same line where it is decalared )
            response=restfullBookerRequestGetAllBookingURL();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    static Response restfullBookerRequestGetAllBookingURL() throws JsonProcessingException {

        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");


        Response response = requestSpecification.get();
        // Printing Response as string
        System.out.println(response.asString());

        return response;


    }


}
