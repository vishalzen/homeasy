package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.RequestId;
import com.mnnit.homeasy.model.RoomRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRequestRepository extends JpaRepository<RoomRequest, RequestId> {
    List<RoomRequest> findAllByStatus(int status);
    List<RoomRequest> findAllByRequestId_RegistrationNoAndStatus(String registrationNo, int status);
}
