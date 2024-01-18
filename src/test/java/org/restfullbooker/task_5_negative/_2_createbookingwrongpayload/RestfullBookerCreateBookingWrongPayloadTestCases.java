package org.restfullbooker.task_5_negative._2_createbookingwrongpayload;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.response.Response;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import org.testng.annotations.Test;

import static org.restfullbooker.task_5_negative._2_createbookingwrongpayload.RestFullBookerRequestBookingWrongPayloadURL.RestFullBookerRequestBookingWrongPayloadURL;




public class RestfullBookerCreateBookingWrongPayloadTestCases {


    @Test
    void  resfullBookerCreateBookingStatusOk() throws JsonProcessingException {

        Response response= RestFullBookerRequestBookingWrongPayloadURL();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(500));

    }



}
