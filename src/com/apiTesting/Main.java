package com.apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Main {

    @Test
    public static void Test() {

        RestAssured.baseURI = "https://maps.googleapis.com";

        given().param("location","-33.8670522,151.1957362").param("radius","1500").
                param("type","restaurant").param("keyword","cruise").
                param("key","AIzaSyBF0YL-HA1WEDLyrYwhcLYkTHoGfmEMT5Y").
                when().get("maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].place_id.",equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).and().
                header("Server","scaffolding on HTTPServer2");
    }
}
