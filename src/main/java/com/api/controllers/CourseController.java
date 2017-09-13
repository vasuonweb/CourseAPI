package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.api.model.Course;
import com.api.services.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@Api(value = "CoursesControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/api/course")
	@ApiOperation(value="getAllCoursesAvailable", notes="Gets All the courses")
	public List<Course> allCourses(){
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/allcourses")
	@ApiOperation(value="getAllCoursesList", notes="Gets All the courses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/api/course/{id}")
	@ApiOperation(value = "getCourseById", notes="Get the course by Id")
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/api/course")
	@ApiOperation(value = "addCourseToList", notes="add the course")
	public void addCourse(@RequestBody Course course){
		 courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/api/course/{id}")
	@ApiOperation(value = "updateCourseById", notes="update the course by Id")

	public void updateCourse(@RequestBody Course course,@PathVariable String id){
		 courseService.updateCourse(course,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/api/course/{id}")
	@ApiOperation(value = "deleteCourseById", notes="delete the course by Id")
	public void deleteCourse(@PathVariable String id){
		 courseService.deleteCourse(id);
	}
}
