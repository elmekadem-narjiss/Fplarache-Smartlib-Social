package com.example.servicesocial.repository;

import com.example.servicesocial.Entities.Avis;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvisRepository extends MongoRepository<Avis, Long> {
  List<Avis> findByBookId(Long bookId);

}
