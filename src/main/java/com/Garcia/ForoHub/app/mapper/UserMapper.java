package com.Garcia.ForoHub.app.mapper;

import com.Garcia.ForoHub.application.dtos.UserDTO;
import com.Garcia.ForoHub.domain.entities.Profile;
import com.Garcia.ForoHub.domain.entities.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setEmail(user.getEmail());
        dto.setPerfilNombre(user.getPerfil().getName());
        return dto;
    }

    public static User toEntity(UserDTO dto, Profile perfil) {
        User user = new User();
        user.setId(dto.getId());
        user.setNombre(dto.getNombre());
        user.setEmail(dto.getEmail());
        user.setContraseña(dto.getContraseña());
        //user.setPerfil(perfil);
        return user;
    }
}