package org.restfullbooker.task_1_positive._1_createtoken;


import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restfullbooker.pojorequest.Customer;

import static io.restassured.RestAssured.given;
import static org.restfullbooker.APIConstants.*;

public class RestFullBookerRequestTokenURL {

// when the RestfulBookerTokenTestCase clas is need the response firstly the RestFullBookerRequestTokenURL class is loaded
    //then all the static variables is loaded it means the methods is called automaticlaly

    //every request has seperate respone we need different variable for each request
    //i want to share to other class it is made static data member
    public static final Response response;
 //response cannot be changed when shared //static easily called by classname

    //it is the good practice to intialize the static variable in the static block (in this you can intialize the final variable also
    // otherwise without static block  you have to intialize the static variable in same line where it is declared )
    static{
        //final only initialized by static block or the at time of declaration


        //now we know when the object  RestFullBookerRequestTokenURL is made by the jvm.
        //is loaded in teh metaspace to tha all the static variable are loaded in the metaspace now
        //since the response is public  so this response can also be used outside the class

        //.response means jvm is currently working on the object
        //   RestFullBookerRequestTokenURL that
        //response  static variable to assigned
        response=restFullBookerRequestTokenURLRequest();
    }

    //this method only be used within class only
   private  static  Response restFullBookerRequestTokenURLRequest(){
            /* payload.setUsername("admin");
                     payload.setPassword("password123");*/

                   /*  String payload = "{\n" +
                             "    \"username\" : \"admin\",\n" +
                             "    \"password\" : \"password123\"\n" +
                             "}";*/
        //serialisation means to convert the object in the byte of streams (ie the jason format or xml format) then \
        // 10110 is send on the network






        Customer customer=new Customer("admin","password123");//directly passing the object to body
        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson=new Gson();
        String payload= gson.toJson(customer);
        RequestSpecification requestSpecification= given();


        requestSpecification.baseUri(BASE_URI);
        requestSpecification.basePath(BASE_PATH_TOKEN);
        requestSpecification.contentType(ContentType.JSON);//header is set
        requestSpecification.body(payload);//it will set as the class for payload (no map and string )
        // , class for more than 150 test case
        /* Response response=*/ // and it can be dynamic
        //since the payload is the object type so the body has the overloaded method which has argument Object
        //Response response=
                return requestSpecification.when().post();
    }
}
