package com.example.servicesocial.Mapper;

import com.example.servicesocial.DTO.CommentaireDTO;
import com.example.servicesocial.Entities.Commentaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")

public interface CommentaireMapper {
  CommentaireDTO toDTO(Commentaire commentaire);
  Commentaire toEntity(CommentaireDTO commentaireDTO);
}
