package com.apiTesting;

import com.apiTesting.files.resources;
import com.apiTesting.files.payLoad;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basic3 {

    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {

        FileInputStream file = new FileInputStream("/home/sunil/Documents/apiTesting/src/com/apiTesting/files/env.properties");
        prop.load(file);

    }

    @Test
    public void AddandDeletePlace(){

        RestAssured.baseURI = prop.getProperty("HOST");;
        System.out.println(RestAssured.baseURI);
        Response responseExtracted = given().queryParam("key",prop.getProperty("KEY")).
                body(payLoad.getPostData()).when().
                post(resources.placeIDResource()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status",equalTo("OK")).
                extract().response();

        String response = responseExtracted.asString();
        System.out.println(response);
        JsonPath stringProcessor = new JsonPath(response);
        String placeId = stringProcessor.get("place_id");
        System.out.println(placeId);

        //Imported value ot be placed as post body for another api

        given().queryParam("key",prop.getProperty("KEY")).
                body("{" +
                        "  \"place_id\":\""+placeId+"\"" +
                        "}").when().
                post(resources.placeIDResource()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status",equalTo("OK"));

    }
}
