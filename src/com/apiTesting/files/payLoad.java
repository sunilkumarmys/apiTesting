package com.apiTesting.files;

public class payLoad {

    public static String getPostData(){
        String postBody = ("{" +
                "  \"location\":{" +
                "    \"lat\":-33.8669710," +
                "    \"lng\":151.1958750" +
                "  }," +
                "  \"accuracy\":50," +
                "  \"name\":\"Google Shoes!\"," +
                "  \"phone number\" :\"(02) 9374 4000\"," +
                "  \"address\":\"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," +
                "  \"types\":[\"shoe_store\"]," +
                "  \"website\":\"http://www.google.com.au/\"," +
                "  \"language\":\"eu-AU\"" +
                "}");

        return postBody;
    }
}
