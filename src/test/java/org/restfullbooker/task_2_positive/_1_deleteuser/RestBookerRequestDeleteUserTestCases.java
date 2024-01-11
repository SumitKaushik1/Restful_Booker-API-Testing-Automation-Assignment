package org.restfullbooker.task_2_positive._1_deleteuser;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import static org.restfullbooker.task_2_positive._1_deleteuser.RestfullBookerRequestDeleteUserURL.restfullBookerRequestDeleteUserURLRequest;

public class RestBookerRequestDeleteUserTestCases {


    @Test
    void restBookerRequestDeleteUserStatusOk() throws JsonProcessingException {

        Response response= restfullBookerRequestDeleteUserURLRequest();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(204));
        //deifnitly it will give bug bz in documents 201 is there but on the delete http respone must be 204
        //no content

    }




    @Test
    void  restBookerRequestDeleteUserContentType() throws JsonProcessingException {

        Response response = restfullBookerRequestDeleteUserURLRequest();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(String.valueOf(response.getHeaders().hasHeaderWithName("Content-type")), true);




    }



}
