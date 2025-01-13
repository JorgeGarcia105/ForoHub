package com.Garcia.ForoHub.app.mapper;

import com.Garcia.ForoHub.application.dtos.ProfileDTO;
import com.Garcia.ForoHub.domain.entities.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public ProfileDTO toDTO(Profile profile) {
        return new ProfileDTO(profile.getId(), profile.getNombre());
    }

    public Profile toEntity(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setId(profileDTO.getId());
        profile.setNombre(profileDTO.getNombre());
        return profile;
    }
}
