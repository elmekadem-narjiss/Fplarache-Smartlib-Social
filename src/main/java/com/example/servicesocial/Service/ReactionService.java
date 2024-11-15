package com.example.servicesocial.Service;

import com.example.servicesocial.DTO.ReactionDTO;
import com.example.servicesocial.Entities.Reaction;
import com.example.servicesocial.Mapper.ReactionMapper;
import com.example.servicesocial.repository.ReactionRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactionService {
  private final ReactionRepository reactionRepository;
  private final ReactionMapper reactionMapper;
  private final SimpMessagingTemplate messagingTemplate; // Pour les notifications WebSocket

  public ReactionService(ReactionRepository reactionRepository,
                         ReactionMapper reactionMapper,
                         SimpMessagingTemplate messagingTemplate) { // Injectez SimpMessagingTemplate
    this.reactionRepository = reactionRepository;
    this.reactionMapper = reactionMapper;
    this.messagingTemplate = messagingTemplate;
  }

  public ReactionDTO ajouterReaction(ReactionDTO reactionDTO) {
    Reaction reaction = reactionMapper.toEntity(reactionDTO);
    Reaction savedReaction = reactionRepository.save(reaction);

    // Notifier via WebSocket
    messagingTemplate.convertAndSend("/topic/reactions", reactionMapper.toDTO(savedReaction));

    return reactionMapper.toDTO(savedReaction);
  }

  public List<ReactionDTO> obtenirReactionsParLivre(Long bookId) {
    return reactionRepository.findByBookId(bookId).stream()
            .map(reactionMapper::toDTO)
            .collect(Collectors.toList());
  }

  // Supprimer une réaction.
  public void supprimerReaction(Long reactionId) {
    if (reactionRepository.existsById(reactionId)) {
      reactionRepository.deleteById(reactionId);
    } else {
      throw new IllegalArgumentException("Reaction ID: " + reactionId + " does not exist.");
    }
  }
}

