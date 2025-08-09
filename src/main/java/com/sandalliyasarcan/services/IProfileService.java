package com.sandalliyasarcan.services;

import com.sandalliyasarcan.dto.profile.ProfileDTO;
import com.sandalliyasarcan.entities.Customer;

public interface IProfileService {
    public ProfileDTO findProfileById(Long profileId);
}
