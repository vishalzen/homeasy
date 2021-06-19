package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.LeaveRequest;
import com.mnnit.homeasy.model.RequestId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, RequestId> {
    List<LeaveRequest> findAllByStatus(int status);
    List<LeaveRequest> findAllByRequestId_RegistrationNoAndStatus(String registrationNo, int status);

}
