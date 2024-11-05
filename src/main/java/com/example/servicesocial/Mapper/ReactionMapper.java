package com.example.servicesocial.Mapper;

import com.example.servicesocial.DTO.ReactionDTO;
import com.example.servicesocial.Entities.Reaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReactionMapper {
  ReactionDTO toDTO(Reaction reaction);
  Reaction toEntity(ReactionDTO reactionDTO);
}
