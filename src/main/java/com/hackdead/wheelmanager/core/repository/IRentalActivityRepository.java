package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.RentalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalActivityRepository extends JpaRepository<RentalActivity, Long> {

}
