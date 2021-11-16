package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query("select c from Subscription c where c.startDate=:startDate")
    List<Subscription> findAllWithStartDate(@Param("startDate") Date startDate);
}
