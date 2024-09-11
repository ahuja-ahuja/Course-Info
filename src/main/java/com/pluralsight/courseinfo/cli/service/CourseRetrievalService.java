package com.pluralsight.courseinfo.cli.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CourseRetrievalService {

    private static final String PS_URI = "https://app.pluralsight.com/profile/data/author/%s/all-content"; //will mdify %s with java
    private static final HttpClient CLIENT = HttpClient   //one instance thread safe and can be shared in many calls  -  newHttpClient method will give all default methods
            .newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public List<PLuralSightCourse> getCoursesFor(String authrId){    //returning the record object- using jackson library to bind json to java object
        HttpRequest request = HttpRequest
                              .newBuilder(URI.create(PS_URI.formatted(authrId)))
                             .GET()
                             .build();
        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());// boduhendler is responsible for taking raw response bytes frm server and turrnin into java object
            return switch(response.statusCode()){
                case 200 -> topLuralSightCourses(response);
                case 404 -> List.of();
                default -> throw new RuntimeException("Unexpected value from pluralSight API: " + response.statusCode());
            };
        }catch(IOException | InterruptedException e){
            throw new RuntimeException("COuld not call pluralsight API", e);
        }
    }

    // to get the list object type of pluralSightCource java record
    private static List<PLuralSightCourse> topLuralSightCourses(HttpResponse<String> response) throws JsonProcessingException {
        JavaType returnType = OBJECT_MAPPER.getTypeFactory()
                        .constructCollectionType(List.class, PLuralSightCourse.class);
        return OBJECT_MAPPER.readValue(response.body(), returnType);
    }

}
