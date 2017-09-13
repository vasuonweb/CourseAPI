package com.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Course;
import com.api.repositories.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;
	
	 @Autowired
	    public CourseService(CourseRepository courseRepository){
		 this.courseRepository= courseRepository;
	 }
	 

	private List<Course> courses= new ArrayList<>(Arrays.asList(
			new Course("1","Spring","Spring tutorial"),
			new Course("3","Java","Java tutorial")
			));
	
	public List<Course> getAllCourses(){
		return courseRepository.retrieveAllCourse();
	}

	public Course getCourse(String id) {
		//return courses.stream().filter(c->c.getCourseId().equals(id)).findFirst().get();
		return courseRepository.retrieveCourse(id);
	}

	public void addCourse(Course course) {
		courseRepository.createCourse(course);
		//courses.add(course);
	}

	public void updateCourse(Course course, String id) {
		/*Course c= courses.stream().filter(cs->cs.getCourseId().equals(id)).findFirst().get();
		c.setCourseId(course.getCourseId());
		c.setName(course.getName());
		c.setDescription(course.getDescription());
		return;*/
		courseRepository.updateCourse(course,id);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteCourse(id);
		//courses.removeIf(cs->cs.getCourseId().equals(id));
		
	}
}
