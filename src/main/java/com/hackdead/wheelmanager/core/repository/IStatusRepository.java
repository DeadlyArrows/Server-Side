package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Long> {
    List<Status> findByStatusName(String statusName);
}
