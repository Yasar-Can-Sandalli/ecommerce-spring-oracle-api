package com.sandalliyasarcan.services.impl;

import com.sandalliyasarcan.dto.profile.ProfileDTO;
import com.sandalliyasarcan.entities.Profile;
import com.sandalliyasarcan.repository.ProfileRepository;
import com.sandalliyasarcan.services.IProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements IProfileService {


    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDTO findProfileById(Long profileId) {
        Optional<Profile> profile = profileRepository.findById(profileId);
        if (profile.isPresent()){
            ProfileDTO dtoProfile = new ProfileDTO();
            BeanUtils.copyProperties(profile.get(), dtoProfile);
            dtoProfile.setCustomer(profile.get().getCustomer());
            return dtoProfile;
        }else{
            return null;
        }
    }
}
