package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.MessRequest;
import com.mnnit.homeasy.model.RequestId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessRequestRepository extends JpaRepository<MessRequest, RequestId> {
    List<MessRequest> findAllByStatus(int status);
    List<MessRequest> findAllByRequestId_RegistrationNoAndStatus(String registrationNo, int status);
}
