package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.dto.profile.ProfileDTO;

public interface IProfileController {
    ProfileDTO findProfileById(Long profileId);
}
