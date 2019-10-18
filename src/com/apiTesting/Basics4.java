package com.apiTesting;

import com.apiTesting.files.reusableFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static java.util.Optional.*;
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

        XmlPath xmlResponse = reusableFile.rawToXML(resp);
        System.out.println(ofNullable(xmlResponse.get("PlaceAddResponse.place_id")));


    }

    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
