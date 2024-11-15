package com.example.servicesocial.controller;

import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

  private final CommentaireService commentaireService;

  @Autowired
  public CommentaireController(CommentaireService commentaireService) {
    this.commentaireService = commentaireService;
  }

  @PostMapping
  public CommentaireDTO ajouterCommentaire(@RequestBody CommentaireDTO commentaireDTO) {
    // Ajout du commentaire et envoi de la notification WebSocket
    CommentaireDTO commentaire = commentaireService.ajouterCommentaire(commentaireDTO);
    // Message WebSocket envoyé par le service
    return commentaire;
  }

  @GetMapping("/livre/{bookId}")
  public List<CommentaireDTO> obtenirCommentairesParLivre(@PathVariable Long bookId) {
    return commentaireService.obtenirCommentairesParLivre(bookId);
  }

  @DeleteMapping("/{commentaireId}")
  public void supprimerCommentaire(@PathVariable Long commentaireId) {
    commentaireService.supprimerCommentaire(commentaireId);
  }

  @PutMapping("/{commentaireId}")
  public CommentaireDTO modifierCommentaire(@PathVariable Long commentaireId, @RequestBody String newContent) {
    return commentaireService.modifierCommentaire(commentaireId, newContent);
  }
}

