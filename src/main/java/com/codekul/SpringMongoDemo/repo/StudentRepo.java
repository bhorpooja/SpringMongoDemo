package com.codekul.SpringMongoDemo.repo;

import com.codekul.SpringMongoDemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by pooja on 5/12/17.
 */
public interface StudentRepo extends MongoRepository<Student,String> {

    Student findByName(String name);

    Student findByCity(String city);

    @Query("{$text:{$search:?0}}")
    List<Student> find(String searchData);

}
