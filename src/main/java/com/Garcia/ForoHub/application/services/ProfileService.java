package com.Garcia.ForoHub.application.services;

import com.Garcia.ForoHub.application.dtos.ProfileDTO;
import com.Garcia.ForoHub.domain.entities.Profile;
import com.Garcia.ForoHub.domain.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setNombre(profileDTO.getNombre());
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, ProfileDTO profileDTO) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            profile.setNombre(profileDTO.getNombre());
            return profileRepository.save(profile);
        }
        return null;
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
