package com.example.servicesocial.Service;

import com.example.servicesocial.DTO.ReactionDTO;
import com.example.servicesocial.Entities.Reaction;
import com.example.servicesocial.Mapper.ReactionMapper;
import com.example.servicesocial.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactionService {
  @Autowired
  private ReactionRepository reactionRepository;

  @Autowired
  private ReactionMapper reactionMapper;

  public ReactionDTO ajouterReaction(ReactionDTO reactionDTO) {
    Reaction reaction = reactionMapper.toEntity(reactionDTO);
    return reactionMapper.toDTO(reactionRepository.save(reaction));
  }

  public List<ReactionDTO> obtenirReactionsParLivre(String bookId) {
    return reactionRepository.findByBookId(bookId).stream()
      .map(reactionMapper::toDTO)
      .collect(Collectors.toList());
  }
}
