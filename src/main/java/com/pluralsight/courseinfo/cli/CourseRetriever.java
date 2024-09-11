package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import com.pluralsight.courseinfo.cli.service.PLuralSightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourseRetriever {

    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String... args) {
        LOG.info("CourseReterivel Starting");
        if(args.length == 0){
            LOG.warn("Please provide an author name as first argument");
            return;
        }
        try{
            //retrieveCourses(args[0]);
        }catch(Exception e){
            LOG.error("Unexpected error",e);

        }
    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'",authorId);  //loginfo feature to set sg like this
        CourseRetrievalService courseRetrieverService = new CourseRetrievalService();
        List<PLuralSightCourse> couresToStore = courseRetrieverService.getCoursesFor(authorId);
        LOG.info("reterieval of the records");
    }
}
