package org.restfulbooler;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;
import io.restassured.specification.RequestSpecification;
import org.restfulbooler.pojo.Customer;
import org.testng.annotations.Test;

public class RestfulBooker {


    //currently you know about the bdd style only ie given when then so use that only
    // we donot use the chaining instead we use non-chaining way bz again we have to apply whole line again and agian

    // you cannot use this below line outside any method it will give error
    //   RequestSpecification r=RestAssured.given();
    //
    //
    //                     r.baseUri("https://restful-booker.herokuapp.com");
    //                     r.basePath("/auth");

/*
String payload -> 1. cannot reuse the payload,2.static /non dyamic ,3.difficult to maintain in automation framework ,4.limited validation the response-string extra and limited(object)
if you have curd or api to automate
< 50 test cases ->strings

Map payload-> 1.key value,2.hashmap-hasing code,3.map to jason-gson/jackson,4.dynamic in nature
5.code reusabiltiy is limited.

still not a object
validation will be limited
automation framework < 50-150 test cases

Objects and classes payload -->
1.pojo
2. dynamic
3. no limitation on validation
4. gson/jackson-object
5. reuse the code
6. easy to maintain
7.reuse the code
8.automation framework maintain
test case>100



 */


                 @Test
    void  postUserNameAndPassword(){

                     Customer payload=new Customer();
                     payload.setUsername("sumit");
                     payload.setPassword("Sumit@123");
                     RequestSpecification r=RestAssured.given();


                     r.baseUri("https://restful-booker.herokuapp.com");
                     r.basePath("/auth");
                     r.contentType(ContentType.JSON);//header is set
                     r.body(payload);//it will set as the class for payload (no map and string ), class for more than 150 test case
                     /* Response response=*/ // and it can be dynamic
                     //since the payload is the object type so the body has the overloaded method which has argument Object
                     r.when().post();
                     /* ValidatableResponse vr =response.then().log().all();
                      vr.statusCode(200);*/

                     r.then().statusCode(200);
                     String token =r.then().e

                 }



}
