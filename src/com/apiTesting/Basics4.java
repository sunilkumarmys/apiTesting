package com.apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics4 {

    @Test

    public void postData() throws IOException {

        String pdata = GenerateStringFromResource("Z:\\home\\sunil\\postdata2.xml");
        RestAssured.baseURI = "https://maps.googleapis.com";
        Response resp = given().queryParam("key","AIzaSyBF0YL-HA1WEDLyrYwhcLYkTHoGfmEMT5Y").
                body(pdata).when().
                        post("/maps/api/place/add/xml").
                        then().assertThat().statusCode(200).and().contentType(ContentType.XML).
        extract().response();

        String apiResponse = resp.toString();
        System.out.println(apiResponse);


    }

    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
