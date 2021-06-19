package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessRepository extends JpaRepository<Mess, String> {
    Mess findByRegistrationNumber(String registrationNumber);
}
