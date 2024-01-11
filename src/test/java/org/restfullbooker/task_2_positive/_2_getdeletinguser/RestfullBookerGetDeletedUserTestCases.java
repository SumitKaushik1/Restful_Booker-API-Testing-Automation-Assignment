package org.restfullbooker.task_2_positive._2_getdeletinguser;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.restfullbooker.task_2_positive._2_getdeletinguser.RestfullBookerGetDeletedUserRequestURL.RestfullBookerGetDeletedBookingURL;



public class RestfullBookerGetDeletedUserTestCases {

    @Test
    void restBookerRequestDeleteUserStatusOk() throws JsonProcessingException {

        Response response= RestfullBookerGetDeletedBookingURL();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(404));

    }




    @Test
    void  restBookerRequestDeleteUserContentType() throws JsonProcessingException {

        Response response = RestfullBookerGetDeletedBookingURL();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(String.valueOf(response.getHeaders().hasHeaderWithName("Content-type")), true);




    }




}
