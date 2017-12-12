package com.codekul.SpringMongoDemo.repo;

import com.codekul.SpringMongoDemo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pooja on 7/12/17.
 */
public interface BookRepo extends MongoRepository<Book,String>{

    Book findByName(String name);
}
