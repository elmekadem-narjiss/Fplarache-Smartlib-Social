package com.example.servicesocial.Service;
import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Entities.Commentaire;
import com.example.servicesocial.Mapper.CommentaireMapper;
import com.example.servicesocial.repository.CommentaireRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentaireService {

  private final CommentaireRepository commentaireRepository;
  private final CommentaireMapper commentaireMapper;
  private final SimpMessagingTemplate messagingTemplate; // Ajoutez ceci pour WebSocket

  public CommentaireService(CommentaireRepository commentaireRepository,
                            CommentaireMapper commentaireMapper,
                            SimpMessagingTemplate messagingTemplate) { // Injectez SimpMessagingTemplate
    this.commentaireRepository = commentaireRepository;
    this.commentaireMapper = commentaireMapper;
    this.messagingTemplate = messagingTemplate;
  }

  public CommentaireDTO ajouterCommentaire(CommentaireDTO commentaireDTO) {
    Commentaire commentaire = commentaireMapper.toEntity(commentaireDTO);
    commentaire.setCreationDate(LocalDateTime.now());
    Commentaire savedCommentaire = commentaireRepository.save(commentaire);

    // Notifier via WebSocket
    messagingTemplate.convertAndSend("/topic/commentaires", commentaireMapper.toDTO(savedCommentaire));

    return commentaireMapper.toDTO(savedCommentaire);
  }

  public List<CommentaireDTO> obtenirCommentairesParLivre(Long bookId) {
    return commentaireRepository.findByBookId(bookId).stream()
            .map(commentaireMapper::toDTO)
            .collect(Collectors.toList());
  }

  public void supprimerCommentaire(Long commentaireId) {
    if (commentaireRepository.existsById(commentaireId)) {
      commentaireRepository.deleteById(commentaireId);
    } else {
      throw new IllegalArgumentException("Commentaire ID: " + commentaireId + " does not exist.");
    }
  }

  public CommentaireDTO modifierCommentaire(Long commentaireId, String newContent) {
    Commentaire commentaire = commentaireRepository.findById(commentaireId)
            .orElseThrow(() -> new IllegalArgumentException("Commentaire ID: " + commentaireId + " does not exist."));

    commentaire.setContent(newContent);
    commentaire.setCreationDate(LocalDateTime.now());

    return commentaireMapper.toDTO(commentaireRepository.save(commentaire));
  }

}
