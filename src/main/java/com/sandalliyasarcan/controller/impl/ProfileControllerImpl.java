package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.IProfileController;
import com.sandalliyasarcan.dto.profile.ProfileDTO;
import com.sandalliyasarcan.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/profile/")
public class ProfileControllerImpl implements IProfileController {

    @Autowired
    private IProfileService profileService;

    @Override
    @GetMapping(path = "/findProfileById/{id}")
    public ProfileDTO findProfileById(@PathVariable(name = "id" , required = true) Long profileId) {
        return profileService.findProfileById(profileId);
    }
}
