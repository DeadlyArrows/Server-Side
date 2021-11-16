package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByBrandName(String brandName);
}
