package com.apiTesting.files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class reusableFile {

    public static XmlPath rawToXML(Response res){
        String apiResponse = res.toString();
        XmlPath xmlResponse = new XmlPath(apiResponse);
        return xmlResponse;
    }

    public static JsonPath rawToJson(Response res){
        String apiResponse = res.asString();
        JsonPath jsonResponse = new JsonPath(apiResponse);
        return jsonResponse;
    }
}
