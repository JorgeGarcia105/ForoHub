package com.Garcia.ForoHub.application.services;

import com.Garcia.ForoHub.app.mapper.UserMapper;
import com.Garcia.ForoHub.application.dtos.UserDTO;
import com.Garcia.ForoHub.domain.entities.Profile;
import com.Garcia.ForoHub.domain.entities.User;
import com.Garcia.ForoHub.domain.repositories.ProfileRepository;
import com.Garcia.ForoHub.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository perfilRepository;

    // Obtener todos los usuarios
    public List<UserDTO> getAllUsuarios() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un usuario por ID
    public Optional<UserDTO> getUsuarioById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

   /* // Crear un nuevo usuario
    public UserDTO createUsuario(UserDTO usuarioDTO) {
        // Verificar si el perfil existe
        Profile perfil = (Profile) perfilRepository.findByNombre(usuarioDTO.getPerfilNombre())
                .orElseThrow(() -> new IllegalArgumentException("El perfil especificado no existe: " + usuarioDTO.getPerfilNombre()));

        // Mapear DTO a entidad y guardar
        User user = UserMapper.toEntity(usuarioDTO, perfil);
        userRepository.save(user);

        // Retornar el usuario guardado como DTO
        return UserMapper.toDTO(user);
    }

    // Actualizar un usuario existente
    public UserDTO updateUsuario(Long id, UserDTO usuarioDTO) {
        // Buscar el usuario existente
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));

        // Verificar si el perfil existe
        Profile perfil = (Profile) perfilRepository.findByNombre(usuarioDTO.getPerfilNombre())
                .orElseThrow(() -> new IllegalArgumentException("El perfil especificado no existe: " + usuarioDTO.getPerfilNombre()));

        // Actualizar los campos del usuario
        existingUser.setNombre(usuarioDTO.getNombre());
        existingUser.setEmail(usuarioDTO.getEmail());
        existingUser.setContraseña(usuarioDTO.getContrasena());
        existingUser.setPerfil(perfil);

        // Guardar cambios
        userRepository.save(existingUser);

        // Retornar el usuario actualizado como DTO
        return UserMapper.toDTO(existingUser);
    }*/

    // Eliminar un usuario por ID
    public void deleteUsuario(Long id) {
        // Verificar si el usuario existe antes de eliminar
        if (!userRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public UserDTO createUsuario(UserDTO usuarioDTO) {
        return null;
    }

    public UserDTO updateUsuario(Long id, UserDTO usuarioDTO) {
        return null;
    }
}