package org.restfullbooker.task_2_positive._1_deleteuser;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restfullbooker.pojorequest.Customer;

import static io.restassured.RestAssured.given;
import static org.restfullbooker.task_1_positive._2_createbooking.RestfullBookerCreateBookingTestCases.deletedbookingid;

public class RestfullBookerRequestDeleteUserURL {
    static Response restfullBookerRequestDeleteUserURLRequest(){
            /* payload.setUsername("admin");
                     payload.setPassword("password123");*/

                   /*  String payload = "{\n" +
                             "    \"username\" : \"admin\",\n" +
                             "    \"password\" : \"password123\"\n" +
                             "}";*/
        //serialisation means to convert the object in the byte of streams (ie the jason format or xml format) then \
        // 10110 is send on the network



        RequestSpecification requestSpecification= given();


        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+deletedbookingid);
        requestSpecification.contentType(ContentType.JSON);//header is set

        requestSpecification.auth().preemptive().basic("admin","password123");
        //either you provide basic auth or the token as below




        //System.out.println(token);
        // requestSpecification.cookie(token);

        /*

                   what is meant by preemptive in this -->requestSpecification.auth().preemptive().basic("admin","password123");

            SK
            In this context, "preemptive" refers to sending the HTTP Basic authentication credentials preemptively with the request, rather than waiting for a 401 Unauthorized response first.

                    Specifically:

            By default, RestAssured will not send authentication credentials until it receives a 401 Unauthorized response from the server.
                    Adding .preemptive() configures it to send the Basic auth credentials up front with the first request.
            This avoids having to make an initial unauthenticated request and get a 401 before sending the credentials.
            So "preemptive" here means sending the Basic authentication proactively before getting a 401, rather than waiting for the Unauthorized response first.

            It's a way to configure RestAssured to automatically authenticate the first request, avoiding an extra round trip to get the 401 error. The credentials are sent preemptively.

            Copy

            how whole process happnes

            SK
            Here is an overview of how the preemptive authentication process works with RestAssured:

            When making a request, RestAssured checks if preemptive auth is enabled.
            If so, it will automatically add an Authorization header containing the Base64 encoded credentials (username:password) to the request before sending it.
            For example:

            Copy code

            Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=
                    The server receives the request with the Authorization header and can authenticate the user without having to return a 401 Unauthorized first.
            If authentication succeeds, the server will return a 200 OK or whatever the normal response should be.
            If it fails, the server may still return a 401 or another error response.
            So the key points are:

            Preemptive auth sends the credentials up front, without waiting for a 401.
            This avoids an extra request/response round trip to get the 401 before authenticating.
            The Authorization header is added automatically by RestAssured before sending the request.
            Server can authenticate immediately without prompting for credentials.
                    So preemptive mode streamlines the auth process by sending credentials proactively.

            Copy

            how process happens in non preemptive

            SK
            Here is how the authentication process works without preemptive mode:

            RestAssured makes a request to the server without any authentication credentials.
                    The server returns a 401 Unauthorized status code, indicating authentication is required.
                    RestAssured sees the 401 response and automatically sends the credentials.
            It will re-send the original request, this time with an Authorization header containing the Base64 encoded username:password.
                    For example:

            Copy code

            GET /api/resource

            401 Unauthorized

            GET /api/resource
            Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=
                    The server authenticates the credentials and returns a 200 OK if they are valid.
                    So in summary, without preemptive mode:

            No credentials are sent on the first request.
            Server returns 401 asking for authentication.
                    RestAssured automatically resends request with credentials.
                    Extra round trip of unauthenticated request/401 response.
                    Overall slower due to extra call to get 401 before authenticating.
            So non-preemptive auth requires an extra call to prompt for credentials before sending them.
             Preemptive mode avoids this by sending credentials up front.*/









        return requestSpecification.when().delete();
    }



}
