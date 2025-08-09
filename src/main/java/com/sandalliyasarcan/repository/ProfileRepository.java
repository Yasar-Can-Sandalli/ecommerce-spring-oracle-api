package com.sandalliyasarcan.repository;

import com.sandalliyasarcan.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository <Profile, Long>{



}
