package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserAddressRepository extends JpaRepository<UserAddress, Long> {
}
