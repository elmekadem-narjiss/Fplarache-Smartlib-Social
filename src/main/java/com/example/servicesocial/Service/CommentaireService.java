package com.example.servicesocial.Service;
import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Entities.Commentaire;
import com.example.servicesocial.Mapper.CommentaireMapper;
import com.example.servicesocial.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class CommentaireService {
  private final CommentaireRepository commentaireRepository;
  private final CommentaireMapper commentaireMapper;

  @Autowired
  public CommentaireService(CommentaireRepository commentaireRepository, CommentaireMapper commentaireMapper) {
    this.commentaireRepository = commentaireRepository;
    this.commentaireMapper = commentaireMapper;
  }


  public CommentaireDTO ajouterCommentaire(CommentaireDTO commentaireDTO) {
    Commentaire commentaire = commentaireMapper.toEntity(commentaireDTO);
    commentaire.setTimestamp(LocalDateTime.now());
    return commentaireMapper.toDTO(commentaireRepository.save(commentaire));
  }

  public List<CommentaireDTO> obtenirCommentairesParLivre(String bookId) {
    return commentaireRepository.findByBookId(bookId).stream()
      .map(commentaireMapper::toDTO)
      .collect(Collectors.toList());
  }
}
