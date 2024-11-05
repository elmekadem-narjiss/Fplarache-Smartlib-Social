package com.example.servicesocial.repository;

import com.example.servicesocial.Entities.Avis;
import com.example.servicesocial.Entities.Commentaire;
import com.example.servicesocial.Entities.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentaireRepository extends MongoRepository<Commentaire, String> {
  List<Commentaire> findByBookId(String bookId);

}

