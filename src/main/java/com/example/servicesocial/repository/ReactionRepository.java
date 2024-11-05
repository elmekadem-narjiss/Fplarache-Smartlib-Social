package com.example.servicesocial.repository;

import com.example.servicesocial.Entities.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReactionRepository extends MongoRepository<Reaction, String> {
  List<Reaction> findByBookId(String bookId);

}
