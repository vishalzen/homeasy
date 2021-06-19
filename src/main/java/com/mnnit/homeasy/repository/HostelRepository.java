package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository <Hostel, Integer> {
    Hostel findById(int id);
}
