package org.restfullbooker.task_6_negative._2_deletebookingid;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.restfullbooker.task_6_negative._2_deletebookingid.RestfullBookerRequestDeleteUserURL. restfullBookerRequestDeleteUserURLRequest;

public class RestBookerRequestDeleteUserTestCases {


    @Test
    void restBookerRequestDeleteUserStatusOk() throws JsonProcessingException {

        Response response= restfullBookerRequestDeleteUserURLRequest();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(204));
        //deifnitly it will give bug bz in documents 201 is there but on the delete http response must be 204
        //no content

    }




    @Test
    void  restBookerRequestDeleteUserContentType() throws JsonProcessingException {

        Response response = restfullBookerRequestDeleteUserURLRequest();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"), Matchers.is(true));

    }



}
