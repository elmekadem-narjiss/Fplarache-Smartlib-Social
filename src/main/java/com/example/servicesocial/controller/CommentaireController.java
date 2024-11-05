package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {
  @Autowired
  private CommentaireService commentaireService;

  @PostMapping
  public CommentaireDTO ajouterCommentaire(@RequestBody CommentaireDTO commentaireDTO) {
    return commentaireService.ajouterCommentaire(commentaireDTO);
  }

  @GetMapping("/livre/{bookId}")
  public List<CommentaireDTO> obtenirCommentairesParLivre(@PathVariable String bookId) {
    return commentaireService.obtenirCommentairesParLivre(bookId);
  }
}
