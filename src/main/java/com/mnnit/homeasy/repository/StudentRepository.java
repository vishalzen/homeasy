package com.mnnit.homeasy.repository;

import com.mnnit.homeasy.model.Student;
import com.mnnit.homeasy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("select room from Student where hostelId = ?1")
    List<Integer> findRoomByHostelId(int hostelId);

    Student findStudentByUser(User user);
    Student findStudentByRegistrationNumber(String regnNo);

    List<Student> findAllByHostelIdAndRoom(int hostelId, int room);

}