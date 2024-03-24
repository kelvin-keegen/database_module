package com.appsbykeegan.api.pgdatabase.model;

public record ResponseTemplate(
        int statusCode,
        String message,
        Object data
) {

}
