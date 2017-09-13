package com.api.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.api.model.Course;

@Repository
public class CourseRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	public Course retrieveCourse(String id) {
		Criteria criteria = Criteria.where("_id").is(id);
		return mongoTemplate.findOne(new Query(criteria), Course.class);
	}
	
	public List<Course> retrieveAllCourse() {
		Criteria criteria = new Criteria();
		return mongoTemplate.find(new Query(criteria), Course.class);
	}
	
	public void createCourse(Course course) {
        mongoTemplate.save(course);
    }

	public void deleteCourse(String id) {
		Criteria criteria = Criteria.where("_id").is(id);
		 mongoTemplate.remove(new Query(criteria), Course.class);
		
	}

	public void updateCourse(Course course, String id) {
		Criteria criteria = Criteria.where("_id").is(id);
		mongoTemplate.remove(new Query(criteria), Course.class);
        mongoTemplate.save(course);
	}

}
