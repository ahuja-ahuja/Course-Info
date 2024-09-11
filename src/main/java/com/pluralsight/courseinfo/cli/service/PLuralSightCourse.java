package com.pluralsight.courseinfo.cli.service;


// this is based upon the JSON response which we are getting from the puralsight API


public record PLuralSightCourse(String id, String title, String duration, String contentUrl, boolean isRetired) {
}
